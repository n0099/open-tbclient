package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l faE;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.faE = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.faE != null && this.faE.bcp() != null && this.faE.bcp().bho() != null && this.faE.bcu() != null && bVar != null && this.faE.bcu().getListView() != null && this.faE.bcr() != null) {
            BdTypeRecyclerView listView = this.faE.bcu().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.faE.bcr().rA(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.faE.bcr().rA(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
