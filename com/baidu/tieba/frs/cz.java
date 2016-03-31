package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements TbImageView.a {
    final /* synthetic */ cs bpe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cs csVar) {
        this.bpe = csVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void s(String str, boolean z) {
        BannerView bannerView;
        BannerView bannerView2;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView3;
        if (z) {
            bannerView = this.bpe.boS;
            if (bannerView != null) {
                bannerView2 = this.bpe.boS;
                if (bannerView2.Bo()) {
                    z2 = this.bpe.boU;
                    if (!z2) {
                        bdTypeListView = this.bpe.boD;
                        if (bdTypeListView != null) {
                            this.bpe.boU = true;
                            bdTypeListView2 = this.bpe.boD;
                            bannerView3 = this.bpe.boS;
                            bdTypeListView2.f(bannerView3, 1);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
