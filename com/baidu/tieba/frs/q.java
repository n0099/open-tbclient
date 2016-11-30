package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class q implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        if (this.bTa.bSh.ags() == 1 && z && !this.bTa.bRW.acs()) {
            if (this.bTa.bRX == null || com.baidu.tbadk.core.util.x.t(this.bTa.bRX.getThreadList())) {
                this.bTa.hideNetRefreshView(this.bTa.bRW.adf());
                this.bTa.showLoadingView(this.bTa.bRW.adf(), true);
                this.bTa.bRW.dQ(false);
                this.bTa.refresh();
                return;
            }
            this.bTa.bRW.acT();
        }
    }
}
