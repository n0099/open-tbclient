package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class p {
    private com.baidu.tieba.frs.mc.l irq;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.irq = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.irq != null && this.irq.csy() != null && this.irq.csy().cyf() != null && this.irq.csD() != null && bVar != null && this.irq.csD().getListView() != null && this.irq.csA() != null) {
            BdTypeRecyclerView listView = this.irq.csD().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.irq.csA().zU(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.irq.csA().zU(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
