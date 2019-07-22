package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l fvF;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.fvF = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fvF != null && this.fvF.blM() != null && this.fvF.blM().bqK() != null && this.fvF.blR() != null && bVar != null && this.fvF.blR().getListView() != null && this.fvF.blO() != null) {
            BdTypeRecyclerView listView = this.fvF.blR().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.fvF.blO().sW(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.fvF.blO().sW(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
