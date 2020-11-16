package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes21.dex */
public class p {
    private com.baidu.tieba.frs.mc.l iKw;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.iKw = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iKw != null && this.iKw.cxJ() != null && this.iKw.cxJ().cDr() != null && this.iKw.cxO() != null && bVar != null && this.iKw.cxO().getListView() != null && this.iKw.cxL() != null) {
            BdTypeRecyclerView listView = this.iKw.cxO().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.iKw.cxL().AY(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.iKw.cxL().AY(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
