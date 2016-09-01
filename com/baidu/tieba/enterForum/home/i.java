package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements NoNetworkView.a {
    final /* synthetic */ e bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.bGG = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aH(boolean z) {
        if (this.bGG.bGD == 0 && this.bGG.bGw != null) {
            this.bGG.bGw.dj(z);
        }
    }
}
