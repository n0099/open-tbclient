package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class s implements NoNetworkView.a {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        com.baidu.tieba.tbadkCore.o oVar;
        boolean z2;
        com.baidu.tieba.tbadkCore.o oVar2;
        if (z && !this.blk.bko.Ra()) {
            oVar = this.blk.bkq;
            if (oVar != null) {
                oVar2 = this.blk.bkq;
                if (oVar2.getThreadList().size() != 0) {
                    return;
                }
            }
            this.blk.hideNetRefreshView(this.blk.bko.getRootView());
            z2 = this.blk.bka;
            if (!z2) {
                this.blk.showLoadingView(this.blk.bko.getRootView(), true);
                this.blk.bko.RX();
            }
            this.blk.refresh();
        }
    }
}
