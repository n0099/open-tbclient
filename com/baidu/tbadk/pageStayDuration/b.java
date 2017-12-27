package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean bwX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Nq();

    public abstract int Nr();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Nu()) {
            return false;
        }
        if (dVar.bwY) {
            dVar.Q(c.h(dVar.Ns(), 6));
        } else {
            int Nx = Nr() > e.Nv().Nx() ? e.Nv().Nx() : Nr();
            dVar.Q(c.h(dVar.Ns(), Nx <= 5 ? Nx : 5));
        }
        return true;
    }

    private void cv(boolean z) {
        if (this.bwX != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.bwX = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.bwX;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            cv(false);
            return false;
        } else if (!e.Nv().Nw()) {
            cv(false);
            return false;
        } else {
            cv(true);
            return true;
        }
    }
}
