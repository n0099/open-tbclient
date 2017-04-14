package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.b;
/* loaded from: classes.dex */
public class ay {
    private TbPageContext aaX;
    private com.baidu.tieba.frs.mc.y bOd;

    public ay(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.y yVar) {
        this.aaX = tbPageContext;
        this.bOd = yVar;
    }

    public void b(b bVar) {
        if (this.bOd != null && this.bOd.YT() != null && this.bOd.YT().acy() != null && this.bOd.Za() != null && bVar != null && this.bOd.Za().getListView() != null && this.bOd.YX() != null) {
            BdTypeListView listView = this.bOd.Za().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        if (!this.bOd.Zh()) {
                            listView.removeHeaderView(bVar.getView());
                            listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        }
                        this.bOd.YX().iI(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.bOd.YX().iI(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
