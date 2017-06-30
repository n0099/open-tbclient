package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements NoNetworkView.a {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(r rVar) {
        this.cdl = rVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        if (this.cdl.ccs.agN() == 1 && z && !this.cdl.ccj.ael()) {
            if (this.cdl.cbN == null || com.baidu.tbadk.core.util.z.t(this.cdl.cbN.getThreadList())) {
                this.cdl.hideNetRefreshView(this.cdl.ccj.Vf());
                this.cdl.showLoadingView(this.cdl.ccj.Vf(), true);
                this.cdl.ccj.ex(false);
                this.cdl.refresh();
                return;
            }
            this.cdl.ccj.aey();
        }
    }
}
