package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements TbImageView.a {
    final /* synthetic */ bs aXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bs bsVar) {
        this.aXd = bsVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aXd.aKs;
            if (bannerView.yJ()) {
                z2 = this.aXd.aWT;
                if (!z2) {
                    bdTypeListView = this.aXd.aWD;
                    if (bdTypeListView != null) {
                        this.aXd.aWT = true;
                        bdTypeListView2 = this.aXd.aWD;
                        bannerView2 = this.aXd.aKs;
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
