package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private com.baidu.adp.base.e dJb;
    private BdTypeListView fbb;
    private b hAR;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.dJb = eVar;
        this.fbb = bdTypeListView;
        CY();
    }

    private void CY() {
        this.hAR = new b((TbPageContext) this.dJb, com.baidu.tieba.frs.game.strategy.data.b.hzY);
        this.aSj.add(this.hAR);
        this.fbb.addAdapters(this.aSj);
    }

    public void setData(List<o> list) {
        if (this.fbb != null) {
            this.fbb.setData(list);
        }
    }

    public void b(x xVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar != null) {
                aVar.a(xVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.fbb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }
}
