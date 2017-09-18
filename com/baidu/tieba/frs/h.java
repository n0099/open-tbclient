package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class h {
    private TbPageContext aby;
    private com.baidu.tieba.frs.mc.k crk;

    public h(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.k kVar) {
        this.aby = tbPageContext;
        this.crk = kVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.crk != null && this.crk.agT() != null && this.crk.agT().akd() != null && this.crk.agY() != null && bVar != null && this.crk.agY().getListView() != null && this.crk.agV() != null) {
            BdTypeListView listView = this.crk.agY().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.crk.agV().jZ(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.crk.agV().jZ(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
