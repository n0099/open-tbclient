package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements BannerView.a {
    final /* synthetic */ bs aWS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.aWS = bsVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yK() {
        com.baidu.tbadk.core.data.i iVar;
        com.baidu.tbadk.core.data.i iVar2;
        iVar = this.aWS.aWH;
        if (iVar != null) {
            iVar2 = this.aWS.aWH;
            if (iVar2.getType() == 2) {
                this.aWS.LG();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yL() {
        this.aWS.LU();
    }
}
