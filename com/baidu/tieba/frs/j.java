package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dMq;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dMq = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dMq != null && this.dMq.aBs() != null && this.dMq.aBs().aGB() != null && this.dMq.aBx() != null && bVar != null && this.dMq.aBx().getListView() != null && this.dMq.aBu() != null) {
            BdTypeRecyclerView listView = this.dMq.aBx().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dMq.aBu().nK(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dMq.aBu().nK(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
