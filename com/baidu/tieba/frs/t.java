package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class t implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bQa = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.bQa.bPf.adM() == 1 && z && !this.bQa.bOU.aat()) {
            if (this.bQa.bOV == null || com.baidu.tbadk.core.util.x.q(this.bQa.bOV.getThreadList())) {
                this.bQa.hideNetRefreshView(this.bQa.bOU.abg());
                this.bQa.showLoadingView(this.bQa.bOU.abg(), true);
                this.bQa.bOU.dQ(false);
                this.bQa.refresh();
                return;
            }
            this.bQa.bOU.aaW();
        }
    }
}
