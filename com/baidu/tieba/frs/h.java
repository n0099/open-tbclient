package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class h {
    private com.baidu.tieba.frs.mc.j cZH;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.cZH = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cZH != null && this.cZH.apg() != null && this.cZH.apg().atI() != null && this.cZH.apm() != null && bVar != null && this.cZH.apm().getListView() != null && this.cZH.apj() != null) {
            BdTypeRecyclerView listView = this.cZH.apm().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cZH.apj().lq(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cZH.apj().lq(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
