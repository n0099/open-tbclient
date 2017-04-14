package com.baidu.tieba.frs.g;

import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.cg;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ ak cbS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.cbS = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ah ahVar;
        az azVar;
        ah ahVar2;
        cg cgVar;
        ah ahVar3;
        az azVar2;
        ah ahVar4;
        cg cgVar2;
        ahVar = this.cbS.cbR;
        azVar = ahVar.bMD;
        if (azVar.ZI() != null) {
            ahVar2 = this.cbS.cbR;
            cgVar = ahVar2.bYu;
            if (cgVar != null) {
                ahVar3 = this.cbS.cbR;
                azVar2 = ahVar3.bMD;
                if (azVar2.ZI().getVisibility() != 0) {
                    ahVar4 = this.cbS.cbR;
                    cgVar2 = ahVar4.bYu;
                    cgVar2.Xe();
                }
            }
        }
    }
}
