package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.k35;
import com.baidu.tieba.mo5;
import com.baidu.tieba.qd;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class PageStayDurationStat {
    public static /* synthetic */ Interceptable $ic;
    public static PageStayDurationStat stayDurationStat;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSmallFlowOpen;
    public boolean isSmartStat;
    public int maxCost;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1082424805, "Lcom/baidu/tbadk/pageStayDuration/PageStayDurationStat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1082424805, "Lcom/baidu/tbadk/pageStayDuration/PageStayDurationStat;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends PageStayDurationFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 6;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(PageStayDurationStat pageStayDurationStat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pageStayDurationStat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends PageStayDurationFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PageStayDurationStat a;

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public b(PageStayDurationStat pageStayDurationStat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pageStayDurationStat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pageStayDurationStat;
        }

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.maxCost;
            }
            return invokeV.intValue;
        }
    }

    public PageStayDurationStat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSmallFlowOpen = true;
        this.isSmartStat = false;
    }

    public static PageStayDurationStat getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (stayDurationStat == null) {
                synchronized (PageStayDurationStat.class) {
                    if (stayDurationStat == null) {
                        stayDurationStat = new PageStayDurationStat();
                    }
                }
            }
            return stayDurationStat;
        }
        return (PageStayDurationStat) invokeV.objValue;
    }

    public int getMaxCostFromServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return SharedPrefHelper.getInstance().getInt("page_stay_max_cost", 0);
            }
            return this.maxCost;
        }
        return invokeV.intValue;
    }

    public boolean isSmallFlowOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isSmallFlowOpen;
        }
        return invokeV.booleanValue;
    }

    public boolean isSmartStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.isSmartStat;
        }
        return invokeV.booleanValue;
    }

    private boolean isSecondJumpFromSearch(List<String> list) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, list)) == null) {
            if (ListUtils.isEmpty(list) || (size = list.size()) < 2 || !"a026".equals(list.get(size - 2))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setMaxCostFromServer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.maxCost = i;
            SharedPrefHelper.getInstance().putInt("page_stay_max_cost", this.maxCost);
        }
    }

    public void setSamllFlowOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.isSmallFlowOpen = z;
        }
    }

    public void setSmartStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isSmartStat = z;
        }
    }

    private boolean isInTwoJumpFromSearch(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (!"a026".equals(list.get(list.size() - 1)) && !isSecondJumpFromSearch(list)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void stat(Context context, PageStayDurationItem pageStayDurationItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, pageStayDurationItem) == null) {
            stat(context, pageStayDurationItem, null);
        }
    }

    public void stat(Context context, PageStayDurationItem pageStayDurationItem, PageStayDurationFilter pageStayDurationFilter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, context, pageStayDurationItem, pageStayDurationFilter) == null) && pageStayDurationItem != null && !StringUtils.isNull(pageStayDurationItem.getCurrentPageKey())) {
            if (pageStayDurationItem.isRouteStat) {
                if (pageStayDurationFilter == null) {
                    pageStayDurationFilter = new a(this);
                }
                if (!pageStayDurationFilter.canStat(pageStayDurationItem)) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("userconvert");
                statisticItem.param("obj_source", PageStayDurationHelper.toSourceTraceString(pageStayDurationItem.getSorceKeyList()));
                statisticItem.param("obj_locate", pageStayDurationItem.getCurrentPageKey());
                statisticItem.param("obj_type", "0");
                if (!StringUtils.isNull(pageStayDurationItem.objID)) {
                    statisticItem.param("obj_id", pageStayDurationItem.objID);
                }
                if (pageStayDurationItem.getAdSource() != 0) {
                    statisticItem.param("ad_source", pageStayDurationItem.getAdSource());
                }
                mo5.b(context, statisticItem, pageStayDurationItem);
                TiebaStatic.log(statisticItem);
                return;
            }
            if (pageStayDurationFilter == null) {
                pageStayDurationFilter = new b(this);
            }
            if (!pageStayDurationFilter.isSwitchOpen() || !pageStayDurationFilter.canStat(pageStayDurationItem)) {
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("stime");
            statisticItem2.param("obj_source", PageStayDurationHelper.toSourceTraceString(pageStayDurationItem.getSorceKeyList()));
            statisticItem2.param("obj_type", pageStayDurationItem.getCurrentPageKey());
            statisticItem2.param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(pageStayDurationItem.getStayDurationTime()));
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            if (!StringUtils.isNull(pageStayDurationItem.getTopicId())) {
                statisticItem2.param("topic_id", pageStayDurationItem.getTopicId());
            }
            if (!StringUtils.isNull(pageStayDurationItem.getTopicSubjectName())) {
                statisticItem2.param(TiebaStatic.Params.TOPIC_TYPE, pageStayDurationItem.getTopicSubjectName());
            }
            if (pageStayDurationItem.getFid() > 0) {
                statisticItem2.param("fid", String.valueOf(pageStayDurationItem.getFid()));
            }
            if (pageStayDurationItem.getTid() > 0) {
                statisticItem2.param("tid", String.valueOf(pageStayDurationItem.getTid()));
            }
            if (pageStayDurationItem.getThreadType() > 0) {
                statisticItem2.param("thread_type", String.valueOf(pageStayDurationItem.getThreadType()));
            }
            if (!StringUtils.isNull(pageStayDurationItem.getNid())) {
                statisticItem2.param("nid", pageStayDurationItem.getNid());
            }
            if (pageStayDurationItem.getPid() > 0) {
                statisticItem2.param("pid", String.valueOf(pageStayDurationItem.getPid()));
            }
            if (!StringUtils.isNull(pageStayDurationItem.objParam1)) {
                statisticItem2.param("obj_param1", pageStayDurationItem.objParam1);
            }
            if (!StringUtils.isNull(pageStayDurationItem.isVertical)) {
                statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, pageStayDurationItem.isVertical);
            }
            if (!StringUtils.isNull(pageStayDurationItem.isDynamic)) {
                statisticItem2.param("is_dynamic", pageStayDurationItem.isDynamic);
            }
            if (!StringUtils.isNull(pageStayDurationItem.resourceId)) {
                statisticItem2.param("resource_id", pageStayDurationItem.resourceId);
            }
            if (!StringUtils.isNull(pageStayDurationItem.resourceType)) {
                statisticItem2.param("resource_type", pageStayDurationItem.resourceType);
            }
            if (!qd.isEmpty(pageStayDurationItem.getTaskId())) {
                statisticItem2.param("task_id", String.valueOf(pageStayDurationItem.getTaskId()));
            }
            if (!qd.isEmpty(pageStayDurationItem.getAbTag())) {
                statisticItem2.param("ab_tag", pageStayDurationItem.getAbTag());
            }
            if (isSmartStat()) {
                if (!StringUtils.isNull(pageStayDurationItem.objID)) {
                    statisticItem2.param("obj_id", pageStayDurationItem.objID);
                }
                if (!StringUtils.isNull(pageStayDurationItem.objNAME)) {
                    statisticItem2.param("obj_name", pageStayDurationItem.objNAME);
                }
                statisticItem2.param("obj_source", "a002");
            }
            if (!StringUtils.isNull(pageStayDurationItem.getObjLocation())) {
                statisticItem2.param("obj_location", pageStayDurationItem.getObjLocation());
            }
            if (pageStayDurationItem.getAdSource() != 0) {
                statisticItem2.param("ad_source", pageStayDurationItem.getAdSource());
            }
            String fromWhichSearchSource = TbSingleton.getInstance().getFromWhichSearchSource();
            if (!StringUtils.isNull(fromWhichSearchSource) && pageStayDurationItem.getSorceKeyList() != null && isInTwoJumpFromSearch(pageStayDurationItem.getSorceKeyList())) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, fromWhichSearchSource);
                if (isSecondJumpFromSearch(pageStayDurationItem.getSorceKeyList())) {
                    TbSingleton.getInstance().setFromWhichSearchSource("");
                }
            }
            mo5.b(context, statisticItem2, pageStayDurationItem);
            TiebaStatic.log(statisticItem2);
            TiebaStatic.log(new StatisticItem("PushOptTime").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(pageStayDurationItem.getStayDurationTime())).param("obj_source", PageStayDurationHelper.toSourceTraceString(pageStayDurationItem.getSorceKeyList())).param("obj_locate", pageStayDurationItem.getCurrentPageKey()).param("obj_param1", k35.a().b()));
        }
    }
}
