package com.baidu.tieba.frs;

import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements BannerView.a {
    final /* synthetic */ bq bFI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.bFI = bqVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zp() {
        this.bFI.Wf();
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zq() {
        this.bFI.Wp();
    }
}
