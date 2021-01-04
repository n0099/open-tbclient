package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private com.baidu.adp.base.f eXW;
    private BdTypeListView gAY;
    private b jxn;

    public c(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView) {
        this.eXW = fVar;
        this.gAY = bdTypeListView;
        MT();
    }

    private void MT() {
        this.jxn = new b((TbPageContext) this.eXW, com.baidu.tieba.frs.game.strategy.data.b.jwv);
        this.boM.add(this.jxn);
        this.gAY.addAdapters(this.boM);
    }

    public void setData(List<n> list) {
        if (this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public void b(w wVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar != null) {
                aVar.a(wVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}
