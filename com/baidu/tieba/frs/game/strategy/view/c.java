package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private com.baidu.adp.base.e efK;
    private BdTypeListView fCP;
    private b iih;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.efK = eVar;
        this.fCP = bdTypeListView;
        Jv();
    }

    private void Jv() {
        this.iih = new b((TbPageContext) this.efK, com.baidu.tieba.frs.game.strategy.data.b.ihp);
        this.bbu.add(this.iih);
        this.fCP.addAdapters(this.bbu);
    }

    public void setData(List<q> list) {
        if (this.fCP != null) {
            this.fCP.setData(list);
        }
    }

    public void b(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCP.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }
}
