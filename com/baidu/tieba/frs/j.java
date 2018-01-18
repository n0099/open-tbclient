package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dCv;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dCv = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dCv != null && this.dCv.atT() != null && this.dCv.atT().axQ() != null && this.dCv.atY() != null && bVar != null && this.dCv.atY().getListView() != null && this.dCv.atV() != null) {
            BdTypeRecyclerView listView = this.dCv.atY().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dCv.atV().nS(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dCv.atV().nS(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
