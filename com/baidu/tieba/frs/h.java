package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class h {
    private com.baidu.tieba.frs.mc.j diX;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.diX = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.diX != null && this.diX.atm() != null && this.diX.atm().axV() != null && this.diX.atr() != null && bVar != null && this.diX.atr().getListView() != null && this.diX.ato() != null) {
            BdTypeRecyclerView listView = this.diX.atr().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.diX.ato().lx(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.diX.ato().lx(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
