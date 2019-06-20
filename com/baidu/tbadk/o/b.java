package com.baidu.tbadk.o;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean cxQ = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("page_stay_duration_switch", false);

    public abstract boolean atL();

    public abstract int atM();

    public boolean a(d dVar) {
        if (dVar == null || dVar.atP()) {
            return false;
        }
        if (dVar.cxR) {
            dVar.ao(c.e(dVar.atN(), 6));
        } else {
            int atT = atM() > e.atQ().atT() ? e.atQ().atT() : atM();
            dVar.ao(c.e(dVar.atN(), atT <= 5 ? atT : 5));
        }
        return true;
    }

    private void fx(boolean z) {
        if (this.cxQ != z) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("page_stay_duration_switch", true);
            this.cxQ = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.cxQ;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            fx(false);
            return false;
        } else if (!e.atQ().atS()) {
            fx(false);
            return false;
        } else {
            fx(true);
            return true;
        }
    }
}
