package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean aWv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean LB();

    public abstract int LC();

    public boolean a(d dVar) {
        if (dVar == null || dVar.LF()) {
            return false;
        }
        if (dVar.aWw) {
            dVar.M(c.f(dVar.LD(), 6));
        } else {
            int LI = LC() > e.LG().LI() ? e.LG().LI() : LC();
            dVar.M(c.f(dVar.LD(), LI <= 5 ? LI : 5));
        }
        return true;
    }

    private void ci(boolean z) {
        if (this.aWv != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.aWv = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.aWv;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            ci(false);
            return false;
        } else if (!e.LG().LH()) {
            ci(false);
            return false;
        } else {
            ci(true);
            return true;
        }
    }
}
