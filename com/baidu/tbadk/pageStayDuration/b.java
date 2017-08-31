package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aIy = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FM();

    public abstract int FN();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FR()) {
            return false;
        }
        if (dVar.aIz) {
            dVar.G(c.e(dVar.FP(), 6));
        } else {
            int FU = FN() > e.FS().FU() ? e.FS().FU() : FN();
            dVar.G(c.e(dVar.FP(), FU <= 5 ? FU : 5));
        }
        return true;
    }

    private void bY(boolean z) {
        if (this.aIy != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aIy = z;
        }
    }

    public boolean FO() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aIy;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bY(false);
            return false;
        } else if (!e.FS().FT()) {
            bY(false);
            return false;
        } else {
            bY(true);
            return true;
        }
    }
}
