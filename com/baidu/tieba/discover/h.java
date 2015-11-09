package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements BannerView.a {
    final /* synthetic */ a aJA;
    private final /* synthetic */ String aJC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.aJA = aVar;
        this.aJC = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yN() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aJA.aJj;
        bannerView = this.aJA.aJm;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yM() {
        if (!StringUtils.isNull(this.aJC)) {
            az.uX().b(this.aJA.getPageContext(), new String[]{this.aJC});
        }
    }
}
