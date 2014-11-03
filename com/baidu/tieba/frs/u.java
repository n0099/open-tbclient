package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.aBu = frsActivity;
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
            buVar = this.aBu.aAF;
            if (!buVar.Gn()) {
                bVar = this.aBu.azN;
                if (bVar != null) {
                    bVar2 = this.aBu.azN;
                    if (bVar2.Fg().size() != 0) {
                        return;
                    }
                }
                FrsActivity frsActivity = this.aBu;
                buVar2 = this.aBu.aAF;
                frsActivity.hideNetRefreshView(buVar2.getRootView());
                z2 = this.aBu.aAt;
                if (!z2) {
                    FrsActivity frsActivity2 = this.aBu;
                    buVar3 = this.aBu.aAF;
                    frsActivity2.showLoadingView(buVar3.getRootView(), true);
                }
                this.aBu.refresh();
            }
        }
    }
}
