package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean bbI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean NI();

    public abstract int NJ();

    public boolean a(d dVar) {
        if (dVar == null || dVar.NM()) {
            return false;
        }
        if (dVar.bbJ) {
            dVar.U(c.f(dVar.NK(), 6));
        } else {
            int NP = NJ() > e.NN().NP() ? e.NN().NP() : NJ();
            dVar.U(c.f(dVar.NK(), NP <= 5 ? NP : 5));
        }
        return true;
    }

    private void cI(boolean z) {
        if (this.bbI != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.bbI = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.bbI;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            cI(false);
            return false;
        } else if (!e.NN().NO()) {
            cI(false);
            return false;
        } else {
            cI(true);
            return true;
        }
    }
}
