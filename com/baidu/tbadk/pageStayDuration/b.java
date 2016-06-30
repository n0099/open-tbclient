package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean axf = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("page_stay_duration_switch", false);

    public abstract boolean En();

    public abstract int Eo();

    public boolean a(d dVar) {
        if (dVar == null || dVar.Es()) {
            return false;
        }
        int Ev = Eo() > e.Et().Ev() ? e.Et().Ev() : Eo();
        dVar.D(c.e(dVar.Eq(), Ev <= 5 ? Ev : 5));
        return true;
    }

    private void bN(boolean z) {
        if (this.axf != z) {
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("page_stay_duration_switch", true);
            this.axf = z;
        }
    }

    public boolean Ep() {
        if (!TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            return this.axf;
        }
        if (!TbadkCoreApplication.m9getInst().isPageStayOpen()) {
            bN(false);
            return false;
        } else if (!e.Et().Eu()) {
            bN(false);
            return false;
        } else {
            bN(true);
            return true;
        }
    }
}
