package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dMZ;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dMZ = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dMZ != null && this.dMZ.aBP() != null && this.dMZ.aBP().aGY() != null && this.dMZ.aBU() != null && bVar != null && this.dMZ.aBU().getListView() != null && this.dMZ.aBR() != null) {
            BdTypeRecyclerView listView = this.dMZ.aBU().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dMZ.aBR().nL(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dMZ.aBR().nL(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
