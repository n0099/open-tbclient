package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class w implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aF(boolean z) {
        cn cnVar;
        com.baidu.tieba.tbadkCore.o oVar;
        cn cnVar2;
        boolean z2;
        cn cnVar3;
        cn cnVar4;
        com.baidu.tieba.tbadkCore.o oVar2;
        if (z) {
            cnVar = this.bhl.bgo;
            if (!cnVar.Qa()) {
                oVar = this.bhl.bgq;
                if (oVar != null) {
                    oVar2 = this.bhl.bgq;
                    if (oVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.bhl;
                cnVar2 = this.bhl.bgo;
                frsActivity.hideNetRefreshView(cnVar2.getRootView());
                z2 = this.bhl.bfZ;
                if (!z2) {
                    FrsActivity frsActivity2 = this.bhl;
                    cnVar3 = this.bhl.bgo;
                    frsActivity2.showLoadingView(cnVar3.getRootView(), true);
                    cnVar4 = this.bhl.bgo;
                    cnVar4.cT(false);
                }
                this.bhl.refresh();
            }
        }
    }
}
