package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private com.baidu.adp.base.e dJb;
    private BdTypeMultiColumnListView fum;
    private e fun;
    private h fuo;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.dJb = eVar;
        this.fum = bdTypeMultiColumnListView;
        CY();
    }

    private void CY() {
        this.fun = new e((TbPageContext) this.dJb, com.baidu.tieba.ala.frsgamelive.b.c.fuw);
        this.fuo = new h((TbPageContext) this.dJb, com.baidu.tieba.ala.frsgamelive.b.c.fux);
        this.aSj.add(this.fun);
        this.aSj.add(this.fuo);
        this.fum.addAdapters(this.aSj);
    }

    public void setDatas(List<o> list) {
        if (this.fum != null) {
            this.fum.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fun != null) {
            this.fun.a(dVar);
        }
        if (this.fuo != null) {
            this.fuo.a(dVar);
        }
    }
}
