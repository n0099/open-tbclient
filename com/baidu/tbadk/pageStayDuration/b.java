package com.baidu.tbadk.pageStayDuration;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean cpG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("page_stay_duration_switch", false);

    public abstract boolean aoL();

    public abstract int aoM();

    public boolean a(d dVar) {
        if (dVar == null || dVar.aoP()) {
            return false;
        }
        if (dVar.cpH) {
            dVar.ah(c.e(dVar.aoN(), 6));
        } else {
            int aoT = aoM() > e.aoQ().aoT() ? e.aoQ().aoT() : aoM();
            dVar.ah(c.e(dVar.aoN(), aoT <= 5 ? aoT : 5));
        }
        return true;
    }

    private void fb(boolean z) {
        if (this.cpG != z) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("page_stay_duration_switch", true);
            this.cpG = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.cpG;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            fb(false);
            return false;
        } else if (!e.aoQ().aoS()) {
            fb(false);
            return false;
        } else {
            fb(true);
            return true;
        }
    }
}
