package com.baidu.tieba.frs.f;

import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ce;
/* loaded from: classes.dex */
class aj implements Runnable {
    final /* synthetic */ ai bVW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.bVW = aiVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        af afVar;
        ax axVar;
        af afVar2;
        ce ceVar;
        af afVar3;
        ax axVar2;
        af afVar4;
        ce ceVar2;
        afVar = this.bVW.bVV;
        axVar = afVar.bFF;
        if (axVar.Yl() != null) {
            afVar2 = this.bVW.bVV;
            ceVar = afVar2.bSH;
            if (ceVar != null) {
                afVar3 = this.bVW.bVV;
                axVar2 = afVar3.bFF;
                if (axVar2.Yl().getVisibility() != 0) {
                    afVar4 = this.bVW.bVV;
                    ceVar2 = afVar4.bSH;
                    ceVar2.VI();
                }
            }
        }
    }
}
