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
    private BdTypeListView gzb;
    private b jyn;

    public c(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView) {
        this.eVB = fVar;
        this.gzb = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.jyn = new b((TbPageContext) this.eVB, com.baidu.tieba.frs.game.strategy.data.b.jxv);
        this.bns.add(this.jyn);
        this.gzb.addAdapters(this.bns);
    }

    public void setData(List<n> list) {
        if (this.gzb != null) {
            this.gzb.setData(list);
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
        if (this.gzb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }
}
