package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void at(boolean z) {
        bp bpVar;
        com.baidu.tieba.tbadkCore.e eVar;
        bp bpVar2;
        boolean z2;
        bp bpVar3;
        com.baidu.tieba.tbadkCore.e eVar2;
        if (z) {
            bpVar = this.aDT.aCV;
            if (!bpVar.GJ()) {
                eVar = this.aDT.aDf;
                if (eVar != null) {
                    eVar2 = this.aDT.aDf;
                    if (eVar2.aeJ().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aDT;
                bpVar2 = this.aDT.aCV;
                frsActivity.hideNetRefreshView(bpVar2.getRootView());
                z2 = this.aDT.aCJ;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aDT;
                    bpVar3 = this.aDT.aCV;
                    frsActivity2.showLoadingView(bpVar3.getRootView(), true);
                }
                this.aDT.refresh();
            }
        }
    }
}
