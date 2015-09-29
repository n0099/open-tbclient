package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements TbImageView.a {
    final /* synthetic */ bs aWS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bs bsVar) {
        this.aWS = bsVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.aWS.aKh;
            if (bannerView.yJ()) {
                z2 = this.aWS.aWI;
                if (!z2) {
                    bdTypeListView = this.aWS.aWs;
                    if (bdTypeListView != null) {
                        this.aWS.aWI = true;
                        bdTypeListView2 = this.aWS.aWs;
                        bannerView2 = this.aWS.aKh;
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
