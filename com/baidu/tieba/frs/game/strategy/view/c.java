package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private com.baidu.adp.base.e eNZ;
    private BdTypeListView gpX;
    private b jkM;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.eNZ = eVar;
        this.gpX = bdTypeListView;
        Nt();
    }

    private void Nt() {
        this.jkM = new b((TbPageContext) this.eNZ, com.baidu.tieba.frs.game.strategy.data.b.jjU);
        this.bnf.add(this.jkM);
        this.gpX.addAdapters(this.bnf);
    }

    public void setData(List<q> list) {
        if (this.gpX != null) {
            this.gpX.setData(list);
        }
    }

    public void b(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gpX.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }
}
