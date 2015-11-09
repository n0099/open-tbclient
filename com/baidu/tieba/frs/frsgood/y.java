package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements BannerView.a {
    final /* synthetic */ x bap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bap = xVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yM() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.bap.aXa;
        if (jVar != null) {
            jVar2 = this.bap.aXa;
            if (jVar2.getType() == 2) {
                this.bap.LS();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yN() {
        this.bap.Mg();
    }
}
