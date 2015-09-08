package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements BannerView.a {
    final /* synthetic */ x aZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.aZS = xVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void za() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.aZS.aXn;
        if (jVar != null) {
            jVar2 = this.aZS.aXn;
            if (jVar2.getType() == 2) {
                this.aZS.LH();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zb() {
        this.aZS.LV();
    }
}
