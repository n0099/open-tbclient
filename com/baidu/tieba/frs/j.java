package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l fqH;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.fqH = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fqH != null && this.fqH.bjK() != null && this.fqH.bjK().boI() != null && this.fqH.bjP() != null && bVar != null && this.fqH.bjP().getListView() != null && this.fqH.bjM() != null) {
            BdTypeRecyclerView listView = this.fqH.bjP().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.fqH.bjM().sE(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.fqH.bjM().sE(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
