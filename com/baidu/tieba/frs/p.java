package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class p {
    private com.baidu.tieba.frs.mc.l jcW;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.jcW = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jcW != null && this.jcW.cBd() != null && this.jcW.cBd().cHO() != null && this.jcW.cBi() != null && bVar != null && this.jcW.cBi().getListView() != null && this.jcW.cBf() != null) {
            BdTypeRecyclerView listView = this.jcW.cBi().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.jcW.cBf().As(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.jcW.cBf().As(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
