package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements com.baidu.tbadk.widget.n {
    final /* synthetic */ bf aMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bf bfVar) {
        this.aMc = bfVar;
    }

    @Override // com.baidu.tbadk.widget.n
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aMc.aBI;
            if (bannerView.wW()) {
                z2 = this.aMc.aLR;
                if (!z2) {
                    bdTypeListView = this.aMc.aLu;
                    if (bdTypeListView != null) {
                        this.aMc.aLR = true;
                        bdTypeListView2 = this.aMc.aLu;
                        bannerView2 = this.aMc.aBI;
                        bdTypeListView2.d(bannerView2, 1);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
    }
}
