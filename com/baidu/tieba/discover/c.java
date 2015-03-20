package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ a aBK;
    private final /* synthetic */ String aBL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.aBK = aVar;
        this.aBL = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void wS() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.aBK.aBx;
        bannerView = this.aBK.aBA;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void wR() {
        if (!StringUtils.isNull(this.aBL)) {
            bk.tl().b(this.aBK.getPageContext(), new String[]{this.aBL});
        }
    }
}
