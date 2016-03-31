package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements BannerView.a {
    final /* synthetic */ cs bpe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar) {
        this.bpe = csVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void Bp() {
        com.baidu.tbadk.core.data.p pVar;
        com.baidu.tbadk.core.data.p pVar2;
        pVar = this.bpe.boT;
        if (pVar != null) {
            pVar2 = this.bpe.boT;
            if (pVar2.getType() == 2) {
                this.bpe.RF();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void Bq() {
        this.bpe.RT();
    }
}
