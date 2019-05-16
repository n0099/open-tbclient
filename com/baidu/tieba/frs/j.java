package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class j {
    private com.baidu.tieba.frs.mc.l fqG;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.fqG = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fqG != null && this.fqG.bjH() != null && this.fqG.bjH().boF() != null && this.fqG.bjM() != null && bVar != null && this.fqG.bjM().getListView() != null && this.fqG.bjJ() != null) {
            BdTypeRecyclerView listView = this.fqG.bjM().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.fqG.bjJ().sE(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.fqG.bjJ().sE(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
