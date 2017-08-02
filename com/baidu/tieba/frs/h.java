package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private TbPageContext aaS;
    private com.baidu.tieba.frs.mc.k cje;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.k kVar) {
        this.aaS = tbPageContext;
        this.cje = kVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.cje != null && this.cje.aeP() != null && this.cje.aeP().ahK() != null && this.cje.aeU() != null && bVar != null && this.cje.aeU().getListView() != null && this.cje.aeR() != null) {
            BdTypeListView listView = this.cje.aeU().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cje.aeR().jz(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cje.aeR().jz(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
