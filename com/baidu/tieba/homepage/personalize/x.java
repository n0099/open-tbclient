package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.e {
    final /* synthetic */ s crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(s sVar) {
        this.crd = sVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        PbListView pbListView;
        a aVar;
        PbListView pbListView2;
        PbListView pbListView3;
        TbPageContext tbPageContext;
        pbListView = this.crd.biC;
        if (pbListView != null) {
            pbListView2 = this.crd.biC;
            pbListView2.vh();
            pbListView3 = this.crd.biC;
            tbPageContext = this.crd.pageContext;
            pbListView3.cU(com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds110));
        }
        aVar = this.crd.cqY;
        aVar.UU();
    }
}
