package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean baV = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract int NA();

    public abstract boolean Nz();

    public boolean a(d dVar) {
        if (dVar == null || dVar.ND()) {
            return false;
        }
        if (dVar.baW) {
            dVar.V(c.f(dVar.NB(), 6));
        } else {
            int NG = NA() > e.NE().NG() ? e.NE().NG() : NA();
            dVar.V(c.f(dVar.NB(), NG <= 5 ? NG : 5));
        }
        return true;
    }

    private void cr(boolean z) {
        if (this.baV != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.baV = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.baV;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            cr(false);
            return false;
        } else if (!e.NE().NF()) {
            cr(false);
            return false;
        } else {
            cr(true);
            return true;
        }
    }
}
