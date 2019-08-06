package com.baidu.tbadk.o;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean czm = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("page_stay_duration_switch", false);

    public abstract boolean auV();

    public abstract int auW();

    public boolean a(d dVar) {
        if (dVar == null || dVar.ava()) {
            return false;
        }
        if (dVar.czn) {
            dVar.ao(c.e(dVar.auX(), 6));
        } else {
            int ave = auW() > e.avb().ave() ? e.avb().ave() : auW();
            dVar.ao(c.e(dVar.auX(), ave <= 5 ? ave : 5));
        }
        return true;
    }

    private void fB(boolean z) {
        if (this.czm != z) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("page_stay_duration_switch", true);
            this.czm = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.czm;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            fB(false);
            return false;
        } else if (!e.avb().avd()) {
            fB(false);
            return false;
        } else {
            fB(true);
            return true;
        }
    }
}
