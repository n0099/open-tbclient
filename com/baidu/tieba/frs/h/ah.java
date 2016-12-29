package com.baidu.tieba.frs.h;

import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.cg;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ ag bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.bPw = agVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ad adVar;
        ax axVar;
        ad adVar2;
        cg cgVar;
        ad adVar3;
        ax axVar2;
        ad adVar4;
        cg cgVar2;
        adVar = this.bPw.bPv;
        axVar = adVar.byg;
        if (axVar.WU() != null) {
            adVar2 = this.bPw.bPv;
            cgVar = adVar2.bMt;
            if (cgVar != null) {
                adVar3 = this.bPw.bPv;
                axVar2 = adVar3.byg;
                if (axVar2.WU().getVisibility() != 0) {
                    adVar4 = this.bPw.bPv;
                    cgVar2 = adVar4.bMt;
                    cgVar2.Un();
                }
            }
        }
    }
}
