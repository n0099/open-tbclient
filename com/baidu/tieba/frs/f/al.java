package com.baidu.tieba.frs.f;

import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ce;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ ak cdr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.cdr = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ah ahVar;
        ax axVar;
        ah ahVar2;
        ce ceVar;
        ah ahVar3;
        ax axVar2;
        ah ahVar4;
        ce ceVar2;
        ahVar = this.cdr.cdq;
        axVar = ahVar.bMN;
        if (axVar.Zk() != null) {
            ahVar2 = this.cdr.cdq;
            ceVar = ahVar2.bZT;
            if (ceVar != null) {
                ahVar3 = this.cdr.cdq;
                axVar2 = ahVar3.bMN;
                if (axVar2.Zk().getVisibility() != 0) {
                    ahVar4 = this.cdr.cdq;
                    ceVar2 = ahVar4.bZT;
                    ceVar2.WG();
                }
            }
        }
    }
}
