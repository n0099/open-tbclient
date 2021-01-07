package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class p {
    private com.baidu.tieba.frs.mc.l jhD;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.jhD = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jhD != null && this.jhD.cEV() != null && this.jhD.cEV().cLG() != null && this.jhD.cFa() != null && bVar != null && this.jhD.cFa().getListView() != null && this.jhD.cEX() != null) {
            BdTypeRecyclerView listView = this.jhD.cFa().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.jhD.cEX().BY(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.jhD.cEX().BY(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
