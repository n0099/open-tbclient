package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.core.view.y {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.y
    public void an(boolean z) {
        bf bfVar;
        com.baidu.tieba.tbadkCore.w wVar;
        bf bfVar2;
        boolean z2;
        bf bfVar3;
        bf bfVar4;
        com.baidu.tieba.tbadkCore.w wVar2;
        if (z) {
            bfVar = this.aJQ.aJa;
            if (!bfVar.JB()) {
                wVar = this.aJQ.aJd;
                if (wVar != null) {
                    wVar2 = this.aJQ.aJd;
                    if (wVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aJQ;
                bfVar2 = this.aJQ.aJa;
                frsActivity.hideNetRefreshView(bfVar2.Ks());
                z2 = this.aJQ.aIQ;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aJQ;
                    bfVar3 = this.aJQ.aJa;
                    frsActivity2.showLoadingView(bfVar3.getRootView(), true);
                    bfVar4 = this.aJQ.aJa;
                    bfVar4.Kq();
                }
                this.aJQ.refresh();
            }
        }
    }
}
