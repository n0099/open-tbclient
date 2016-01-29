package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements TbImageView.a {
    final /* synthetic */ y bnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(y yVar) {
        this.bnw = yVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.bnw.bjI;
            if (bannerView.AL()) {
                z2 = this.bnw.bjK;
                if (!z2) {
                    bdTypeListView = this.bnw.bjt;
                    if (bdTypeListView != null) {
                        this.bnw.bjK = true;
                        bdTypeListView2 = this.bnw.bjt;
                        bannerView2 = this.bnw.bjI;
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
