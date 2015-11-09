package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements TbImageView.a {
    final /* synthetic */ x bap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.bap = xVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.bap.aJm;
            if (bannerView.yL()) {
                z2 = this.bap.aXb;
                if (!z2) {
                    bdTypeListView = this.bap.aWL;
                    if (bdTypeListView != null) {
                        this.bap.aXb = true;
                        bdTypeListView2 = this.bap.aWL;
                        bannerView2 = this.bap.aJm;
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
