package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class l {
    private com.baidu.tieba.frs.mc.l gqU;

    public l(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.gqU = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gqU != null && this.gqU.bDT() != null && this.gqU.bDT().bIZ() != null && this.gqU.bDY() != null && bVar != null && this.gqU.bDY().getListView() != null && this.gqU.bDV() != null) {
            BdTypeRecyclerView listView = this.gqU.bDY().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.gqU.bDV().uu(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.gqU.bDV().uu(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
