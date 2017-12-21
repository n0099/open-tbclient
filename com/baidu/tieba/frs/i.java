package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tieba.frs.mc.j cIA;

    public i(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.cIA = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cIA != null && this.cIA.ali() != null && this.cIA.ali().aoI() != null && this.cIA.aln() != null && bVar != null && this.cIA.aln().getListView() != null && this.cIA.alk() != null) {
            BdTypeListView listView = this.cIA.aln().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cIA.alk().lc(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cIA.alk().lc(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
