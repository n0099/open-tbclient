package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class h {
    private com.baidu.tieba.frs.mc.j cYD;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.cYD = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cYD != null && this.cYD.aph() != null && this.cYD.aph().atJ() != null && this.cYD.apn() != null && bVar != null && this.cYD.apn().getListView() != null && this.cYD.apk() != null) {
            BdTypeRecyclerView listView = this.cYD.apn().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cYD.apk().lr(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cYD.apk().lr(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
