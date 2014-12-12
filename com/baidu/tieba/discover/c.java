package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ a asV;
    private final /* synthetic */ String asW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.asV = aVar;
        this.asW = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void to() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.asV.asI;
        bannerView = this.asV.asL;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void tn() {
        if (!StringUtils.isNull(this.asW)) {
            bh.pK().b(this.asV.getPageContext(), new String[]{this.asW});
        }
    }
}
