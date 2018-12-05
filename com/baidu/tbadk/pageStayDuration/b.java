package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean bfi = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean OM();

    public abstract int ON();

    public boolean a(d dVar) {
        if (dVar == null || dVar.OQ()) {
            return false;
        }
        if (dVar.bfj) {
            dVar.U(c.f(dVar.OO(), 6));
        } else {
            int OT = ON() > e.OR().OT() ? e.OR().OT() : ON();
            dVar.U(c.f(dVar.OO(), OT <= 5 ? OT : 5));
        }
        return true;
    }

    private void cJ(boolean z) {
        if (this.bfi != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.bfi = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.bfi;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            cJ(false);
            return false;
        } else if (!e.OR().OS()) {
            cJ(false);
            return false;
        } else {
            cJ(true);
            return true;
        }
    }
}
