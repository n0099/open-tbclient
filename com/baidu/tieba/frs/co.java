package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements BannerView.a {
    final /* synthetic */ cn bkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cn cnVar) {
        this.bkx = cnVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zk() {
        com.baidu.tbadk.core.data.p pVar;
        com.baidu.tbadk.core.data.p pVar2;
        pVar = this.bkx.bjZ;
        if (pVar != null) {
            pVar2 = this.bkx.bjZ;
            if (pVar2.getType() == 2) {
                this.bkx.QH();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zl() {
        this.bkx.QT();
    }
}
