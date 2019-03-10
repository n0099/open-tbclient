package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l faF;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.faF = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.faF != null && this.faF.bcq() != null && this.faF.bcq().bhp() != null && this.faF.bcv() != null && bVar != null && this.faF.bcv().getListView() != null && this.faF.bcs() != null) {
            BdTypeRecyclerView listView = this.faF.bcv().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.faF.bcs().rA(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.faF.bcs().rA(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
