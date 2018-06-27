package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aTg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Km();

    public abstract int Kn();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Kq()) {
            return false;
        }
        if (dVar.aTh) {
            dVar.M(c.f(dVar.Ko(), 6));
        } else {
            int Kt = Kn() > e.Kr().Kt() ? e.Kr().Kt() : Kn();
            dVar.M(c.f(dVar.Ko(), Kt <= 5 ? Kt : 5));
        }
        return true;
    }

    private void bX(boolean z) {
        if (this.aTg != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aTg = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aTg;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bX(false);
            return false;
        } else if (!e.Kr().Ks()) {
            bX(false);
            return false;
        } else {
            bX(true);
            return true;
        }
    }
}
