package com.baidu.tieba.frs.g;

import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.cg;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ ak cej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.cej = akVar;
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
        ahVar = this.cej.cei;
        azVar = ahVar.bOU;
        if (azVar.aaJ() != null) {
            ahVar2 = this.cej.cei;
            cgVar = ahVar2.caL;
            if (cgVar != null) {
                ahVar3 = this.cej.cei;
                azVar2 = ahVar3.bOU;
                if (azVar2.aaJ().getVisibility() != 0) {
                    ahVar4 = this.cej.cei;
                    cgVar2 = ahVar4.caL;
                    cgVar2.Yf();
                }
            }
        }
    }
}
