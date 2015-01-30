package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ a auc;
    private final /* synthetic */ String aud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.auc = aVar;
        this.aud = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void tF() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.auc.atO;
        bannerView = this.auc.atS;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void tE() {
        if (!StringUtils.isNull(this.aud)) {
            bm.pV().b(this.auc.getPageContext(), new String[]{this.aud});
        }
    }
}
