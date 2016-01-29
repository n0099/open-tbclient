package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements BannerView.a {
    final /* synthetic */ y bnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bnw = yVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void AM() {
        com.baidu.tbadk.core.data.m mVar;
        com.baidu.tbadk.core.data.m mVar2;
        mVar = this.bnw.bjJ;
        if (mVar != null) {
            mVar2 = this.bnw.bjJ;
            if (mVar2.getType() == 2) {
                this.bnw.PM();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void AN() {
        this.bnw.Qa();
    }
}
