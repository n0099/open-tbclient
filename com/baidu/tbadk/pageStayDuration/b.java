package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aAO = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Fj();

    public abstract int Fk();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Fo()) {
            return false;
        }
        if (dVar.aAP) {
            dVar.D(c.e(dVar.Fm(), 6));
        } else {
            int Fr = Fk() > e.Fp().Fr() ? e.Fp().Fr() : Fk();
            dVar.D(c.e(dVar.Fm(), Fr <= 5 ? Fr : 5));
        }
        return true;
    }

    private void bU(boolean z) {
        if (this.aAO != z) {
            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("page_stay_duration_switch", true);
            this.aAO = z;
        }
    }

    public boolean Fl() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.aAO;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bU(false);
            return false;
        } else if (!e.Fp().Fq()) {
            bU(false);
            return false;
        } else {
            bU(true);
            return true;
        }
    }
}
