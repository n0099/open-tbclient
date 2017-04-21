package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements NoNetworkView.a {
    final /* synthetic */ f bGP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.bGP = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.bGP.bGN == 0 && this.bGP.bGG != null) {
            this.bGP.bGG.dq(z);
        }
    }
}
