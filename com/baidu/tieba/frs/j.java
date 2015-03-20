package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.core.view.y {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aJG = frsActivity;
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
            bfVar = this.aJG.aIS;
            if (!bfVar.Jv()) {
                wVar = this.aJG.aIV;
                if (wVar != null) {
                    wVar2 = this.aJG.aIV;
                    if (wVar2.akp().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aJG;
                bfVar2 = this.aJG.aIS;
                frsActivity.hideNetRefreshView(bfVar2.Kl());
                z2 = this.aJG.aII;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aJG;
                    bfVar3 = this.aJG.aIS;
                    frsActivity2.showLoadingView(bfVar3.getRootView(), true);
                    bfVar4 = this.aJG.aIS;
                    bfVar4.Kj();
                }
                this.aJG.refresh();
            }
        }
    }
}
