package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean azG = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Fd();

    public abstract int Fe();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Fi()) {
            return false;
        }
        if (dVar.azH) {
            dVar.B(c.e(dVar.Fg(), 6));
        } else {
            int Fl = Fe() > e.Fj().Fl() ? e.Fj().Fl() : Fe();
            dVar.B(c.e(dVar.Fg(), Fl <= 5 ? Fl : 5));
        }
        return true;
    }

    private void bU(boolean z) {
        if (this.azG != z) {
            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("page_stay_duration_switch", true);
            this.azG = z;
        }
    }

    public boolean Ff() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.azG;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bU(false);
            return false;
        } else if (!e.Fj().Fk()) {
            bU(false);
            return false;
        } else {
            bU(true);
            return true;
        }
    }
}
