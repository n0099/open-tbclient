package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements com.baidu.tbadk.widget.n {
    final /* synthetic */ bf aLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bf bfVar) {
        this.aLR = bfVar;
    }

    @Override // com.baidu.tbadk.widget.n
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aLR.aBA;
            if (bannerView.wQ()) {
                z2 = this.aLR.aLH;
                if (!z2) {
                    bdTypeListView = this.aLR.aLk;
                    if (bdTypeListView != null) {
                        this.aLR.aLH = true;
                        bdTypeListView2 = this.aLR.aLk;
                        bannerView2 = this.aLR.aBA;
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
