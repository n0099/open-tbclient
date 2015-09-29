package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements BannerView.a {
    final /* synthetic */ a aKv;
    private final /* synthetic */ String aKx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.aKv = aVar;
        this.aKx = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yL() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aKv.aKe;
        bannerView = this.aKv.aKh;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yK() {
        if (!StringUtils.isNull(this.aKx)) {
            ay.uV().b(this.aKv.getPageContext(), new String[]{this.aKx});
        }
    }
}
