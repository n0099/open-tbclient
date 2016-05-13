package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean awp = com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Ee();

    public abstract int Ef();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Ej()) {
            return false;
        }
        int Em = Ef() > e.Ek().Em() ? e.Ek().Em() : Ef();
        dVar.C(c.e(dVar.Eh(), Em <= 5 ? Em : 5));
        return true;
    }

    private void bO(boolean z) {
        if (this.awp != z) {
            com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("page_stay_duration_switch", true);
            this.awp = z;
        }
    }

    public boolean Eg() {
        if (!TbadkCoreApplication.m11getInst().isMainProcess(true)) {
            return this.awp;
        }
        if (!TbadkCoreApplication.m11getInst().isPageStayOpen()) {
            bO(false);
            return false;
        } else if (!e.Ek().El()) {
            bO(false);
            return false;
        } else {
            bO(true);
            return true;
        }
    }
}
