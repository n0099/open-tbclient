package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements NoNetworkView.a {
    final /* synthetic */ e aQs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aQs = eVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        int i;
        int i2;
        com.baidu.tieba.enterForum.square.b bVar;
        com.baidu.tieba.enterForum.square.b bVar2;
        h hVar;
        h hVar2;
        i = this.aQs.aQr;
        if (i == 0) {
            hVar = this.aQs.aQj;
            if (hVar != null) {
                hVar2 = this.aQs.aQj;
                hVar2.bZ(z);
                return;
            }
        }
        i2 = this.aQs.aQr;
        if (i2 == 1) {
            bVar = this.aQs.aQk;
            if (bVar != null) {
                bVar2 = this.aQs.aQk;
                bVar2.bZ(z);
            }
        }
    }
}
