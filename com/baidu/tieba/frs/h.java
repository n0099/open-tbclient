package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private TbPageContext acr;
    private com.baidu.tieba.frs.mc.k ckX;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.k kVar) {
        this.acr = tbPageContext;
        this.ckX = kVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.ckX != null && this.ckX.afq() != null && this.ckX.afq().aim() != null && this.ckX.afv() != null && bVar != null && this.ckX.afv().getListView() != null && this.ckX.afs() != null) {
            BdTypeListView listView = this.ckX.afv().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.ckX.afs().jJ(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.ckX.afs().jJ(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
