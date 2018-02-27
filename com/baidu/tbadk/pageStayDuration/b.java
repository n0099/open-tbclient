package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean bzj = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean NL();

    public abstract int NM();

    public boolean a(d dVar) {
        if (dVar == null || dVar.NP()) {
            return false;
        }
        if (dVar.bzk) {
            dVar.Q(c.h(dVar.NN(), 6));
        } else {
            int NS = NM() > e.NQ().NS() ? e.NQ().NS() : NM();
            dVar.Q(c.h(dVar.NN(), NS <= 5 ? NS : 5));
        }
        return true;
    }

    private void cy(boolean z) {
        if (this.bzj != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.bzj = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.bzj;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            cy(false);
            return false;
        } else if (!e.NQ().NR()) {
            cy(false);
            return false;
        } else {
            cy(true);
            return true;
        }
    }
}
