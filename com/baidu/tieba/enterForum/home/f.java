package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements NoNetworkView.a {
    final /* synthetic */ e aWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aWp = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        if (this.aWp.aWo == 0 && this.aWp.aWi != null) {
            this.aWp.aWi.bY(z);
        } else if (this.aWp.aWo == 1 && this.aWp.aWj != null) {
            this.aWp.aWj.bY(z);
        }
    }
}
