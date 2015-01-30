package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.aDW = frsActivity;
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
            bpVar = this.aDW.aCY;
            if (!bpVar.GP()) {
                eVar = this.aDW.aDi;
                if (eVar != null) {
                    eVar2 = this.aDW.aDi;
                    if (eVar2.aeO().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aDW;
                bpVar2 = this.aDW.aCY;
                frsActivity.hideNetRefreshView(bpVar2.getRootView());
                z2 = this.aDW.aCM;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aDW;
                    bpVar3 = this.aDW.aCY;
                    frsActivity2.showLoadingView(bpVar3.getRootView(), true);
                }
                this.aDW.refresh();
            }
        }
    }
}
