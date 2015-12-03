package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements BannerView.a {
    final /* synthetic */ a aOb;
    private final /* synthetic */ String aOd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.aOb = aVar;
        this.aOd = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zJ() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aOb.aNK;
        bannerView = this.aOb.aNN;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zI() {
        if (!StringUtils.isNull(this.aOd)) {
            bf.vD().b(this.aOb.getPageContext(), new String[]{this.aOd});
        }
    }
}
