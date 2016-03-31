package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements NoNetworkView.a {
    final /* synthetic */ e baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.baY = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        if (this.baY.baX == 0 && this.baY.baR != null) {
            this.baY.baR.ck(z);
        } else if (this.baY.baX == 1 && this.baY.baS != null) {
            this.baY.baS.ck(z);
        }
    }
}
