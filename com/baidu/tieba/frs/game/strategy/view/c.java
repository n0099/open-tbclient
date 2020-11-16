package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private com.baidu.adp.base.e eGT;
    private BdTypeListView ghN;
    private b iXn;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.eGT = eVar;
        this.ghN = bdTypeListView;
        Lp();
    }

    private void Lp() {
        this.iXn = new b((TbPageContext) this.eGT, com.baidu.tieba.frs.game.strategy.data.b.iWv);
        this.biN.add(this.iXn);
        this.ghN.addAdapters(this.biN);
    }

    public void setData(List<q> list) {
        if (this.ghN != null) {
            this.ghN.setData(list);
        }
    }

    public void b(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.ghN.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }
}
