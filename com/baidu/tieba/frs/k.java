package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class k {
    private com.baidu.tieba.frs.mc.l gpV;

    public k(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.gpV = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gpV != null && this.gpV.bDI() != null && this.gpV.bDI().bIK() != null && this.gpV.bDN() != null && bVar != null && this.gpV.bDN().getListView() != null && this.gpV.bDK() != null) {
            BdTypeRecyclerView listView = this.gpV.bDN().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.gpV.bDK().uo(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.gpV.bDK().uo(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
