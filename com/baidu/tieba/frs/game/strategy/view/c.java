package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private com.baidu.adp.base.f eTl;
    private BdTypeListView gwr;
    private b jsH;

    public c(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView) {
        this.eTl = fVar;
        this.gwr = bdTypeListView;
        IY();
    }

    private void IY() {
        this.jsH = new b((TbPageContext) this.eTl, com.baidu.tieba.frs.game.strategy.data.b.jrP);
        this.bjZ.add(this.jsH);
        this.gwr.addAdapters(this.bjZ);
    }

    public void setData(List<n> list) {
        if (this.gwr != null) {
            this.gwr.setData(list);
        }
    }

    public void b(w wVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar != null) {
                aVar.a(wVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gwr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }
}
