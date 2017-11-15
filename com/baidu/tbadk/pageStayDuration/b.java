package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aIB = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean FJ();

    public abstract int FK();

    public boolean a(d dVar) {
        if (dVar == null || dVar.FN()) {
            return false;
        }
        if (dVar.aIC) {
            dVar.G(c.e(dVar.FL(), 6));
        } else {
            int FQ = FK() > e.FO().FQ() ? e.FO().FQ() : FK();
            dVar.G(c.e(dVar.FL(), FQ <= 5 ? FQ : 5));
        }
        return true;
    }

    private void bS(boolean z) {
        if (this.aIB != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aIB = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aIB;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            bS(false);
            return false;
        } else if (!e.FO().FP()) {
            bS(false);
            return false;
        } else {
            bS(true);
            return true;
        }
    }
}
