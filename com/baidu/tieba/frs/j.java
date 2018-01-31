package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dCQ;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dCQ = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dCQ != null && this.dCQ.atY() != null && this.dCQ.atY().axV() != null && this.dCQ.aud() != null && bVar != null && this.dCQ.aud().getListView() != null && this.dCQ.aua() != null) {
            BdTypeRecyclerView listView = this.dCQ.aud().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dCQ.aua().nS(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dCQ.aua().nS(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
