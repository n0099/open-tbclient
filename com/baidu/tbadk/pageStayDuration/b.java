package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aTg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Kl();

    public abstract int Km();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Kp()) {
            return false;
        }
        if (dVar.aTh) {
            dVar.L(c.f(dVar.Kn(), 6));
        } else {
            int Ks = Km() > e.Kq().Ks() ? e.Kq().Ks() : Km();
            dVar.L(c.f(dVar.Kn(), Ks <= 5 ? Ks : 5));
        }
        return true;
    }

    private void bW(boolean z) {
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
            bW(false);
            return false;
        } else if (!e.Kq().Kr()) {
            bW(false);
            return false;
        } else {
            bW(true);
            return true;
        }
    }
}
