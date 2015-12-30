package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TbImageView.a {
    final /* synthetic */ x bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.bkz = xVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.bkz.aRF;
            if (bannerView.zt()) {
                z2 = this.bkz.bgW;
                if (!z2) {
                    bdTypeListView = this.bkz.bgG;
                    if (bdTypeListView != null) {
                        this.bkz.bgW = true;
                        bdTypeListView2 = this.bkz.bgG;
                        bannerView2 = this.bkz.aRF;
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
