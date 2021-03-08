package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class p {
    private com.baidu.tieba.frs.mc.l jkA;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.jkA = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jkA != null && this.jkA.cCC() != null && this.jkA.cCC().cJo() != null && this.jkA.cCH() != null && bVar != null && this.jkA.cCH().getListView() != null && this.jkA.cCE() != null) {
            BdTypeRecyclerView listView = this.jkA.cCH().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.jkA.cCE().AD(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.jkA.cCE().AD(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
