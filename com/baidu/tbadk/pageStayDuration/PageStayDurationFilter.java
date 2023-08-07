package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class PageStayDurationFilter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIX_MAX_COST = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSwitchOpen;

    public abstract int getMaxCost();

    public abstract boolean isCurrentPageCanBeAddToSourceTrace();

    public PageStayDurationFilter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isSwitchOpen = SharedPrefHelper.getInstance().getBoolean("page_stay_duration_switch", false);
    }

    private void updataSwitchStaus(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65537, this, z) == null) && this.isSwitchOpen != z) {
            SharedPrefHelper.getInstance().putBoolean("page_stay_duration_switch", true);
            this.isSwitchOpen = z;
        }
    }

    public boolean canStat(PageStayDurationItem pageStayDurationItem) {
        InterceptResult invokeL;
        int maxCost;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pageStayDurationItem)) == null) {
            if (pageStayDurationItem != null && !pageStayDurationItem.isDirtyData()) {
                if (pageStayDurationItem.isRouteStat) {
                    pageStayDurationItem.setSorceKeyList(PageStayDurationHelper.trimToSize(pageStayDurationItem.getSorceKeyList(), 6));
                } else {
                    if (getMaxCost() > PageStayDurationStat.getInstance().getMaxCostFromServer()) {
                        maxCost = PageStayDurationStat.getInstance().getMaxCostFromServer();
                    } else {
                        maxCost = getMaxCost();
                    }
                    if (maxCost > 5) {
                        maxCost = 5;
                    }
                    pageStayDurationItem.setSorceKeyList(PageStayDurationHelper.trimToSize(pageStayDurationItem.getSorceKeyList(), maxCost));
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return this.isSwitchOpen;
            }
            if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
                updataSwitchStaus(false);
                return false;
            } else if (!PageStayDurationStat.getInstance().isSmallFlowOpen()) {
                updataSwitchStaus(false);
                return false;
            } else {
                updataSwitchStaus(true);
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
