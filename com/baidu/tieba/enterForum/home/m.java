package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NoNetworkView.a {
    final /* synthetic */ d aMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.aMQ = dVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        if (!z) {
            this.aMQ.aMz.IZ();
        } else if (!this.aMQ.isPrimary() || !this.aMQ.isResumed()) {
            this.aMQ.aMz.IZ();
        } else {
            this.aMQ.aMz.nv();
        }
    }
}
