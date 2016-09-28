package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.y;
/* loaded from: classes.dex */
class q implements y.c {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.y.c
    public void aJ(boolean z) {
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.i.p pVar2;
        com.baidu.tieba.frs.i.p pVar3;
        com.baidu.tieba.frs.i.p pVar4;
        pVar = this.bQi.bPu;
        if (pVar != null) {
            pVar2 = this.bQi.bPu;
            if (pVar2.afD() != null) {
                pVar3 = this.bQi.bPu;
                if (pVar3.afD().afZ() != null) {
                    pVar4 = this.bQi.bPu;
                    pVar4.afD().afZ().setDoingPullRefresh(true);
                }
            }
        }
    }
}
