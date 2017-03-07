package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements NoNetworkView.a {
    final /* synthetic */ f bEF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.bEF = fVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        if (this.bEF.bED == 0 && this.bEF.bEw != null) {
            this.bEF.bEw.de(z);
        }
    }
}
