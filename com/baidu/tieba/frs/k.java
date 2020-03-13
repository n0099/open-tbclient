package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class k {
    private com.baidu.tieba.frs.mc.l gqk;

    public k(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.gqk = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gqk != null && this.gqk.bDL() != null && this.gqk.bDL().bIN() != null && this.gqk.bDQ() != null && bVar != null && this.gqk.bDQ().getListView() != null && this.gqk.bDN() != null) {
            BdTypeRecyclerView listView = this.gqk.bDQ().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.gqk.bDN().uo(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.gqk.bDN().uo(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
