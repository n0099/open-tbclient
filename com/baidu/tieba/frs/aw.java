package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a;
/* loaded from: classes.dex */
public class aw {
    private TbPageContext aaI;
    private com.baidu.tieba.frs.mc.w bOo;

    public aw(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.w wVar) {
        this.aaI = tbPageContext;
        this.bOo = wVar;
    }

    public void b(a aVar) {
        if (this.bOo != null && this.bOo.Yx() != null && this.bOo.Yx().acc() != null && this.bOo.YE() != null && aVar != null && this.bOo.YE().getListView() != null && this.bOo.YB() != null) {
            BdTypeListView listView = this.bOo.YE().getListView();
            switch (aVar.what) {
                case 2:
                    if (aVar.getView() != null) {
                        if (!this.bOo.YL()) {
                            listView.removeHeaderView(aVar.getView());
                            listView.addHeaderView(aVar.getView(), listView.getHeaderViewsCount() - 1);
                        }
                        this.bOo.YB().iH(8);
                        return;
                    }
                    return;
                case 3:
                    if (aVar.getView() != null) {
                        listView.removeHeaderView(aVar.getView());
                        this.bOo.YB().iH(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
