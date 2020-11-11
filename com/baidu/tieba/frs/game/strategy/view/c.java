package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private com.baidu.adp.base.e eIz;
    private BdTypeListView gih;
    private b iWB;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.eIz = eVar;
        this.gih = bdTypeListView;
        LY();
    }

    private void LY() {
        this.iWB = new b((TbPageContext) this.eIz, com.baidu.tieba.frs.game.strategy.data.b.iVJ);
        this.bky.add(this.iWB);
        this.gih.addAdapters(this.bky);
    }

    public void setData(List<q> list) {
        if (this.gih != null) {
            this.gih.setData(list);
        }
    }

    public void b(ab abVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar != null) {
                aVar.a(abVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gih.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }
}
