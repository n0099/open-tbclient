package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void au(boolean z) {
        bf bfVar;
        com.baidu.tieba.tbadkCore.w wVar;
        bf bfVar2;
        boolean z2;
        bf bfVar3;
        bf bfVar4;
        com.baidu.tieba.tbadkCore.w wVar2;
        if (z) {
            bfVar = this.aLY.aLj;
            if (!bfVar.KG()) {
                wVar = this.aLY.aLm;
                if (wVar != null) {
                    wVar2 = this.aLY.aLm;
                    if (wVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aLY;
                bfVar2 = this.aLY.aLj;
                frsActivity.hideNetRefreshView(bfVar2.getRootView());
                z2 = this.aLY.aKZ;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aLY;
                    bfVar3 = this.aLY.aLj;
                    frsActivity2.showLoadingView(bfVar3.getRootView(), true);
                    bfVar4 = this.aLY.aLj;
                    bfVar4.Lw();
                }
                this.aLY.refresh();
            }
        }
    }
}
