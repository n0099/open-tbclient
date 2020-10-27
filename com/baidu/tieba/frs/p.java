package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes22.dex */
public class p {
    private com.baidu.tieba.frs.mc.l iDM;

    public p(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.l lVar) {
        this.iDM = lVar;
    }

    public void b(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iDM != null && this.iDM.cvF() != null && this.iDM.cvF().cBm() != null && this.iDM.cvK() != null && bVar != null && this.iDM.cvK().getListView() != null && this.iDM.cvH() != null) {
            BdTypeRecyclerView listView = this.iDM.cvK().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.iDM.cvH().An(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.iDM.cvH().An(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
