package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class n implements t.d {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.d
    public void aF(boolean z) {
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.i.p pVar2;
        com.baidu.tieba.frs.i.p pVar3;
        com.baidu.tieba.frs.i.p pVar4;
        pVar = this.bDB.bCR;
        if (pVar != null) {
            pVar2 = this.bDB.bCR;
            if (pVar2.aac() != null) {
                pVar3 = this.bDB.bCR;
                if (pVar3.aac().aay() != null) {
                    pVar4 = this.bDB.bCR;
                    pVar4.aac().aay().setDoingPullRefresh(true);
                }
            }
        }
    }
}
