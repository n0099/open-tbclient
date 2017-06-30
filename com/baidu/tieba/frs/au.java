package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.b;
/* loaded from: classes.dex */
public class au {
    private TbPageContext aat;
    private com.baidu.tieba.frs.mc.ab cdt;

    public au(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.ab abVar) {
        this.aat = tbPageContext;
        this.cdt = abVar;
    }

    public void b(b bVar) {
        if (this.cdt != null && this.cdt.adP() != null && this.cdt.adP().agC() != null && this.cdt.adU() != null && bVar != null && this.cdt.adU().getListView() != null && this.cdt.adR() != null) {
            BdTypeListView listView = this.cdt.adU().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.cdt.adR().jq(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.cdt.adR().jq(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
