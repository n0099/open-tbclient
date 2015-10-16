package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements BannerView.a {
    final /* synthetic */ a aKG;
    private final /* synthetic */ String aKI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.aKG = aVar;
        this.aKI = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yL() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aKG.aKp;
        bannerView = this.aKG.aKs;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yK() {
        if (!StringUtils.isNull(this.aKI)) {
            az.uW().b(this.aKG.getPageContext(), new String[]{this.aKI});
        }
    }
}
