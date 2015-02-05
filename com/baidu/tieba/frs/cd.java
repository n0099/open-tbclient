package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements com.baidu.tbadk.widget.p {
    final /* synthetic */ bp aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bp bpVar) {
        this.aGg = bpVar;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aGg.atP;
            if (bannerView.tx()) {
                z2 = this.aGg.aFQ;
                if (!z2) {
                    bdTypeListView = this.aGg.aFl;
                    if (bdTypeListView != null) {
                        this.aGg.aFQ = true;
                        bdTypeListView2 = this.aGg.aFl;
                        bannerView2 = this.aGg.atP;
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
