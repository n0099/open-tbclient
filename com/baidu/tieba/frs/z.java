package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class z implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aG(boolean z) {
        bq bqVar;
        bq bqVar2;
        boolean z2;
        bq bqVar3;
        bq bqVar4;
        if (z) {
            bqVar = this.bEL.bDK;
            if (!bqVar.VV()) {
                if (this.bEL.bDM == null || this.bEL.bDM.getThreadList().size() == 0) {
                    FrsActivity frsActivity = this.bEL;
                    bqVar2 = this.bEL.bDK;
                    frsActivity.hideNetRefreshView(bqVar2.getRootView());
                    z2 = this.bEL.bDv;
                    if (!z2) {
                        FrsActivity frsActivity2 = this.bEL;
                        bqVar3 = this.bEL.bDK;
                        frsActivity2.showLoadingView(bqVar3.getRootView(), true);
                        bqVar4 = this.bEL.bDK;
                        bqVar4.dl(false);
                    }
                    this.bEL.refresh();
                }
            }
        }
    }
}
