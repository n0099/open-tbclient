package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private com.baidu.adp.base.e dvg;
    private BdTypeListView eOj;
    private b hlq;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.dvg = eVar;
        this.eOj = bdTypeListView;
        BB();
    }

    private void BB() {
        this.hlq = new b((TbPageContext) this.dvg, com.baidu.tieba.frs.game.strategy.data.b.hkx);
        this.aMj.add(this.hlq);
        this.eOj.addAdapters(this.aMj);
    }

    public void setData(List<m> list) {
        if (this.eOj != null) {
            this.eOj.setData(list);
        }
    }

    public void b(v vVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar != null) {
                aVar.a(vVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.eOj.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }
}
