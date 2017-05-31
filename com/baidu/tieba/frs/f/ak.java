package com.baidu.tieba.frs.f;

import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.cb;
/* loaded from: classes.dex */
class ak implements Runnable {
    final /* synthetic */ aj cig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.cig = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ag agVar;
        au auVar;
        ag agVar2;
        cb cbVar;
        ag agVar3;
        au auVar2;
        ag agVar4;
        cb cbVar2;
        agVar = this.cig.cif;
        auVar = agVar.bUa;
        if (auVar.aaz() != null) {
            agVar2 = this.cig.cif;
            cbVar = agVar2.ceP;
            if (cbVar != null) {
                agVar3 = this.cig.cif;
                auVar2 = agVar3.bUa;
                if (auVar2.aaz().getVisibility() != 0) {
                    agVar4 = this.cig.cif;
                    cbVar2 = agVar4.ceP;
                    cbVar2.Gs();
                }
            }
        }
    }
}
