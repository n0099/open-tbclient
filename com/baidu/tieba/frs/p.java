package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void ar(boolean z) {
        bq bqVar;
        com.baidu.tieba.tbadkCore.e eVar;
        bq bqVar2;
        boolean z2;
        bq bqVar3;
        com.baidu.tieba.tbadkCore.e eVar2;
        if (z) {
            bqVar = this.aCV.aBX;
            if (!bqVar.Gs()) {
                eVar = this.aCV.aCh;
                if (eVar != null) {
                    eVar2 = this.aCV.aCh;
                    if (eVar2.aek().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aCV;
                bqVar2 = this.aCV.aBX;
                frsActivity.hideNetRefreshView(bqVar2.getRootView());
                z2 = this.aCV.aBL;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aCV;
                    bqVar3 = this.aCV.aBX;
                    frsActivity2.showLoadingView(bqVar3.getRootView(), true);
                }
                this.aCV.refresh();
            }
        }
    }
}
