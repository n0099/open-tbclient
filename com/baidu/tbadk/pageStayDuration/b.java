package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aJc = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FQ();

    public abstract int FR();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FU()) {
            return false;
        }
        if (dVar.aJd) {
            dVar.H(c.e(dVar.FS(), 6));
        } else {
            int FX = FR() > e.FV().FX() ? e.FV().FX() : FR();
            dVar.H(c.e(dVar.FS(), FX <= 5 ? FX : 5));
        }
        return true;
    }

    private void bR(boolean z) {
        if (this.aJc != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aJc = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aJc;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bR(false);
            return false;
        } else if (!e.FV().FW()) {
            bR(false);
            return false;
        } else {
            bR(true);
            return true;
        }
    }
}
