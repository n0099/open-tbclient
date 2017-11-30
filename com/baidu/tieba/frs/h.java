package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private com.baidu.tieba.frs.mc.j cIn;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.cIn = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cIn != null && this.cIn.akZ() != null && this.cIn.akZ().aoz() != null && this.cIn.ale() != null && bVar != null && this.cIn.ale().getListView() != null && this.cIn.alb() != null) {
            BdTypeListView listView = this.cIn.ale().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cIn.alb().la(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cIn.alb().la(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
