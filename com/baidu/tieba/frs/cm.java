package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements TbImageView.a {
    final /* synthetic */ cg bhg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cg cgVar) {
        this.bhg = cgVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.bhg.aRF;
            if (bannerView.zt()) {
                z2 = this.bhg.bgW;
                if (!z2) {
                    bdTypeListView = this.bhg.bgG;
                    if (bdTypeListView != null) {
                        this.bhg.bgW = true;
                        bdTypeListView2 = this.bhg.bgG;
                        bannerView2 = this.bhg.aRF;
                        bdTypeListView2.d(bannerView2, 1);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
