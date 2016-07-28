package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements NoNetworkView.a {
    final /* synthetic */ e bvs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bvs = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aG(boolean z) {
        if (this.bvs.bvq == 0 && this.bvs.bvj != null) {
            this.bvs.bvj.cP(z);
        } else if (this.bvs.bvk != null && this.bvs.bvq == this.bvs.bvk.bwu) {
            this.bvs.bvk.bww.cP(z);
        }
    }
}
