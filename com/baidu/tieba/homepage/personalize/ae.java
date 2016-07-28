package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements BdListView.e {
    final /* synthetic */ z ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.ctN = zVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jC() {
        PbListView pbListView;
        b bVar;
        PbListView pbListView2;
        PbListView pbListView3;
        TbPageContext tbPageContext;
        pbListView = this.ctN.bjZ;
        if (pbListView != null) {
            pbListView2 = this.ctN.bjZ;
            pbListView2.vh();
            pbListView3 = this.ctN.bjZ;
            tbPageContext = this.ctN.pageContext;
            pbListView3.cU(com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), u.e.ds110));
        }
        bVar = this.ctN.ctI;
        bVar.Wd();
    }
}
