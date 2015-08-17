package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class n implements NoNetworkView.a {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        bl blVar;
        com.baidu.tieba.tbadkCore.n nVar;
        bl blVar2;
        boolean z2;
        bl blVar3;
        bl blVar4;
        com.baidu.tieba.tbadkCore.n nVar2;
        if (z) {
            blVar = this.this$0.aUw;
            if (!blVar.Lv()) {
                nVar = this.this$0.aUy;
                if (nVar != null) {
                    nVar2 = this.this$0.aUy;
                    if (nVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.this$0;
                blVar2 = this.this$0.aUw;
                frsActivity.hideNetRefreshView(blVar2.getRootView());
                z2 = this.this$0.aUm;
                if (!z2) {
                    FrsActivity frsActivity2 = this.this$0;
                    blVar3 = this.this$0.aUw;
                    frsActivity2.showLoadingView(blVar3.getRootView(), true);
                    blVar4 = this.this$0.aUw;
                    blVar4.Mi();
                }
                this.this$0.refresh();
            }
        }
    }
}
