package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean bfW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Pf();

    public abstract int Pg();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Pj()) {
            return false;
        }
        if (dVar.bfX) {
            dVar.V(c.f(dVar.Ph(), 6));
        } else {
            int Pm = Pg() > e.Pk().Pm() ? e.Pk().Pm() : Pg();
            dVar.V(c.f(dVar.Ph(), Pm <= 5 ? Pm : 5));
        }
        return true;
    }

    private void cM(boolean z) {
        if (this.bfW != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.bfW = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.bfW;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            cM(false);
            return false;
        } else if (!e.Pk().Pl()) {
            cM(false);
            return false;
        } else {
            cM(true);
            return true;
        }
    }
}
