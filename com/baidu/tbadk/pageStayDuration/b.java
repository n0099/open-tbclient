package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aBu = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FJ();

    public abstract int FK();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FO()) {
            return false;
        }
        if (dVar.aBv) {
            dVar.D(c.e(dVar.FM(), 6));
        } else {
            int FR = FK() > e.FP().FR() ? e.FP().FR() : FK();
            dVar.D(c.e(dVar.FM(), FR <= 5 ? FR : 5));
        }
        return true;
    }

    private void bV(boolean z) {
        if (this.aBu != z) {
            com.baidu.tbadk.core.sharedPref.b.um().putBoolean("page_stay_duration_switch", true);
            this.aBu = z;
        }
    }

    public boolean FL() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.aBu;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bV(false);
            return false;
        } else if (!e.FP().FQ()) {
            bV(false);
            return false;
        } else {
            bV(true);
            return true;
        }
    }
}
