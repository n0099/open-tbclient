package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aAD = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FF();

    public abstract int FG();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FK()) {
            return false;
        }
        if (dVar.aAE) {
            dVar.D(c.e(dVar.FI(), 6));
        } else {
            int FN = FG() > e.FL().FN() ? e.FL().FN() : FG();
            dVar.D(c.e(dVar.FI(), FN <= 5 ? FN : 5));
        }
        return true;
    }

    private void bR(boolean z) {
        if (this.aAD != z) {
            com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("page_stay_duration_switch", true);
            this.aAD = z;
        }
    }

    public boolean FH() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.aAD;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bR(false);
            return false;
        } else if (!e.FL().FM()) {
            bR(false);
            return false;
        } else {
            bR(true);
            return true;
        }
    }
}
