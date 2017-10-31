package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aIt = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Fx();

    public abstract int Fy();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FC()) {
            return false;
        }
        if (dVar.aIu) {
            dVar.G(c.e(dVar.FA(), 6));
        } else {
            int FF = Fy() > e.FD().FF() ? e.FD().FF() : Fy();
            dVar.G(c.e(dVar.FA(), FF <= 5 ? FF : 5));
        }
        return true;
    }

    private void bR(boolean z) {
        if (this.aIt != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aIt = z;
        }
    }

    public boolean Fz() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aIt;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bR(false);
            return false;
        } else if (!e.FD().FE()) {
            bR(false);
            return false;
        } else {
            bR(true);
            return true;
        }
    }
}
