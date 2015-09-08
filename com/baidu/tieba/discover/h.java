package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements BannerView.a {
    final /* synthetic */ a aLD;
    private final /* synthetic */ String aLF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.aLD = aVar;
        this.aLF = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void zb() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aLD.aLm;
        bannerView = this.aLD.aLp;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BannerView.a
    public void za() {
        if (!StringUtils.isNull(this.aLF)) {
            ax.uX().b(this.aLD.getPageContext(), new String[]{this.aLF});
        }
    }
}
