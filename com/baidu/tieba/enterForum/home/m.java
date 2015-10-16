package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NoNetworkView.a {
    final /* synthetic */ d aLW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.aLW = dVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        if (!z) {
            this.aLW.aLF.IU();
        } else if (!this.aLW.isPrimary() || !this.aLW.isResumed()) {
            this.aLW.aLF.IU();
        } else {
            this.aLW.aLF.nw();
        }
    }
}
