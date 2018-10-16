package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dBM;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dBM = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dBM != null && this.dBM.azv() != null && this.dBM.azv().aEE() != null && this.dBM.azA() != null && bVar != null && this.dBM.azA().getListView() != null && this.dBM.azx() != null) {
            BdTypeRecyclerView listView = this.dBM.azA().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dBM.azx().mP(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dBM.azx().mP(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
