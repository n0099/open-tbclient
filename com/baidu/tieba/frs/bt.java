package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements BannerView.a {
    final /* synthetic */ bs aXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.aXm = bsVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yM() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.aXm.aXa;
        if (jVar != null) {
            jVar2 = this.aXm.aXa;
            if (jVar2.getType() == 2) {
                this.aXm.LS();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yN() {
        this.aXm.Mg();
    }
}
