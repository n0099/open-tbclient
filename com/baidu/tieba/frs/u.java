package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        bu buVar;
        b bVar;
        bu buVar2;
        boolean z2;
        bu buVar3;
        b bVar2;
        if (z) {
            buVar = this.aBk.aAv;
            if (!buVar.Gl()) {
                bVar = this.aBk.azE;
                if (bVar != null) {
                    bVar2 = this.aBk.azE;
                    if (bVar2.Fe().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aBk;
                buVar2 = this.aBk.aAv;
                frsActivity.hideNetRefreshView(buVar2.getRootView());
                z2 = this.aBk.aAj;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aBk;
                    buVar3 = this.aBk.aAv;
                    frsActivity2.showLoadingView(buVar3.getRootView(), true);
                }
                this.aBk.refresh();
            }
        }
    }
}
