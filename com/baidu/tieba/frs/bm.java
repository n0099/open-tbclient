package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements BannerView.a {
    final /* synthetic */ bl aXC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.aXC = blVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yT() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.aXC.aXq;
        if (jVar != null) {
            jVar2 = this.aXC.aXq;
            if (jVar2.getType() == 2) {
                this.aXC.LQ();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yU() {
        this.aXC.Me();
    }
}
