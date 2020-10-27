package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private com.baidu.adp.base.e eCK;
    private BdTypeListView gcr;
    private b iQE;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.eCK = eVar;
        this.gcr = bdTypeListView;
        Ly();
    }

    private void Ly() {
        this.iQE = new b((TbPageContext) this.eCK, com.baidu.tieba.frs.game.strategy.data.b.iPM);
        this.bje.add(this.iQE);
        this.gcr.addAdapters(this.bje);
    }

    public void setData(List<q> list) {
        if (this.gcr != null) {
            this.gcr.setData(list);
        }
    }

    public void b(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gcr.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }
}
