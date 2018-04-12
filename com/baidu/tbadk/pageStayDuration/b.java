package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aJI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Go();

    public abstract int Gp();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Gs()) {
            return false;
        }
        if (dVar.aJJ) {
            dVar.I(c.e(dVar.Gq(), 6));
        } else {
            int Gv = Gp() > e.Gt().Gv() ? e.Gt().Gv() : Gp();
            dVar.I(c.e(dVar.Gq(), Gv <= 5 ? Gv : 5));
        }
        return true;
    }

    private void bQ(boolean z) {
        if (this.aJI != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aJI = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aJI;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bQ(false);
            return false;
        } else if (!e.Gt().Gu()) {
            bQ(false);
            return false;
        } else {
            bQ(true);
            return true;
        }
    }
}
