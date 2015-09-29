package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TbImageView.a {
    final /* synthetic */ x aZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.aZL = xVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aZL.aKh;
            if (bannerView.yJ()) {
                z2 = this.aZL.aWI;
                if (!z2) {
                    bdTypeListView = this.aZL.aWs;
                    if (bdTypeListView != null) {
                        this.aZL.aWI = true;
                        bdTypeListView2 = this.aZL.aWs;
                        bannerView2 = this.aZL.aKh;
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
