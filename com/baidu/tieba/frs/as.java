package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.b;
/* loaded from: classes.dex */
public class as {
    private TbPageContext aat;
    private com.baidu.tieba.frs.mc.y bPu;

    public as(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.y yVar) {
        this.aat = tbPageContext;
        this.bPu = yVar;
    }

    public void b(b bVar) {
        if (this.bPu != null && this.bPu.YU() != null && this.bPu.YU().abG() != null && this.bPu.YZ() != null && bVar != null && this.bPu.YZ().getListView() != null && this.bPu.YW() != null) {
            BdTypeListView listView = this.bPu.YZ().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.bPu.YW().iH(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.bPu.YW().iH(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
