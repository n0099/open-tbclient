package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aHW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Fr();

    public abstract int Fs();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Fw()) {
            return false;
        }
        if (dVar.aHX) {
            dVar.F(c.e(dVar.Fu(), 6));
        } else {
            int Fz = Fs() > e.Fx().Fz() ? e.Fx().Fz() : Fs();
            dVar.F(c.e(dVar.Fu(), Fz <= 5 ? Fz : 5));
        }
        return true;
    }

    private void bX(boolean z) {
        if (this.aHW != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aHW = z;
        }
    }

    public boolean Ft() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aHW;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bX(false);
            return false;
        } else if (!e.Fx().Fy()) {
            bX(false);
            return false;
        } else {
            bX(true);
            return true;
        }
    }
}
