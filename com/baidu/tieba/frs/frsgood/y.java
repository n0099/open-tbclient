package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements BannerView.a {
    final /* synthetic */ x aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.aZz = xVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yT() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.aZz.aXq;
        if (jVar != null) {
            jVar2 = this.aZz.aXq;
            if (jVar2.getType() == 2) {
                this.aZz.LQ();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yU() {
        this.aZz.Me();
    }
}
