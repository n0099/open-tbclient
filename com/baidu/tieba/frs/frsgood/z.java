package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements BannerView.a {
    final /* synthetic */ y bst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bst = yVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void Bp() {
        com.baidu.tbadk.core.data.p pVar;
        com.baidu.tbadk.core.data.p pVar2;
        pVar = this.bst.boT;
        if (pVar != null) {
            pVar2 = this.bst.boT;
            if (pVar2.getType() == 2) {
                this.bst.RF();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void Bq() {
        this.bst.RT();
    }
}
