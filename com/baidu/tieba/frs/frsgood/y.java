package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements BannerView.a {
    final /* synthetic */ x bgI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bgI = xVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zI() {
        com.baidu.tbadk.core.data.j jVar;
        com.baidu.tbadk.core.data.j jVar2;
        jVar = this.bgI.bcV;
        if (jVar != null) {
            jVar2 = this.bgI.bcV;
            if (jVar2.getType() == 2) {
                this.bgI.Nt();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zJ() {
        this.bgI.NH();
    }
}
