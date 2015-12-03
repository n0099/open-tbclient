package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TbImageView.a {
    final /* synthetic */ x bgI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.bgI = xVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.bgI.aNN;
            if (bannerView.zH()) {
                z2 = this.bgI.bcW;
                if (!z2) {
                    bdTypeListView = this.bgI.bcG;
                    if (bdTypeListView != null) {
                        this.bgI.bcW = true;
                        bdTypeListView2 = this.bgI.bcG;
                        bannerView2 = this.bgI.aNN;
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
