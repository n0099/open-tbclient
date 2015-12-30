package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements NoNetworkView.a {
    final /* synthetic */ e aUi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aUi = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        if (this.aUi.aUh == 0 && this.aUi.aUb != null) {
            this.aUi.aUb.ca(z);
        } else if (this.aUi.aUh == 1 && this.aUi.aUc != null) {
            this.aUi.aUc.ca(z);
        }
    }
}
