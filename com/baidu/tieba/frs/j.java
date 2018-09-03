package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class j {
    private com.baidu.tieba.frs.mc.j dnN;

    public j(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.j jVar) {
        this.dnN = jVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dnN != null && this.dnN.aug() != null && this.dnN.aug().azd() != null && this.dnN.aul() != null && bVar != null && this.dnN.aul().getListView() != null && this.dnN.aui() != null) {
            BdTypeRecyclerView listView = this.dnN.aul().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.dnN.aui().lP(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.dnN.aui().lP(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
