package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements BannerView.a {
    final /* synthetic */ bi aXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.aXy = biVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void za() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.aXy.aXn;
        if (jVar != null) {
            jVar2 = this.aXy.aXn;
            if (jVar2.getType() == 2) {
                this.aXy.LH();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zb() {
        this.aXy.LV();
    }
}
