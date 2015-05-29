package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aLX = frsActivity;
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
            bfVar = this.aLX.aLi;
            if (!bfVar.KF()) {
                wVar = this.aLX.aLl;
                if (wVar != null) {
                    wVar2 = this.aLX.aLl;
                    if (wVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aLX;
                bfVar2 = this.aLX.aLi;
                frsActivity.hideNetRefreshView(bfVar2.getRootView());
                z2 = this.aLX.aKY;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aLX;
                    bfVar3 = this.aLX.aLi;
                    frsActivity2.showLoadingView(bfVar3.getRootView(), true);
                    bfVar4 = this.aLX.aLi;
                    bfVar4.Lv();
                }
                this.aLX.refresh();
            }
        }
    }
}
