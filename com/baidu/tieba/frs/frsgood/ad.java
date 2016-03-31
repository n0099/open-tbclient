package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements TbImageView.a {
    final /* synthetic */ y bst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(y yVar) {
        this.bst = yVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void s(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.bst.boS;
            if (bannerView.Bo()) {
                z2 = this.bst.boU;
                if (!z2) {
                    bdTypeListView = this.bst.boD;
                    if (bdTypeListView != null) {
                        this.bst.boU = true;
                        bdTypeListView2 = this.bst.boD;
                        bannerView2 = this.bst.boS;
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
