package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private TbPageContext acr;
    private com.baidu.tieba.frs.mc.k ckY;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.k kVar) {
        this.acr = tbPageContext;
        this.ckY = kVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.ckY != null && this.ckY.afk() != null && this.ckY.afk().aig() != null && this.ckY.afp() != null && bVar != null && this.ckY.afp().getListView() != null && this.ckY.afm() != null) {
            BdTypeListView listView = this.ckY.afp().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.ckY.afm().jJ(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.ckY.afm().jJ(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
