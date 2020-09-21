package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private com.baidu.adp.base.e eid;
    private BdTypeListView fGf;
    private b ipp;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.eid = eVar;
        this.fGf = bdTypeListView;
        JZ();
    }

    private void JZ() {
        this.ipp = new b((TbPageContext) this.eid, com.baidu.tieba.frs.game.strategy.data.b.iox);
        this.bdV.add(this.ipp);
        this.fGf.addAdapters(this.bdV);
    }

    public void setData(List<q> list) {
        if (this.fGf != null) {
            this.fGf.setData(list);
        }
    }

    public void b(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.fGf.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }
}
