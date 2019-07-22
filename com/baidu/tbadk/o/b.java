package com.baidu.tbadk.o;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean czf = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("page_stay_duration_switch", false);

    public abstract boolean auT();

    public abstract int auU();

    public boolean a(d dVar) {
        if (dVar == null || dVar.auY()) {
            return false;
        }
        if (dVar.czg) {
            dVar.ao(c.e(dVar.auV(), 6));
        } else {
            int avc = auU() > e.auZ().avc() ? e.auZ().avc() : auU();
            dVar.ao(c.e(dVar.auV(), avc <= 5 ? avc : 5));
        }
        return true;
    }

    private void fB(boolean z) {
        if (this.czf != z) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("page_stay_duration_switch", true);
            this.czf = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.czf;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            fB(false);
            return false;
        } else if (!e.auZ().avb()) {
            fB(false);
            return false;
        } else {
            fB(true);
            return true;
        }
    }
}
