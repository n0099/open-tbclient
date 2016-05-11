package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean awp = com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Ed();

    public abstract int Ee();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Ei()) {
            return false;
        }
        int El = Ee() > e.Ej().El() ? e.Ej().El() : Ee();
        dVar.C(c.e(dVar.Eg(), El <= 5 ? El : 5));
        return true;
    }

    private void bO(boolean z) {
        if (this.awp != z) {
            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("page_stay_duration_switch", true);
            this.awp = z;
        }
    }

    public boolean Ef() {
        if (!TbadkCoreApplication.m11getInst().isMainProcess(true)) {
            return this.awp;
        }
        if (!TbadkCoreApplication.m11getInst().isPageStayOpen()) {
            bO(false);
            return false;
        } else if (!e.Ej().Ek()) {
            bO(false);
            return false;
        } else {
            bO(true);
            return true;
        }
    }
}
