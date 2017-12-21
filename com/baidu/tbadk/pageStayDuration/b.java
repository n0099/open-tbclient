package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aJj = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FR();

    public abstract int FS();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FV()) {
            return false;
        }
        if (dVar.aJk) {
            dVar.H(c.e(dVar.FT(), 6));
        } else {
            int FY = FS() > e.FW().FY() ? e.FW().FY() : FS();
            dVar.H(c.e(dVar.FT(), FY <= 5 ? FY : 5));
        }
        return true;
    }

    private void bS(boolean z) {
        if (this.aJj != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aJj = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aJj;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bS(false);
            return false;
        } else if (!e.FW().FX()) {
            bS(false);
            return false;
        } else {
            bS(true);
            return true;
        }
    }
}
