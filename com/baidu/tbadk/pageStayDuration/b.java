package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aSk = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean JU();

    public abstract int JV();

    public boolean a(d dVar) {
        if (dVar == null || dVar.JY()) {
            return false;
        }
        if (dVar.aSl) {
            dVar.L(c.e(dVar.JW(), 6));
        } else {
            int Kb = JV() > e.JZ().Kb() ? e.JZ().Kb() : JV();
            dVar.L(c.e(dVar.JW(), Kb <= 5 ? Kb : 5));
        }
        return true;
    }

    private void bU(boolean z) {
        if (this.aSk != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aSk = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aSk;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bU(false);
            return false;
        } else if (!e.JZ().Ka()) {
            bU(false);
            return false;
        } else {
            bU(true);
            return true;
        }
    }
}
