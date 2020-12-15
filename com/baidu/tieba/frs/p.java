package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class p {
    private com.baidu.tieba.frs.mc.l iVr;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.iVr = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iVr != null && this.iVr.cCa() != null && this.iVr.cCa().cIF() != null && this.iVr.cCf() != null && bVar != null && this.iVr.cCf().getListView() != null && this.iVr.cCc() != null) {
            BdTypeRecyclerView listView = this.iVr.cCf().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.iVr.cCc().BM(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.iVr.cCc().BM(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
