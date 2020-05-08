package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class m {
    private com.baidu.tieba.frs.mc.l ham;

    public m(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.ham = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.ham != null && this.ham.bOq() != null && this.ham.bOq().bTu() != null && this.ham.bOv() != null && bVar != null && this.ham.bOv().getListView() != null && this.ham.bOs() != null) {
            BdTypeRecyclerView listView = this.ham.bOv().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.ham.bOs().uR(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.ham.bOs().uR(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
