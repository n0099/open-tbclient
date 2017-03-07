package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aEY = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Fx();

    public abstract int Fy();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FC()) {
            return false;
        }
        if (dVar.aEZ) {
            dVar.z(c.e(dVar.FA(), 6));
        } else {
            int FF = Fy() > e.FD().FF() ? e.FD().FF() : Fy();
            dVar.z(c.e(dVar.FA(), FF <= 5 ? FF : 5));
        }
        return true;
    }

    private void bT(boolean z) {
        if (this.aEY != z) {
            com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("page_stay_duration_switch", true);
            this.aEY = z;
        }
    }

    public boolean Fz() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.aEY;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bT(false);
            return false;
        } else if (!e.FD().FE()) {
            bT(false);
            return false;
        } else {
            bT(true);
            return true;
        }
    }
}
