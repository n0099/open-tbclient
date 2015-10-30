package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TbImageView.a {
    final /* synthetic */ x aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.aZW = xVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aZW.aKs;
            if (bannerView.yG()) {
                z2 = this.aZW.aWT;
                if (!z2) {
                    bdTypeListView = this.aZW.aWD;
                    if (bdTypeListView != null) {
                        this.aZW.aWT = true;
                        bdTypeListView2 = this.aZW.aWD;
                        bannerView2 = this.aZW.aKs;
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
