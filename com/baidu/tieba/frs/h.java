package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class h {
    private com.baidu.tieba.frs.mc.j cYA;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.cYA = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cYA != null && this.cYA.aph() != null && this.cYA.aph().atJ() != null && this.cYA.apn() != null && bVar != null && this.cYA.apn().getListView() != null && this.cYA.apk() != null) {
            BdTypeRecyclerView listView = this.cYA.apn().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cYA.apk().lr(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cYA.apk().lr(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
