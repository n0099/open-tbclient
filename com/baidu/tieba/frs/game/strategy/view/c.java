package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private com.baidu.adp.base.e cRq;
    private BdTypeListView efM;
    private b gvs;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.cRq = eVar;
        this.efM = bdTypeListView;
        uR();
    }

    private void uR() {
        this.gvs = new b((TbPageContext) this.cRq, com.baidu.tieba.frs.game.strategy.data.b.guz);
        this.aoz.add(this.gvs);
        this.efM.addAdapters(this.aoz);
    }

    public void setData(List<m> list) {
        if (this.efM != null) {
            this.efM.setData(list);
        }
    }

    public void b(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.efM.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }
}
