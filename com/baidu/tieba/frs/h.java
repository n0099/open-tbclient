package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private TbPageContext acp;
    private com.baidu.tieba.frs.mc.k ckl;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.k kVar) {
        this.acp = tbPageContext;
        this.ckl = kVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.ckl != null && this.ckl.aeU() != null && this.ckl.aeU().ahS() != null && this.ckl.aeZ() != null && bVar != null && this.ckl.aeZ().getListView() != null && this.ckl.aeW() != null) {
            BdTypeListView listView = this.ckl.aeZ().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.ckl.aeW().jz(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.ckl.aeW().jz(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
