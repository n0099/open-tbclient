package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements BannerView.a {
    final /* synthetic */ x aZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.aZL = xVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yK() {
        com.baidu.tbadk.core.data.i iVar;
        com.baidu.tbadk.core.data.i iVar2;
        iVar = this.aZL.aWH;
        if (iVar != null) {
            iVar2 = this.aZL.aWH;
            if (iVar2.getType() == 2) {
                this.aZL.LG();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yL() {
        this.aZL.LU();
    }
}
