package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements NoNetworkView.a {
    final /* synthetic */ f bpN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.bpN = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        if (this.bpN.bpL == 0 && this.bpN.bpE != null) {
            this.bpN.bpE.cX(z);
        }
    }
}
