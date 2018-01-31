package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean bxp = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Ng();

    public abstract int Nh();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Nk()) {
            return false;
        }
        if (dVar.bxq) {
            dVar.O(c.h(dVar.Ni(), 6));
        } else {
            int Nn = Nh() > e.Nl().Nn() ? e.Nl().Nn() : Nh();
            dVar.O(c.h(dVar.Ni(), Nn <= 5 ? Nn : 5));
        }
        return true;
    }

    private void cu(boolean z) {
        if (this.bxp != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.bxp = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.bxp;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            cu(false);
            return false;
        } else if (!e.Nl().Nm()) {
            cu(false);
            return false;
        } else {
            cu(true);
            return true;
        }
    }
}
