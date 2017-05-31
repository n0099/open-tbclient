package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aFh = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean ET();

    public abstract int EU();

    public boolean a(d dVar) {
        if (dVar == null || dVar.EY()) {
            return false;
        }
        if (dVar.aFi) {
            dVar.A(c.e(dVar.EW(), 6));
        } else {
            int Fb = EU() > e.EZ().Fb() ? e.EZ().Fb() : EU();
            dVar.A(c.e(dVar.EW(), Fb <= 5 ? Fb : 5));
        }
        return true;
    }

    private void bT(boolean z) {
        if (this.aFh != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aFh = z;
        }
    }

    public boolean EV() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.aFh;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bT(false);
            return false;
        } else if (!e.EZ().Fa()) {
            bT(false);
            return false;
        } else {
            bT(true);
            return true;
        }
    }
}
