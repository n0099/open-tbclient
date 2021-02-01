package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class p {
    private com.baidu.tieba.frs.mc.l jiD;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.jiD = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jiD != null && this.jiD.cCp() != null && this.jiD.cCp().cJb() != null && this.jiD.cCu() != null && bVar != null && this.jiD.cCu().getListView() != null && this.jiD.cCr() != null) {
            BdTypeRecyclerView listView = this.jiD.cCu().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.jiD.cCr().AC(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.jiD.cCr().AC(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
