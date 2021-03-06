package cn.cncic.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.cncic.models.Menu;



interface MenuRepository extends PagingAndSortingRepository<Menu, Long>{
	/*
	 * 通过jsdid查询菜单
	 */
	  @Query("select a from Menu a where jsdid=?1  order by id")
	List<Menu> findByJsdid(long jsdid);
	
	/*
	 * 通过技术点名称和菜单名称查询菜单
	 */
   List<Menu>	findByJsdidAndName(long jsdid,String name);
	
	/*
	 * 通过父菜单id查询菜单
	 */
   @Query("select a from Menu a where fid=?1  order by id")
	List<Menu> findByFid(long fid);
	
	
	/*
	 * 通过jsdid查询是最后一级的菜单
	 */
	@Query("select id, name from Menu where jsdid=?1 and isend = ?2 order by id")
	List<Menu> findByJsdidAndIsend(long jsdid,int yorn);
	
}