package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes16.dex */
public class o {
    private com.baidu.tieba.frs.mc.l hHT;

    public o(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.hHT = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hHT != null && this.hHT.cbr() != null && this.hHT.cbr().cgN() != null && this.hHT.cbw() != null && bVar != null && this.hHT.cbw().getListView() != null && this.hHT.cbt() != null) {
            BdTypeRecyclerView listView = this.hHT.cbw().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.hHT.cbt().ww(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.hHT.cbt().ww(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
