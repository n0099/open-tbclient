package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dFB;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dFB = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dFB != null && this.dFB.auN() != null && this.dFB.auN().ayU() != null && this.dFB.auS() != null && bVar != null && this.dFB.auS().getListView() != null && this.dFB.auP() != null) {
            BdTypeRecyclerView listView = this.dFB.auS().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dFB.auP().nS(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dFB.auP().nS(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
