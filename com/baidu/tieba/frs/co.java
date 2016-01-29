package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements BannerView.a {
    final /* synthetic */ cn bjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cn cnVar) {
        this.bjV = cnVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void AM() {
        com.baidu.tbadk.core.data.m mVar;
        com.baidu.tbadk.core.data.m mVar2;
        mVar = this.bjV.bjJ;
        if (mVar != null) {
            mVar2 = this.bjV.bjJ;
            if (mVar2.getType() == 2) {
                this.bjV.PM();
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void AN() {
        this.bjV.Qa();
    }
}
