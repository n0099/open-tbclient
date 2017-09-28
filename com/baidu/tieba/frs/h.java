package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private TbPageContext abz;
    private com.baidu.tieba.frs.mc.j crG;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.abz = tbPageContext;
        this.crG = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.crG != null && this.crG.agP() != null && this.crG.agP().akh() != null && this.crG.agU() != null && bVar != null && this.crG.agU().getListView() != null && this.crG.agR() != null) {
            BdTypeListView listView = this.crG.agU().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.crG.agR().kh(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.crG.agR().kh(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
