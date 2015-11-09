package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class n implements NoNetworkView.a {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.aUS = frsActivity;
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
            bsVar = this.aUS.aUc;
            if (!bsVar.Lu()) {
                oVar = this.aUS.aUe;
                if (oVar != null) {
                    oVar2 = this.aUS.aUe;
                    if (oVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aUS;
                bsVar2 = this.aUS.aUc;
                frsActivity.hideNetRefreshView(bsVar2.getRootView());
                z2 = this.aUS.aTP;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aUS;
                    bsVar3 = this.aUS.aUc;
                    frsActivity2.showLoadingView(bsVar3.getRootView(), true);
                    bsVar4 = this.aUS.aUc;
                    bsVar4.Mk();
                }
                this.aUS.refresh();
            }
        }
    }
}
