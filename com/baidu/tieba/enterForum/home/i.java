package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements NoNetworkView.a {
    final /* synthetic */ f bJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.bJJ = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        if (this.bJJ.bJH == 0 && this.bJJ.bJB != null) {
            this.bJJ.bJB.dp(z);
        }
    }
}
