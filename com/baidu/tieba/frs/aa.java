package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class aa implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aH(boolean z) {
        bm bmVar;
        bm bmVar2;
        boolean z2;
        bm bmVar3;
        bm bmVar4;
        if (z) {
            bmVar = this.bQp.bPo;
            if (!bmVar.aaS()) {
                if (this.bQp.bPq == null || this.bQp.bPq.getThreadList().size() == 0) {
                    FrsActivity frsActivity = this.bQp;
                    bmVar2 = this.bQp.bPo;
                    frsActivity.hideNetRefreshView(bmVar2.getRootView());
                    z2 = this.bQp.bOZ;
                    if (!z2) {
                        FrsActivity frsActivity2 = this.bQp;
                        bmVar3 = this.bQp.bPo;
                        frsActivity2.showLoadingView(bmVar3.getRootView(), true);
                        bmVar4 = this.bQp.bPo;
                        bmVar4.dJ(false);
                    }
                    this.bQp.refresh();
                }
            }
        }
    }
}
