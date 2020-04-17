package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class m {
    private com.baidu.tieba.frs.mc.l hag;

    public m(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.hag = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hag != null && this.hag.bOs() != null && this.hag.bOs().bTw() != null && this.hag.bOx() != null && bVar != null && this.hag.bOx().getListView() != null && this.hag.bOu() != null) {
            BdTypeRecyclerView listView = this.hag.bOx().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.hag.bOu().uR(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.hag.bOu().uR(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
