package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aHD = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FG();

    public abstract int FH();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FL()) {
            return false;
        }
        if (dVar.aHE) {
            dVar.G(c.e(dVar.FJ(), 6));
        } else {
            int FO = FH() > e.FM().FO() ? e.FM().FO() : FH();
            dVar.G(c.e(dVar.FJ(), FO <= 5 ? FO : 5));
        }
        return true;
    }

    private void bY(boolean z) {
        if (this.aHD != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aHD = z;
        }
    }

    public boolean FI() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aHD;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bY(false);
            return false;
        } else if (!e.FM().FN()) {
            bY(false);
            return false;
        } else {
            bY(true);
            return true;
        }
    }
}
