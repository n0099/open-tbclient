package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private com.baidu.adp.base.e efO;
    private BdTypeListView fCT;
    private b iin;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.efO = eVar;
        this.fCT = bdTypeListView;
        Jv();
    }

    private void Jv() {
        this.iin = new b((TbPageContext) this.efO, com.baidu.tieba.frs.game.strategy.data.b.ihv);
        this.bbw.add(this.iin);
        this.fCT.addAdapters(this.bbw);
    }

    public void setData(List<q> list) {
        if (this.fCT != null) {
            this.fCT.setData(list);
        }
    }

    public void b(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCT.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }
}
