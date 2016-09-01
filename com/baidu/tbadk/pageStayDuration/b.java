package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aBa = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FG();

    public abstract int FH();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FL()) {
            return false;
        }
        if (dVar.aBb) {
            dVar.D(c.e(dVar.FJ(), 6));
        } else {
            int FO = FH() > e.FM().FO() ? e.FM().FO() : FH();
            dVar.D(c.e(dVar.FJ(), FO <= 5 ? FO : 5));
        }
        return true;
    }

    private void bS(boolean z) {
        if (this.aBa != z) {
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("page_stay_duration_switch", true);
            this.aBa = z;
        }
    }

    public boolean FI() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.aBa;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bS(false);
            return false;
        } else if (!e.FM().FN()) {
            bS(false);
            return false;
        } else {
            bS(true);
            return true;
        }
    }
}
