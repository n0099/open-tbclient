package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dFF;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dFF = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dFF != null && this.dFF.auO() != null && this.dFF.auO().ayW() != null && this.dFF.auT() != null && bVar != null && this.dFF.auT().getListView() != null && this.dFF.auQ() != null) {
            BdTypeRecyclerView listView = this.dFF.auT().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dFF.auQ().nS(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dFF.auQ().nS(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
