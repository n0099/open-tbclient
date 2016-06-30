package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements NoNetworkView.a {
    final /* synthetic */ e btd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.btd = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aD(boolean z) {
        if (this.btd.btb == 0 && this.btd.bsU != null) {
            this.btd.bsU.cM(z);
        } else if (this.btd.bsV != null && this.btd.btb == this.btd.bsV.bug) {
            this.btd.bsV.bui.cM(z);
        }
    }
}
