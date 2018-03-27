package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean bzm = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean NM();

    public abstract int NN();

    public boolean a(d dVar) {
        if (dVar == null || dVar.NQ()) {
            return false;
        }
        if (dVar.bzn) {
            dVar.Q(c.h(dVar.NO(), 6));
        } else {
            int NT = NN() > e.NR().NT() ? e.NR().NT() : NN();
            dVar.Q(c.h(dVar.NO(), NT <= 5 ? NT : 5));
        }
        return true;
    }

    private void cy(boolean z) {
        if (this.bzm != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.bzm = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.bzm;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            cy(false);
            return false;
        } else if (!e.NR().NS()) {
            cy(false);
            return false;
        } else {
            cy(true);
            return true;
        }
    }
}
