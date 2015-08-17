package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements BannerView.a {
    final /* synthetic */ a aLq;
    private final /* synthetic */ String aLs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.aLq = aVar;
        this.aLs = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yU() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aLq.aKZ;
        bannerView = this.aLq.aLc;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void yT() {
        if (!StringUtils.isNull(this.aLs)) {
            ax.uR().b(this.aLq.getPageContext(), new String[]{this.aLs});
        }
    }
}
