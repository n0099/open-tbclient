package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ a aDT;
    private final /* synthetic */ String aDV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.aDT = aVar;
        this.aDV = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void xL() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aDT.aDC;
        bannerView = this.aDT.aDF;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void xK() {
        if (!StringUtils.isNull(this.aDV)) {
            bi.tO().b(this.aDT.getPageContext(), new String[]{this.aDV});
        }
    }
}
