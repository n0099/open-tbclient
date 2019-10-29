package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l fxf;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.fxf = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fxf != null && this.fxf.bjK() != null && this.fxf.bjK().boM() != null && this.fxf.bjP() != null && bVar != null && this.fxf.bjP().getListView() != null && this.fxf.bjM() != null) {
            BdTypeRecyclerView listView = this.fxf.bjP().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.fxf.bjM().rW(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.fxf.bjM().rW(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
