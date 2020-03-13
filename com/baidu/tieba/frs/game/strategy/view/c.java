package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private com.baidu.adp.base.e cVE;
    private BdTypeListView eko;
    private b gAQ;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.cVE = eVar;
        this.eko = bdTypeListView;
        wM();
    }

    private void wM() {
        this.gAQ = new b((TbPageContext) this.cVE, com.baidu.tieba.frs.game.strategy.data.b.gzX);
        this.asF.add(this.gAQ);
        this.eko.addAdapters(this.asF);
    }

    public void setData(List<m> list) {
        if (this.eko != null) {
            this.eko.setData(list);
        }
    }

    public void b(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.eko.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }
}
