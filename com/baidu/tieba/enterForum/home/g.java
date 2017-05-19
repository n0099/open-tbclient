package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements NoNetworkView.a {
    final /* synthetic */ e bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bGL = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        i iVar;
        iVar = this.bGL.bGE;
        iVar.ds(z);
    }
}
