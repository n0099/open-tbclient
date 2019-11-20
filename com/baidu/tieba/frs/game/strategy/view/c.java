package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private com.baidu.adp.base.e ceS;
    private BdTypeListView duK;
    private b fGZ;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.ceS = eVar;
        this.duK = bdTypeListView;
        sY();
    }

    private void sY() {
        this.fGZ = new b((TbPageContext) this.ceS, com.baidu.tieba.frs.game.strategy.data.b.fGg);
        this.agy.add(this.fGZ);
        this.duK.addAdapters(this.agy);
    }

    public void setData(List<m> list) {
        if (this.duK != null) {
            this.duK.setData(list);
        }
    }

    public void b(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }
}
