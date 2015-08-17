package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements TbImageView.a {
    final /* synthetic */ bl aXC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bl blVar) {
        this.aXC = blVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aXC.aLc;
            if (bannerView.yS()) {
                z2 = this.aXC.aXr;
                if (!z2) {
                    bdTypeListView = this.aXC.aWY;
                    if (bdTypeListView != null) {
                        this.aXC.aXr = true;
                        bdTypeListView2 = this.aXC.aWY;
                        bannerView2 = this.aXC.aLc;
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
