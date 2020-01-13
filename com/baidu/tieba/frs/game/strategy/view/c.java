package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private com.baidu.adp.base.e cRA;
    private BdTypeListView efW;
    private b gyC;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.cRA = eVar;
        this.efW = bdTypeListView;
        vi();
    }

    private void vi() {
        this.gyC = new b((TbPageContext) this.cRA, com.baidu.tieba.frs.game.strategy.data.b.gxJ);
        this.apl.add(this.gyC);
        this.efW.addAdapters(this.apl);
    }

    public void setData(List<m> list) {
        if (this.efW != null) {
            this.efW.setData(list);
        }
    }

    public void b(s sVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar != null) {
                aVar.a(sVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }
}
