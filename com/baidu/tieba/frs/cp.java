package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements BannerView.a {
    final /* synthetic */ cn bkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cn cnVar) {
        this.bkx = cnVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zj() {
        this.bkx.QH();
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zk() {
        this.bkx.QT();
    }
}
