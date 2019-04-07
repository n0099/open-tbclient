package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l far;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.far = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.far != null && this.far.bcn() != null && this.far.bcn().bhm() != null && this.far.bcs() != null && bVar != null && this.far.bcs().getListView() != null && this.far.bcp() != null) {
            BdTypeRecyclerView listView = this.far.bcs().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.far.bcp().rw(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.far.bcp().rw(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
