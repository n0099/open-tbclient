package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private com.baidu.adp.base.e eul;
    private BdTypeListView fSo;
    private b iEi;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.eul = eVar;
        this.fSo = bdTypeListView;
        Le();
    }

    private void Le() {
        this.iEi = new b((TbPageContext) this.eul, com.baidu.tieba.frs.game.strategy.data.b.iDq);
        this.bhH.add(this.iEi);
        this.fSo.addAdapters(this.bhH);
    }

    public void setData(List<q> list) {
        if (this.fSo != null) {
            this.fSo.setData(list);
        }
    }

    public void b(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.fSo.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }
}
