package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aIT = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FO();

    public abstract int FP();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FT()) {
            return false;
        }
        if (dVar.aIU) {
            dVar.G(c.e(dVar.FR(), 6));
        } else {
            int FW = FP() > e.FU().FW() ? e.FU().FW() : FP();
            dVar.G(c.e(dVar.FR(), FW <= 5 ? FW : 5));
        }
        return true;
    }

    private void bY(boolean z) {
        if (this.aIT != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aIT = z;
        }
    }

    public boolean FQ() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aIT;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bY(false);
            return false;
        } else if (!e.FU().FV()) {
            bY(false);
            return false;
        } else {
            bY(true);
            return true;
        }
    }
}
