package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private com.baidu.adp.base.e dPR;
    private BdTypeListView fml;
    private b hNZ;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.dPR = eVar;
        this.fml = bdTypeListView;
        Dz();
    }

    private void Dz() {
        this.hNZ = new b((TbPageContext) this.dPR, com.baidu.tieba.frs.game.strategy.data.b.hNg);
        this.aUP.add(this.hNZ);
        this.fml.addAdapters(this.aUP);
    }

    public void setData(List<q> list) {
        if (this.fml != null) {
            this.fml.setData(list);
        }
    }

    public void b(z zVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar != null) {
                aVar.a(zVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.fml.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }
}
