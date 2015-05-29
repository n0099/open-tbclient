package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements com.baidu.tbadk.widget.n {
    final /* synthetic */ bf aOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bf bfVar) {
        this.aOm = bfVar;
    }

    @Override // com.baidu.tbadk.widget.n
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aOm.aDE;
            if (bannerView.xI()) {
                z2 = this.aOm.aOb;
                if (!z2) {
                    bdTypeListView = this.aOm.aND;
                    if (bdTypeListView != null) {
                        this.aOm.aOb = true;
                        bdTypeListView2 = this.aOm.aND;
                        bannerView2 = this.aOm.aDE;
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
