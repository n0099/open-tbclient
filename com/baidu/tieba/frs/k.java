package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class k {
    private com.baidu.tieba.frs.mc.l gkL;

    public k(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.gkL = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gkL != null && this.gkL.bBd() != null && this.gkL.bBd().bGh() != null && this.gkL.bBi() != null && bVar != null && this.gkL.bBi().getListView() != null && this.gkL.bBf() != null) {
            BdTypeRecyclerView listView = this.gkL.bBi().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.gkL.bBf().ud(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.gkL.bBf().ud(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
