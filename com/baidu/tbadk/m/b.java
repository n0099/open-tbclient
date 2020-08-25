package com.baidu.tbadk.m;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public abstract class b {
    private boolean isSwitchOpen = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.PAGE_STAY_DURATION_SWITCH, false);

    public abstract int getMaxCost();

    public abstract boolean isCurrentPageCanBeAddToSourceTrace();

    public boolean a(d dVar) {
        if (dVar == null || dVar.isDirtyData()) {
            return false;
        }
        if (dVar.isRouteStat) {
            dVar.setSorceKeyList(c.trimToSize(dVar.getSorceKeyList(), 6));
        } else {
            int maxCostFromServer = getMaxCost() > e.btZ().getMaxCostFromServer() ? e.btZ().getMaxCostFromServer() : getMaxCost();
            dVar.setSorceKeyList(c.trimToSize(dVar.getSorceKeyList(), maxCostFromServer <= 5 ? maxCostFromServer : 5));
        }
        return true;
    }

    private void updataSwitchStaus(boolean z) {
        if (this.isSwitchOpen != z) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.PAGE_STAY_DURATION_SWITCH, true);
            this.isSwitchOpen = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.isSwitchOpen;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            updataSwitchStaus(false);
            return false;
        } else if (!e.btZ().isSmallFlowOpen()) {
            updataSwitchStaus(false);
            return false;
        } else {
            updataSwitchStaus(true);
            return true;
        }
    }
}
