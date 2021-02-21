package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private com.baidu.adp.base.f eVB;
    private BdTypeListView gzp;
    private b jyB;

    public c(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView) {
        this.eVB = fVar;
        this.gzp = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.jyB = new b((TbPageContext) this.eVB, com.baidu.tieba.frs.game.strategy.data.b.jxJ);
        this.bns.add(this.jyB);
        this.gzp.addAdapters(this.bns);
    }

    public void setData(List<n> list) {
        if (this.gzp != null) {
            this.gzp.setData(list);
        }
    }

    public void b(w wVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar != null) {
                aVar.a(wVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzp.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }
}
