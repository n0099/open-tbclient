package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class o implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        com.baidu.tieba.tbadkCore.p pVar;
        boolean z2;
        com.baidu.tieba.tbadkCore.p pVar2;
        if (z && !this.bed.bdm.No()) {
            pVar = this.bed.bdo;
            if (pVar != null) {
                pVar2 = this.bed.bdo;
                if (pVar2.getThreadList().size() != 0) {
                    return;
                }
            }
            this.bed.hideNetRefreshView(this.bed.bdm.getRootView());
            z2 = this.bed.bcZ;
            if (!z2) {
                this.bed.showLoadingView(this.bed.bdm.getRootView(), true);
                this.bed.bdm.Oe();
            }
            this.bed.refresh();
        }
    }
}
