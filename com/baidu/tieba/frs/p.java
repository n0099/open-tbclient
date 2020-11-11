package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class p {
    private com.baidu.tieba.frs.mc.l iJJ;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.iJJ = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iJJ != null && this.iJJ.cyg() != null && this.iJJ.cyg().cDN() != null && this.iJJ.cyl() != null && bVar != null && this.iJJ.cyl().getListView() != null && this.iJJ.cyi() != null) {
            BdTypeRecyclerView listView = this.iJJ.cyl().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.iJJ.cyi().AA(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.iJJ.cyi().AA(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
