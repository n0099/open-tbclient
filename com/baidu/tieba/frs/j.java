package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dnP;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dnP = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dnP != null && this.dnP.auh() != null && this.dnP.auh().azf() != null && this.dnP.aum() != null && bVar != null && this.dnP.aum().getListView() != null && this.dnP.auj() != null) {
            BdTypeRecyclerView listView = this.dnP.aum().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dnP.auj().lP(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dnP.auj().lP(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
