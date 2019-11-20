package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l fwo;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.fwo = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fwo != null && this.fwo.bjI() != null && this.fwo.bjI().boK() != null && this.fwo.bjN() != null && bVar != null && this.fwo.bjN().getListView() != null && this.fwo.bjK() != null) {
            BdTypeRecyclerView listView = this.fwo.bjN().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.fwo.bjK().rV(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.fwo.bjK().rV(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
