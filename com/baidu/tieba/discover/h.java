package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements BannerView.a {
    final /* synthetic */ a aRT;
    private final /* synthetic */ String aRV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.aRT = aVar;
        this.aRV = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zv() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aRT.aRC;
        bannerView = this.aRT.aRF;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zu() {
        if (!StringUtils.isNull(this.aRV)) {
            bf.vn().b(this.aRT.getPageContext(), new String[]{this.aRV});
        }
    }
}
