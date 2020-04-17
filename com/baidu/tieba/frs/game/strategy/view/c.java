package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private com.baidu.adp.base.e dvc;
    private BdTypeListView eOe;
    private b hlk;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.dvc = eVar;
        this.eOe = bdTypeListView;
        BC();
    }

    private void BC() {
        this.hlk = new b((TbPageContext) this.dvc, com.baidu.tieba.frs.game.strategy.data.b.hkr);
        this.aMd.add(this.hlk);
        this.eOe.addAdapters(this.aMd);
    }

    public void setData(List<m> list) {
        if (this.eOe != null) {
            this.eOe.setData(list);
        }
    }

    public void b(v vVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar != null) {
                aVar.a(vVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.eOe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }
}
