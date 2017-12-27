package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dxU;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dxU = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dxU != null && this.dxU.asQ() != null && this.dxU.asQ().awN() != null && this.dxU.asV() != null && bVar != null && this.dxU.asV().getListView() != null && this.dxU.asS() != null) {
            BdTypeRecyclerView listView = this.dxU.asV().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dxU.asS().nP(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dxU.asS().nP(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
