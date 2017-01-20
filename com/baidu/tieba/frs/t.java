package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class t implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        if (this.bGL.bFQ.abU() == 1 && z && !this.bGL.bFF.XX()) {
            if (this.bGL.bFG == null || com.baidu.tbadk.core.util.w.s(this.bGL.bFG.getThreadList())) {
                this.bGL.hideNetRefreshView(this.bGL.bFF.YI());
                this.bGL.showLoadingView(this.bGL.bFF.YI(), true);
                this.bGL.bFF.dE(false);
                this.bGL.refresh();
                return;
            }
            this.bGL.bFF.Yy();
        }
    }
}
