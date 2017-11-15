package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private com.baidu.tieba.frs.mc.j czi;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.czi = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.czi != null && this.czi.ajf() != null && this.czi.ajf().amD() != null && this.czi.ajk() != null && bVar != null && this.czi.ajk().getListView() != null && this.czi.ajh() != null) {
            BdTypeListView listView = this.czi.ajk().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.czi.ajh().kC(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.czi.ajh().kC(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
