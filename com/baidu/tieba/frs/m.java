package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class m {
    private com.baidu.tieba.frs.mc.l hpl;

    public m(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.hpl = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hpl != null && this.hpl.bUO() != null && this.hpl.bUO().bZZ() != null && this.hpl.bUT() != null && bVar != null && this.hpl.bUT().getListView() != null && this.hpl.bUQ() != null) {
            BdTypeRecyclerView listView = this.hpl.bUT().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.hpl.bUQ().vz(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.hpl.bUQ().vz(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
