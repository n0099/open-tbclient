package com.baidu.tbadk.o;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class b {
    private boolean cAi = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("page_stay_duration_switch", false);

    public abstract boolean avh();

    public abstract int avi();

    public boolean a(d dVar) {
        if (dVar == null || dVar.avm()) {
            return false;
        }
        if (dVar.cAj) {
            dVar.ao(c.e(dVar.avj(), 6));
        } else {
            int avq = avi() > e.avn().avq() ? e.avn().avq() : avi();
            dVar.ao(c.e(dVar.avj(), avq <= 5 ? avq : 5));
        }
        return true;
    }

    private void fE(boolean z) {
        if (this.cAi != z) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("page_stay_duration_switch", true);
            this.cAi = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.cAi;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            fE(false);
            return false;
        } else if (!e.avn().avp()) {
            fE(false);
            return false;
        } else {
            fE(true);
            return true;
        }
    }
}
