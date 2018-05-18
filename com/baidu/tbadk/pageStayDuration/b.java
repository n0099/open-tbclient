package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aJJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Gm();

    public abstract int Gn();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Gq()) {
            return false;
        }
        if (dVar.aJK) {
            dVar.I(c.e(dVar.Go(), 6));
        } else {
            int Gt = Gn() > e.Gr().Gt() ? e.Gr().Gt() : Gn();
            dVar.I(c.e(dVar.Go(), Gt <= 5 ? Gt : 5));
        }
        return true;
    }

    private void bQ(boolean z) {
        if (this.aJJ != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aJJ = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aJJ;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bQ(false);
            return false;
        } else if (!e.Gr().Gs()) {
            bQ(false);
            return false;
        } else {
            bQ(true);
            return true;
        }
    }
}
