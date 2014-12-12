package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements com.baidu.tbadk.widget.p {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(bq bqVar) {
        this.aFg = bqVar;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aFg.asL;
            if (bannerView.tm()) {
                z2 = this.aFg.aEQ;
                if (!z2) {
                    bdTypeListView = this.aFg.aEm;
                    if (bdTypeListView != null) {
                        this.aFg.aEQ = true;
                        bdTypeListView2 = this.aFg.aEm;
                        bannerView2 = this.aFg.asL;
                        bdTypeListView2.d(bannerView2, 1);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
    }
}
