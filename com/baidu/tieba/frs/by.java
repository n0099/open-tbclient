package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements TbImageView.a {
    final /* synthetic */ bs aXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bs bsVar) {
        this.aXm = bsVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aXm.aJm;
            if (bannerView.yL()) {
                z2 = this.aXm.aXb;
                if (!z2) {
                    bdTypeListView = this.aXm.aWL;
                    if (bdTypeListView != null) {
                        this.aXm.aXb = true;
                        bdTypeListView2 = this.aXm.aWL;
                        bannerView2 = this.aXm.aJm;
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
