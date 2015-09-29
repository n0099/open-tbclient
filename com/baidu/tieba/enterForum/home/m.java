package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NoNetworkView.a {
    final /* synthetic */ d aLL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.aLL = dVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        if (!z) {
            this.aLL.aLu.IU();
        } else if (!this.aLL.isPrimary() || !this.aLL.isResumed()) {
            this.aLL.aLu.IU();
        } else {
            this.aLL.aLu.nw();
        }
    }
}
