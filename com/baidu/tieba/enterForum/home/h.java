package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements NoNetworkView.a {
    final /* synthetic */ e aXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aXh = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aF(boolean z) {
        if (this.aXh.aXf == 0 && this.aXh.aWX != null) {
            this.aXh.aWX.cr(z);
        } else if (this.aXh.aWY != null && this.aXh.aXf == this.aXh.aWY.aYo) {
            this.aXh.aWY.aYq.cr(z);
        }
    }
}
