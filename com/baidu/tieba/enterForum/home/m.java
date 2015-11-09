package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NoNetworkView.a {
    final /* synthetic */ d aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.aMe = dVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        if (!z) {
            this.aMe.aLN.Jg();
        } else if (!this.aMe.isPrimary() || !this.aMe.isResumed()) {
            this.aMe.aLN.Jg();
        } else {
            this.aMe.aLN.nx();
        }
    }
}
