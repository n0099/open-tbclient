package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements NoNetworkView.a {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(r rVar) {
        this.bPn = rVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        if (this.bPn.bOw.abQ() == 1 && z && !this.bPn.bOn.Zr()) {
            if (this.bPn.bNT == null || com.baidu.tbadk.core.util.x.r(this.bPn.bNT.getThreadList())) {
                this.bPn.hideNetRefreshView(this.bPn.bOn.ZP());
                this.bPn.showLoadingView(this.bPn.bOn.ZP(), true);
                this.bPn.bOn.dP(false);
                this.bPn.refresh();
                return;
            }
            this.bPn.bOn.ZE();
        }
    }
}
