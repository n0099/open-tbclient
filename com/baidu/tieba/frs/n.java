package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class n implements t.d {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.d
    public void aI(boolean z) {
        com.baidu.tieba.frs.j.p pVar;
        com.baidu.tieba.frs.j.p pVar2;
        com.baidu.tieba.frs.j.p pVar3;
        com.baidu.tieba.frs.j.p pVar4;
        pVar = this.bEL.bDY;
        if (pVar != null) {
            pVar2 = this.bEL.bDY;
            if (pVar2.aaE() != null) {
                pVar3 = this.bEL.bDY;
                if (pVar3.aaE().aba() != null) {
                    pVar4 = this.bEL.bDY;
                    pVar4.aaE().aba().setDoingPullRefresh(true);
                }
            }
        }
    }
}
