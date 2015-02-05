package com.baidu.tieba.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.coreExtra.view.b {
    final /* synthetic */ a atZ;
    private final /* synthetic */ String aua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.atZ = aVar;
        this.aua = str;
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void tz() {
        BdListView bdListView;
        BannerView bannerView;
        bdListView = this.atZ.atL;
        bannerView = this.atZ.atP;
        bdListView.removeHeaderView(bannerView);
    }

    @Override // com.baidu.tbadk.coreExtra.view.b
    public void ty() {
        if (!StringUtils.isNull(this.aua)) {
            bm.pO().b(this.atZ.getPageContext(), new String[]{this.aua});
        }
    }
}
