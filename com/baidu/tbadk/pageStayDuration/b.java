package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean cpG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean aoK();

    public abstract int aoL();

    public boolean a(d dVar) {
        if (dVar == null || dVar.aoO()) {
            return false;
        }
        if (dVar.cpH) {
            dVar.ah(c.e(dVar.aoM(), 6));
        } else {
            int aoS = aoL() > e.aoP().aoS() ? e.aoP().aoS() : aoL();
            dVar.ah(c.e(dVar.aoM(), aoS <= 5 ? aoS : 5));
        }
        return true;
    }

    private void fb(boolean z) {
        if (this.cpG != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.cpG = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.cpG;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            fb(false);
            return false;
        } else if (!e.aoP().aoR()) {
            fb(false);
            return false;
        } else {
            fb(true);
            return true;
        }
    }
}
