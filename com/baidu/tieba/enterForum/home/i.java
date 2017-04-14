package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements NoNetworkView.a {
    final /* synthetic */ f bEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.bEy = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        if (this.bEy.bEw == 0 && this.bEy.bEp != null) {
            this.bEy.bEp.dg(z);
        }
    }
}
