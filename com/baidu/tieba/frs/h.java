package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private TbPageContext abm;
    private com.baidu.tieba.frs.mc.j cru;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.abm = tbPageContext;
        this.cru = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cru != null && this.cru.agK() != null && this.cru.agK().akc() != null && this.cru.agP() != null && bVar != null && this.cru.agP().getListView() != null && this.cru.agM() != null) {
            BdTypeListView listView = this.cru.agP().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cru.agM().kg(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cru.agM().kg(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
