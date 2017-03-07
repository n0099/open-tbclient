package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class t implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        if (this.bNU.bMY.acR() == 1 && z && !this.bNU.bMN.YW()) {
            if (this.bNU.bMO == null || com.baidu.tbadk.core.util.x.q(this.bNU.bMO.getThreadList())) {
                this.bNU.hideNetRefreshView(this.bNU.bMN.ZH());
                this.bNU.showLoadingView(this.bNU.bMN.ZH(), true);
                this.bNU.bMN.dE(false);
                this.bNU.refresh();
                return;
            }
            this.bNU.bMN.Zx();
        }
    }
}
