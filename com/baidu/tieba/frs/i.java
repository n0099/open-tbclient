package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tieba.frs.mc.j cIw;

    public i(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.cIw = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cIw != null && this.cIw.ali() != null && this.cIw.ali().aoH() != null && this.cIw.aln() != null && bVar != null && this.cIw.aln().getListView() != null && this.cIw.alk() != null) {
            BdTypeListView listView = this.cIw.aln().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cIw.alk().lc(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cIw.alk().lc(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
