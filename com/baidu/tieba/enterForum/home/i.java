package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements NoNetworkView.a {
    final /* synthetic */ f bxz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.bxz = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        if (this.bxz.bxx == 0 && this.bxz.bxq != null) {
            this.bxz.bxq.de(z);
        }
    }
}
