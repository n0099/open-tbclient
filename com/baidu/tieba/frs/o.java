package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class o {
    private com.baidu.tieba.frs.mc.l hBV;

    public o(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.hBV = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hBV != null && this.hBV.bXV() != null && this.hBV.bXV().cdo() != null && this.hBV.bYa() != null && bVar != null && this.hBV.bYa().getListView() != null && this.hBV.bXX() != null) {
            BdTypeRecyclerView listView = this.hBV.bYa().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.hBV.bXX().we(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.hBV.bXX().we(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
