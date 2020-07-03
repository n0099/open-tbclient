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
        if (this.hBV != null && this.hBV.bXU() != null && this.hBV.bXU().cdn() != null && this.hBV.bXZ() != null && bVar != null && this.hBV.bXZ().getListView() != null && this.hBV.bXW() != null) {
            BdTypeRecyclerView listView = this.hBV.bXZ().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.hBV.bXW().we(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.hBV.bXW().we(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
