package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class n implements NoNetworkView.a {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        bi biVar;
        com.baidu.tieba.tbadkCore.o oVar;
        bi biVar2;
        boolean z2;
        bi biVar3;
        bi biVar4;
        com.baidu.tieba.tbadkCore.o oVar2;
        if (z) {
            biVar = this.aVz.aUL;
            if (!biVar.Lm()) {
                oVar = this.aVz.aUN;
                if (oVar != null) {
                    oVar2 = this.aVz.aUN;
                    if (oVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aVz;
                biVar2 = this.aVz.aUL;
                frsActivity.hideNetRefreshView(biVar2.getRootView());
                z2 = this.aVz.aUA;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aVz;
                    biVar3 = this.aVz.aUL;
                    frsActivity2.showLoadingView(biVar3.getRootView(), true);
                    biVar4 = this.aVz.aUL;
                    biVar4.LZ();
                }
                this.aVz.refresh();
            }
        }
    }
}
