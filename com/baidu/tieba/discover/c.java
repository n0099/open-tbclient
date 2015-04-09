package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ a aBS;
    private final /* synthetic */ String aBT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.aBS = aVar;
        this.aBT = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void wY() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aBS.aBF;
        bannerView = this.aBS.aBI;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void wX() {
        if (!StringUtils.isNull(this.aBT)) {
            bk.tl().b(this.aBS.getPageContext(), new String[]{this.aBT});
        }
    }
}
