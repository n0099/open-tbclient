package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private com.baidu.adp.base.e cVR;
    private BdTypeListView ekE;
    private b gBO;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.cVR = eVar;
        this.ekE = bdTypeListView;
        wR();
    }

    private void wR() {
        this.gBO = new b((TbPageContext) this.cVR, com.baidu.tieba.frs.game.strategy.data.b.gAV);
        this.asP.add(this.gBO);
        this.ekE.addAdapters(this.asP);
    }

    public void setData(List<m> list) {
        if (this.ekE != null) {
            this.ekE.setData(list);
        }
    }

    public void b(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.ekE.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }
}
