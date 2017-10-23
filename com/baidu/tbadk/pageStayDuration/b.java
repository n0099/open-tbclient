package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aHJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Fl();

    public abstract int Fm();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Fq()) {
            return false;
        }
        if (dVar.aHK) {
            dVar.F(c.e(dVar.Fo(), 6));
        } else {
            int Ft = Fm() > e.Fr().Ft() ? e.Fr().Ft() : Fm();
            dVar.F(c.e(dVar.Fo(), Ft <= 5 ? Ft : 5));
        }
        return true;
    }

    private void bW(boolean z) {
        if (this.aHJ != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aHJ = z;
        }
    }

    public boolean Fn() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aHJ;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bW(false);
            return false;
        } else if (!e.Fr().Fs()) {
            bW(false);
            return false;
        } else {
            bW(true);
            return true;
        }
    }
}
