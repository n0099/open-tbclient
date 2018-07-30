package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aTg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Kh();

    public abstract int Ki();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Kl()) {
            return false;
        }
        if (dVar.aTh) {
            dVar.L(c.f(dVar.Kj(), 6));
        } else {
            int Ko = Ki() > e.Km().Ko() ? e.Km().Ko() : Ki();
            dVar.L(c.f(dVar.Kj(), Ko <= 5 ? Ko : 5));
        }
        return true;
    }

    private void bV(boolean z) {
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
            bV(false);
            return false;
        } else if (!e.Km().Kn()) {
            bV(false);
            return false;
        } else {
            bV(true);
            return true;
        }
    }
}
