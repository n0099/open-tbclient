package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements BannerView.a {
    final /* synthetic */ x bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bkz = xVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zu() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.bkz.bgV;
        if (jVar != null) {
            jVar2 = this.bkz.bgV;
            if (jVar2.getType() == 2) {
                this.bkz.NM();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zv() {
        this.bkz.Oa();
    }
}
