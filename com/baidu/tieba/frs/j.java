package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dNa;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dNa = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dNa != null && this.dNa.aBP() != null && this.dNa.aBP().aGY() != null && this.dNa.aBU() != null && bVar != null && this.dNa.aBU().getListView() != null && this.dNa.aBR() != null) {
            BdTypeRecyclerView listView = this.dNa.aBU().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dNa.aBR().nL(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dNa.aBR().nL(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
