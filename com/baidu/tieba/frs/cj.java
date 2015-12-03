package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements TbImageView.a {
    final /* synthetic */ cd bdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cd cdVar) {
        this.bdg = cdVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        BannerView bannerView;
        boolean z2;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BannerView bannerView2;
        if (z) {
            bannerView = this.bdg.aNN;
            if (bannerView.zH()) {
                z2 = this.bdg.bcW;
                if (!z2) {
                    bdTypeListView = this.bdg.bcG;
                    if (bdTypeListView != null) {
                        this.bdg.bcW = true;
                        bdTypeListView2 = this.bdg.bcG;
                        bannerView2 = this.bdg.aNN;
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
