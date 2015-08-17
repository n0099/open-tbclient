package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NoNetworkView.a {
    final /* synthetic */ d aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.aMD = dVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        if (!z) {
            this.aMD.aMm.Jl();
        } else if (!this.aMD.isPrimary() || !this.aMD.isResumed()) {
            this.aMD.aMm.Jl();
        } else {
            this.aMD.aMm.ny();
        }
    }
}
