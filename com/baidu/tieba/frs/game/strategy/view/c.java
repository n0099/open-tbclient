package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private com.baidu.adp.base.e dWk;
    private BdTypeListView frv;
    private b hUa;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.dWk = eVar;
        this.frv = bdTypeListView;
        DS();
    }

    private void DS() {
        this.hUa = new b((TbPageContext) this.dWk, com.baidu.tieba.frs.game.strategy.data.b.hTh);
        this.aWf.add(this.hUa);
        this.frv.addAdapters(this.aWf);
    }

    public void setData(List<q> list) {
        if (this.frv != null) {
            this.frv.setData(list);
        }
    }

    public void b(z zVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar != null) {
                aVar.a(zVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.frv.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }
}
