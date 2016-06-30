package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class z implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aD(boolean z) {
        bq bqVar;
        com.baidu.tieba.tbadkCore.p pVar;
        bq bqVar2;
        boolean z2;
        bq bqVar3;
        bq bqVar4;
        com.baidu.tieba.tbadkCore.p pVar2;
        if (z) {
            bqVar = this.bDB.bCD;
            if (!bqVar.VD()) {
                pVar = this.bDB.bCF;
                if (pVar != null) {
                    pVar2 = this.bDB.bCF;
                    if (pVar2.getThreadList().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.bDB;
                bqVar2 = this.bDB.bCD;
                frsActivity.hideNetRefreshView(bqVar2.getRootView());
                z2 = this.bDB.bCo;
                if (!z2) {
                    FrsActivity frsActivity2 = this.bDB;
                    bqVar3 = this.bDB.bCD;
                    frsActivity2.showLoadingView(bqVar3.getRootView(), true);
                    bqVar4 = this.bDB.bCD;
                    bqVar4.m12do(false);
                }
                this.bDB.refresh();
            }
        }
    }
}
