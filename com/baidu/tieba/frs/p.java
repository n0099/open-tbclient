package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class p {
    private com.baidu.tieba.frs.mc.l jiR;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.jiR = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jiR != null && this.jiR.cCw() != null && this.jiR.cCw().cJi() != null && this.jiR.cCB() != null && bVar != null && this.jiR.cCB().getListView() != null && this.jiR.cCy() != null) {
            BdTypeRecyclerView listView = this.jiR.cCB().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.jiR.cCy().AC(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.jiR.cCy().AC(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
