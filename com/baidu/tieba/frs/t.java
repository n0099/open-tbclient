package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class t implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.bNJ.bMO.acL() == 1 && z && !this.bNJ.bMD.Zs()) {
            if (this.bNJ.bME == null || com.baidu.tbadk.core.util.x.q(this.bNJ.bME.getThreadList())) {
                this.bNJ.hideNetRefreshView(this.bNJ.bMD.aaf());
                this.bNJ.showLoadingView(this.bNJ.bMD.aaf(), true);
                this.bNJ.bMD.dG(false);
                this.bNJ.refresh();
                return;
            }
            this.bNJ.bMD.ZV();
        }
    }
}
