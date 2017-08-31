package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private TbPageContext aby;
    private com.baidu.tieba.frs.mc.k cqr;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.k kVar) {
        this.aby = tbPageContext;
        this.cqr = kVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cqr != null && this.cqr.agI() != null && this.cqr.agI().ajS() != null && this.cqr.agN() != null && bVar != null && this.cqr.agN().getListView() != null && this.cqr.agK() != null) {
            BdTypeListView listView = this.cqr.agN().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cqr.agK().jX(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cqr.agK().jX(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
