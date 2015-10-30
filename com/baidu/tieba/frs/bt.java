package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements BannerView.a {
    final /* synthetic */ bs aXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.aXd = bsVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yH() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.aXd.aWS;
        if (jVar != null) {
            jVar2 = this.aXd.aWS;
            if (jVar2.getType() == 2) {
                this.aXd.LC();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yI() {
        this.aXd.LQ();
    }
}
