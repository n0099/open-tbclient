package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private com.baidu.tieba.frs.mc.j cyP;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.cyP = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cyP != null && this.cyP.aiR() != null && this.cyP.aiR().amp() != null && this.cyP.aiW() != null && bVar != null && this.cyP.aiW().getListView() != null && this.cyP.aiT() != null) {
            BdTypeListView listView = this.cyP.aiW().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cyP.aiT().kC(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cyP.aiT().kC(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
