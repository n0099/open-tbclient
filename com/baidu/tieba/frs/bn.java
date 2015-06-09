package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements com.baidu.tbadk.widget.n {
    final /* synthetic */ bf aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bf bfVar) {
        this.aOn = bfVar;
    }

    @Override // com.baidu.tbadk.widget.n
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aOn.aDF;
            if (bannerView.xJ()) {
                z2 = this.aOn.aOc;
                if (!z2) {
                    bdTypeListView = this.aOn.aNE;
                    if (bdTypeListView != null) {
                        this.aOn.aOc = true;
                        bdTypeListView2 = this.aOn.aNE;
                        bannerView2 = this.aOn.aDF;
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
