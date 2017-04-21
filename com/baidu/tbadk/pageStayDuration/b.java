package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aFq = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FV();

    public abstract int FW();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Ga()) {
            return false;
        }
        if (dVar.aFr) {
            dVar.z(c.e(dVar.FY(), 6));
        } else {
            int Gd = FW() > e.Gb().Gd() ? e.Gb().Gd() : FW();
            dVar.z(c.e(dVar.FY(), Gd <= 5 ? Gd : 5));
        }
        return true;
    }

    private void bV(boolean z) {
        if (this.aFq != z) {
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("page_stay_duration_switch", true);
            this.aFq = z;
        }
    }

    public boolean FX() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.aFq;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bV(false);
            return false;
        } else if (!e.Gb().Gc()) {
            bV(false);
            return false;
        } else {
            bV(true);
            return true;
        }
    }
}
