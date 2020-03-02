package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private com.baidu.adp.base.e cVD;
    private BdTypeListView ekb;
    private b gAE;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.cVD = eVar;
        this.ekb = bdTypeListView;
        wM();
    }

    private void wM() {
        this.gAE = new b((TbPageContext) this.cVD, com.baidu.tieba.frs.game.strategy.data.b.gzL);
        this.asE.add(this.gAE);
        this.ekb.addAdapters(this.asE);
    }

    public void setData(List<m> list) {
        if (this.ekb != null) {
            this.ekb.setData(list);
        }
    }

    public void b(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.ekb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }
}
