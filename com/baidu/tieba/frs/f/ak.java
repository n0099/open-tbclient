package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ce;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements ab.c {
    final /* synthetic */ ah cdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.cdq = ahVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.c
    public void aM(boolean z) {
        ax axVar;
        ce ceVar;
        u uVar;
        ax axVar2;
        u uVar2;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        u uVar3;
        u uVar4;
        u uVar5;
        ax axVar3;
        ax axVar4;
        axVar = this.cdq.bMN;
        if (axVar != null) {
            ceVar = this.cdq.bZT;
            if (ceVar != null) {
                uVar = this.cdq.bMZ;
                if (uVar != null) {
                    axVar2 = this.cdq.bMN;
                    if (axVar2 != null) {
                        axVar3 = this.cdq.bMN;
                        if (axVar3.KC() != null) {
                            axVar4 = this.cdq.bMN;
                            axVar4.KC().alL();
                        }
                    }
                    uVar2 = this.cdq.bMZ;
                    if (uVar2 != null) {
                        uVar3 = this.cdq.bMZ;
                        if (uVar3.adU() != null) {
                            uVar4 = this.cdq.bMZ;
                            if (uVar4.adU().aeB() != null) {
                                uVar5 = this.cdq.bMZ;
                                uVar5.adU().aeB().setDoingPullRefresh(true);
                            }
                        }
                    }
                    frsActivity = this.cdq.bTf;
                    frsActivity.dA(false);
                    frsActivity2 = this.cdq.bTf;
                    frsActivity2.mHandler.postDelayed(new al(this), 110L);
                }
            }
        }
    }
}
