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
    private com.baidu.adp.base.e cVC;
    private BdTypeListView eka;
    private b gAC;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.cVC = eVar;
        this.eka = bdTypeListView;
        wM();
    }

    private void wM() {
        this.gAC = new b((TbPageContext) this.cVC, com.baidu.tieba.frs.game.strategy.data.b.gzJ);
        this.asE.add(this.gAC);
        this.eka.addAdapters(this.asE);
    }

    public void setData(List<m> list) {
        if (this.eka != null) {
            this.eka.setData(list);
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
        if (this.eka.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }
}
