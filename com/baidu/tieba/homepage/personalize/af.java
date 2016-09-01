package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements BdListView.e {
    final /* synthetic */ z cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(z zVar) {
        this.cFs = zVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        PbListView pbListView;
        b bVar;
        PbListView pbListView2;
        PbListView pbListView3;
        TbPageContext tbPageContext;
        pbListView = this.cFs.bvo;
        if (pbListView != null) {
            pbListView2 = this.cFs.bvo;
            pbListView2.wl();
            pbListView3 = this.cFs.bvo;
            tbPageContext = this.cFs.pageContext;
            pbListView3.di(com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), t.e.ds110));
        }
        bVar = this.cFs.cFn;
        bVar.aba();
    }
}
