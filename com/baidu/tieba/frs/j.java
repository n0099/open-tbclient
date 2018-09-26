package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dtL;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dtL = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dtL != null && this.dtL.avZ() != null && this.dtL.avZ().aBl() != null && this.dtL.awe() != null && bVar != null && this.dtL.awe().getListView() != null && this.dtL.awb() != null) {
            BdTypeRecyclerView listView = this.dtL.awe().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dtL.awb().mr(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dtL.awb().mr(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
