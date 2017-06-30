package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aGv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Fq();

    public abstract int Fr();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Fv()) {
            return false;
        }
        if (dVar.aGw) {
            dVar.C(c.e(dVar.Ft(), 6));
        } else {
            int Fy = Fr() > e.Fw().Fy() ? e.Fw().Fy() : Fr();
            dVar.C(c.e(dVar.Ft(), Fy <= 5 ? Fy : 5));
        }
        return true;
    }

    private void bV(boolean z) {
        if (this.aGv != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aGv = z;
        }
    }

    public boolean Fs() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.aGv;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bV(false);
            return false;
        } else if (!e.Fw().Fx()) {
            bV(false);
            return false;
        } else {
            bV(true);
            return true;
        }
    }
}
