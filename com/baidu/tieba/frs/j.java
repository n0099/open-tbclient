package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dFN;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dFN = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dFN != null && this.dFN.auO() != null && this.dFN.auO().ayV() != null && this.dFN.auT() != null && bVar != null && this.dFN.auT().getListView() != null && this.dFN.auQ() != null) {
            BdTypeRecyclerView listView = this.dFN.auT().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dFN.auQ().nS(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dFN.auQ().nS(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
