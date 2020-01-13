package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public class k {
    private com.baidu.tieba.frs.mc.l gnU;

    public k(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.gnU = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gnU != null && this.gnU.bCf() != null && this.gnU.bCf().bHj() != null && this.gnU.bCk() != null && bVar != null && this.gnU.bCk().getListView() != null && this.gnU.bCh() != null) {
            BdTypeRecyclerView listView = this.gnU.bCk().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.gnU.bCh().ui(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.gnU.bCh().ui(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
