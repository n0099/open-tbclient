package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l fwe;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.fwe = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fwe != null && this.fwe.blT() != null && this.fwe.blT().bqX() != null && this.fwe.blY() != null && bVar != null && this.fwe.blY().getListView() != null && this.fwe.blV() != null) {
            BdTypeRecyclerView listView = this.fwe.blY().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.fwe.blV().sY(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.fwe.blV().sY(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
