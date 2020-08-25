package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes16.dex */
public class p {
    private com.baidu.tieba.frs.mc.l hVj;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.hVj = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hVj != null && this.hVj.clN() != null && this.hVj.clN().crs() != null && this.hVj.clS() != null && bVar != null && this.hVj.clS().getListView() != null && this.hVj.clP() != null) {
            BdTypeRecyclerView listView = this.hVj.clS().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.hVj.clP().yP(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.hVj.clP().yP(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
