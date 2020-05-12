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
        if (this.ham != null && this.ham.bOr() != null && this.ham.bOr().bTv() != null && this.ham.bOw() != null && bVar != null && this.ham.bOw().getListView() != null && this.ham.bOt() != null) {
            BdTypeRecyclerView listView = this.ham.bOw().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.ham.bOt().uR(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.ham.bOt().uR(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
