package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aFu = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("page_stay_duration_switch", false);

    public abstract boolean EZ();

    public abstract int Fa();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Fe()) {
            return false;
        }
        if (dVar.aFv) {
            dVar.A(c.e(dVar.Fc(), 6));
        } else {
            int Fh = Fa() > e.Ff().Fh() ? e.Ff().Fh() : Fa();
            dVar.A(c.e(dVar.Fc(), Fh <= 5 ? Fh : 5));
        }
        return true;
    }

    private void bW(boolean z) {
        if (this.aFu != z) {
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("page_stay_duration_switch", true);
            this.aFu = z;
        }
    }

    public boolean Fb() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.aFu;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bW(false);
            return false;
        } else if (!e.Ff().Fg()) {
            bW(false);
            return false;
        } else {
            bW(true);
            return true;
        }
    }
}
