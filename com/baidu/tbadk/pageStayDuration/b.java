package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean bfl = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean ON();

    public abstract int OO();

    public boolean a(d dVar) {
        if (dVar == null || dVar.OR()) {
            return false;
        }
        if (dVar.bfm) {
            dVar.U(c.f(dVar.OP(), 6));
        } else {
            int OU = OO() > e.OS().OU() ? e.OS().OU() : OO();
            dVar.U(c.f(dVar.OP(), OU <= 5 ? OU : 5));
        }
        return true;
    }

    private void cJ(boolean z) {
        if (this.bfl != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.bfl = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.bfl;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            cJ(false);
            return false;
        } else if (!e.OS().OT()) {
            cJ(false);
            return false;
        } else {
            cJ(true);
            return true;
        }
    }
}
