package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class aa implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aH(boolean z) {
        bm bmVar;
        bm bmVar2;
        boolean z2;
        bm bmVar3;
        bm bmVar4;
        if (z) {
            bmVar = this.bQi.bPi;
            if (!bmVar.abf()) {
                if (this.bQi.bPk == null || this.bQi.bPk.getThreadList().size() == 0) {
                    FrsActivity frsActivity = this.bQi;
                    bmVar2 = this.bQi.bPi;
                    frsActivity.hideNetRefreshView(bmVar2.getRootView());
                    z2 = this.bQi.bOT;
                    if (!z2) {
                        FrsActivity frsActivity2 = this.bQi;
                        bmVar3 = this.bQi.bPi;
                        frsActivity2.showLoadingView(bmVar3.getRootView(), true);
                        bmVar4 = this.bQi.bPi;
                        bmVar4.dK(false);
                    }
                    this.bQi.refresh();
                }
            }
        }
    }
}
