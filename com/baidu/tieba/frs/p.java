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
        if (this.jhD != null && this.jhD.cEU() != null && this.jhD.cEU().cLF() != null && this.jhD.cEZ() != null && bVar != null && this.jhD.cEZ().getListView() != null && this.jhD.cEW() != null) {
            BdTypeRecyclerView listView = this.jhD.cEZ().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.jhD.cEW().BY(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.jhD.cEW().BY(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
