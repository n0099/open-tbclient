package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dJC;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dJC = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dJC != null && this.dJC.aAD() != null && this.dJC.aAD().aFM() != null && this.dJC.aAI() != null && bVar != null && this.dJC.aAI().getListView() != null && this.dJC.aAF() != null) {
            BdTypeRecyclerView listView = this.dJC.aAI().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dJC.aAF().nx(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dJC.aAF().nx(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
