package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ a aDS;
    private final /* synthetic */ String aDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.aDS = aVar;
        this.aDU = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void xK() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aDS.aDB;
        bannerView = this.aDS.aDE;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void xJ() {
        if (!StringUtils.isNull(this.aDU)) {
            bi.tO().b(this.aDS.getPageContext(), new String[]{this.aDU});
        }
    }
}
