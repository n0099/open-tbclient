package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements BannerView.a {
    final /* synthetic */ x aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.aZW = xVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yH() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.aZW.aWS;
        if (jVar != null) {
            jVar2 = this.aZW.aWS;
            if (jVar2.getType() == 2) {
                this.aZW.LC();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yI() {
        this.aZW.LQ();
    }
}
