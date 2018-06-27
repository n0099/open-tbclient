package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dkY;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dkY = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dkY != null && this.dkY.atD() != null && this.dkY.atD().ayA() != null && this.dkY.atI() != null && bVar != null && this.dkY.atI().getListView() != null && this.dkY.atF() != null) {
            BdTypeRecyclerView listView = this.dkY.atI().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dkY.atF().lE(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dkY.atF().lE(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
