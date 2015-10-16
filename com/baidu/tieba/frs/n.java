package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class n implements NoNetworkView.a {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        bs bsVar;
        com.baidu.tieba.tbadkCore.o oVar;
        bs bsVar2;
        boolean z2;
        bs bsVar3;
        bs bsVar4;
        com.baidu.tieba.tbadkCore.o oVar2;
        if (z) {
            bsVar = this.aUK.aTU;
            if (!bsVar.Li()) {
                oVar = this.aUK.aTW;
                if (oVar != null) {
                    oVar2 = this.aUK.aTW;
                    if (oVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aUK;
                bsVar2 = this.aUK.aTU;
                frsActivity.hideNetRefreshView(bsVar2.getRootView());
                z2 = this.aUK.aTH;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aUK;
                    bsVar3 = this.aUK.aTU;
                    frsActivity2.showLoadingView(bsVar3.getRootView(), true);
                    bsVar4 = this.aUK.aTU;
                    bsVar4.LY();
                }
                this.aUK.refresh();
            }
        }
    }
}
