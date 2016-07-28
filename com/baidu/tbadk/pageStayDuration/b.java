package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean axT = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("page_stay_duration_switch", false);

    public abstract boolean Em();

    public abstract int En();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Er()) {
            return false;
        }
        if (dVar.axU) {
            dVar.D(c.e(dVar.Ep(), 6));
        } else {
            int Eu = En() > e.Es().Eu() ? e.Es().Eu() : En();
            dVar.D(c.e(dVar.Ep(), Eu <= 5 ? Eu : 5));
        }
        return true;
    }

    private void bQ(boolean z) {
        if (this.axT != z) {
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("page_stay_duration_switch", true);
            this.axT = z;
        }
    }

    public boolean Eo() {
        if (!TbadkCoreApplication.m10getInst().isMainProcess(true)) {
            return this.axT;
        }
        if (!TbadkCoreApplication.m10getInst().isPageStayOpen()) {
            bQ(false);
            return false;
        } else if (!e.Es().Et()) {
            bQ(false);
            return false;
        } else {
            bQ(true);
            return true;
        }
    }
}
