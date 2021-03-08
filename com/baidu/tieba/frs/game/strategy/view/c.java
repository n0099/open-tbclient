package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private com.baidu.adp.base.f eXa;
    private BdTypeListView gAY;
    private b jAk;

    public c(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView) {
        this.eXa = fVar;
        this.gAY = bdTypeListView;
        Kz();
    }

    private void Kz() {
        this.jAk = new b((TbPageContext) this.eXa, com.baidu.tieba.frs.game.strategy.data.b.jzs);
        this.boS.add(this.jAk);
        this.gAY.addAdapters(this.boS);
    }

    public void setData(List<n> list) {
        if (this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public void b(w wVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar != null) {
                aVar.a(wVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}
