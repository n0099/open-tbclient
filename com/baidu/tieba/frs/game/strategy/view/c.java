package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private com.baidu.adp.base.e cfJ;
    private BdTypeListView dvB;
    private b fHQ;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.cfJ = eVar;
        this.dvB = bdTypeListView;
        sX();
    }

    private void sX() {
        this.fHQ = new b((TbPageContext) this.cfJ, com.baidu.tieba.frs.game.strategy.data.b.fGX);
        this.agQ.add(this.fHQ);
        this.dvB.addAdapters(this.agQ);
    }

    public void setData(List<m> list) {
        if (this.dvB != null) {
            this.dvB.setData(list);
        }
    }

    public void b(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }
}
