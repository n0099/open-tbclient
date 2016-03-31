package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aAm = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Gl();

    public abstract int Gm();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Gq()) {
            return false;
        }
        int Gt = Gm() > e.Gr().Gt() ? e.Gr().Gt() : Gm();
        dVar.A(c.d(dVar.Go(), Gt <= 5 ? Gt : 5));
        return true;
    }

    private void bI(boolean z) {
        if (this.aAm != z) {
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("page_stay_duration_switch", true);
            this.aAm = z;
        }
    }

    public boolean Gn() {
        if (!TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            return this.aAm;
        }
        if (!TbadkCoreApplication.m411getInst().isPageStayOpen()) {
            bI(false);
            return false;
        } else if (!e.Gr().Gs()) {
            bI(false);
            return false;
        } else {
            bI(true);
            return true;
        }
    }
}
