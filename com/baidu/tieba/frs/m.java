package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class m {
    private com.baidu.tieba.frs.mc.l hpa;

    public m(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.hpa = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hpa != null && this.hpa.bUM() != null && this.hpa.bUM().bZR() != null && this.hpa.bUR() != null && bVar != null && this.hpa.bUR().getListView() != null && this.hpa.bUO() != null) {
            BdTypeRecyclerView listView = this.hpa.bUR().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.hpa.bUO().vx(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.hpa.bUO().vx(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
