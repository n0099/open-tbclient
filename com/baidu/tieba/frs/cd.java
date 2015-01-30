package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements com.baidu.tbadk.widget.p {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bp bpVar) {
        this.aGj = bpVar;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aGj.atS;
            if (bannerView.tD()) {
                z2 = this.aGj.aFT;
                if (!z2) {
                    bdTypeListView = this.aGj.aFo;
                    if (bdTypeListView != null) {
                        this.aGj.aFT = true;
                        bdTypeListView2 = this.aGj.aFo;
                        bannerView2 = this.aGj.atS;
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
