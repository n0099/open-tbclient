package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean bxg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Ne();

    public abstract int Nf();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Ni()) {
            return false;
        }
        if (dVar.bxh) {
            dVar.O(c.h(dVar.Ng(), 6));
        } else {
            int Nl = Nf() > e.Nj().Nl() ? e.Nj().Nl() : Nf();
            dVar.O(c.h(dVar.Ng(), Nl <= 5 ? Nl : 5));
        }
        return true;
    }

    private void ct(boolean z) {
        if (this.bxg != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.bxg = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.bxg;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            ct(false);
            return false;
        } else if (!e.Nj().Nk()) {
            ct(false);
            return false;
        } else {
            ct(true);
            return true;
        }
    }
}
