package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.b;
/* loaded from: classes.dex */
public class ay {
    private TbPageContext aaY;
    private com.baidu.tieba.frs.mc.y bQu;

    public ay(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.y yVar) {
        this.aaY = tbPageContext;
        this.bQu = yVar;
    }

    public void b(b bVar) {
        if (this.bQu != null && this.bQu.ZU() != null && this.bQu.ZU().adz() != null && this.bQu.aab() != null && bVar != null && this.bQu.aab().getListView() != null && this.bQu.ZY() != null) {
            BdTypeListView listView = this.bQu.aab().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        if (!this.bQu.aai()) {
                            listView.removeHeaderView(bVar.getView());
                            listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        }
                        this.bQu.ZY().iO(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.bQu.ZY().iO(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
