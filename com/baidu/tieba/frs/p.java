package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class p {
    private com.baidu.tieba.frs.mc.l iVp;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.iVp = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iVp != null && this.iVp.cBZ() != null && this.iVp.cBZ().cIE() != null && this.iVp.cCe() != null && bVar != null && this.iVp.cCe().getListView() != null && this.iVp.cCb() != null) {
            BdTypeRecyclerView listView = this.iVp.cCe().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.iVp.cCb().BM(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.iVp.cCb().BM(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
