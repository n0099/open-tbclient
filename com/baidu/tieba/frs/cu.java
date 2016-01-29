package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements TbImageView.a {
    final /* synthetic */ cn bjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cn cnVar) {
        this.bjV = cnVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.bjV.bjI;
            if (bannerView.AL()) {
                z2 = this.bjV.bjK;
                if (!z2) {
                    bdTypeListView = this.bjV.bjt;
                    if (bdTypeListView != null) {
                        this.bjV.bjK = true;
                        bdTypeListView2 = this.bjV.bjt;
                        bannerView2 = this.bjV.bjI;
                        bdTypeListView2.f(bannerView2, 1);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
