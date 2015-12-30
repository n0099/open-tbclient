package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements BannerView.a {
    final /* synthetic */ cg bhg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.bhg = cgVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zu() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.bhg.bgV;
        if (jVar != null) {
            jVar2 = this.bhg.bgV;
            if (jVar2.getType() == 2) {
                this.bhg.NM();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zv() {
        this.bhg.Oa();
    }
}
