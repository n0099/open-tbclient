package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l fxR;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.fxR = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fxR != null && this.fxR.bmE() != null && this.fxR.bmE().brI() != null && this.fxR.bmJ() != null && bVar != null && this.fxR.bmJ().getListView() != null && this.fxR.bmG() != null) {
            BdTypeRecyclerView listView = this.fxR.bmJ().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.fxR.bmG().tc(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.fxR.bmG().tc(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
