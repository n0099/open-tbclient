package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class k {
    private com.baidu.tieba.frs.mc.l gpX;

    public k(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.gpX = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gpX != null && this.gpX.bDK() != null && this.gpX.bDK().bIM() != null && this.gpX.bDP() != null && bVar != null && this.gpX.bDP().getListView() != null && this.gpX.bDM() != null) {
            BdTypeRecyclerView listView = this.gpX.bDP().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.gpX.bDM().uo(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.gpX.bDM().uo(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
