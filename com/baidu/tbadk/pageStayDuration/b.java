package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean cpJ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean aoH();

    public abstract int aoI();

    public boolean a(d dVar) {
        if (dVar == null || dVar.aoL()) {
            return false;
        }
        if (dVar.cpK) {
            dVar.ah(c.e(dVar.aoJ(), 6));
        } else {
            int aoP = aoI() > e.aoM().aoP() ? e.aoM().aoP() : aoI();
            dVar.ah(c.e(dVar.aoJ(), aoP <= 5 ? aoP : 5));
        }
        return true;
    }

    private void fb(boolean z) {
        if (this.cpJ != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.cpJ = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.cpJ;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            fb(false);
            return false;
        } else if (!e.aoM().aoO()) {
            fb(false);
            return false;
        } else {
            fb(true);
            return true;
        }
    }
}
