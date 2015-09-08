package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TbImageView.a {
    final /* synthetic */ x aZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.aZS = xVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aZS.aLp;
            if (bannerView.yZ()) {
                z2 = this.aZS.aXo;
                if (!z2) {
                    bdTypeListView = this.aZS.aWY;
                    if (bdTypeListView != null) {
                        this.aZS.aXo = true;
                        bdTypeListView2 = this.aZS.aWY;
                        bannerView2 = this.aZS.aLp;
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
