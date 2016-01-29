package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class r implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        com.baidu.tieba.tbadkCore.o oVar;
        boolean z2;
        com.baidu.tieba.tbadkCore.o oVar2;
        if (z && !this.bgz.bfD.Pl()) {
            oVar = this.bgz.bfF;
            if (oVar != null) {
                oVar2 = this.bgz.bfF;
                if (oVar2.getThreadList().size() != 0) {
                    return;
                }
            }
            this.bgz.hideNetRefreshView(this.bgz.bfD.getRootView());
            z2 = this.bgz.bfq;
            if (!z2) {
                this.bgz.showLoadingView(this.bgz.bfD.getRootView(), true);
                this.bgz.bfD.Qe();
            }
            this.bgz.refresh();
        }
    }
}
