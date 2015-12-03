package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class n implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        com.baidu.tieba.tbadkCore.p pVar;
        boolean z2;
        com.baidu.tieba.tbadkCore.p pVar2;
        if (z && !this.bag.aZq.MU()) {
            pVar = this.bag.aZs;
            if (pVar != null) {
                pVar2 = this.bag.aZs;
                if (pVar2.getThreadList().size() != 0) {
                    return;
                }
            }
            this.bag.hideNetRefreshView(this.bag.aZq.getRootView());
            z2 = this.bag.aZd;
            if (!z2) {
                this.bag.showLoadingView(this.bag.aZq.getRootView(), true);
                this.bag.aZq.NL();
            }
            this.bag.refresh();
        }
    }
}
