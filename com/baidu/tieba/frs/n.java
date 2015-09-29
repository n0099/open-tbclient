package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class n implements NoNetworkView.a {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.aUz = frsActivity;
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
            bsVar = this.aUz.aTJ;
            if (!bsVar.Li()) {
                oVar = this.aUz.aTL;
                if (oVar != null) {
                    oVar2 = this.aUz.aTL;
                    if (oVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aUz;
                bsVar2 = this.aUz.aTJ;
                frsActivity.hideNetRefreshView(bsVar2.getRootView());
                z2 = this.aUz.aTw;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aUz;
                    bsVar3 = this.aUz.aTJ;
                    frsActivity2.showLoadingView(bsVar3.getRootView(), true);
                    bsVar4 = this.aUz.aTJ;
                    bsVar4.LY();
                }
                this.aUz.refresh();
            }
        }
    }
}
