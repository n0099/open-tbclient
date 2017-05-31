package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.b;
/* loaded from: classes.dex */
public class at {
    private TbPageContext aas;
    private com.baidu.tieba.frs.mc.y bVk;

    public at(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.y yVar) {
        this.aas = tbPageContext;
        this.bVk = yVar;
    }

    public void b(b bVar) {
        if (this.bVk != null && this.bVk.ZY() != null && this.bVk.ZY().acK() != null && this.bVk.aad() != null && bVar != null && this.bVk.aad().getListView() != null && this.bVk.aaa() != null) {
            BdTypeListView listView = this.bVk.aad().getListView();
            switch (bVar.what) {
                case 2:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        listView.addHeaderView(bVar.getView(), listView.getHeaderViewsCount() - 1);
                        this.bVk.aaa().jf(8);
                        return;
                    }
                    return;
                case 3:
                    if (bVar.getView() != null) {
                        listView.removeHeaderView(bVar.getView());
                        this.bVk.aaa().jf(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
