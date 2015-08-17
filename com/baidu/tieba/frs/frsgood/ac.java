package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TbImageView.a {
    final /* synthetic */ x aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.aZz = xVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aZz.aLc;
            if (bannerView.yS()) {
                z2 = this.aZz.aXr;
                if (!z2) {
                    bdTypeListView = this.aZz.aWY;
                    if (bdTypeListView != null) {
                        this.aZz.aXr = true;
                        bdTypeListView2 = this.aZz.aWY;
                        bannerView2 = this.aZz.aLc;
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
