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
    private BdTypeMultiColumnListView fux;
    private e fuy;
    private h fuz;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.dJb = eVar;
        this.fux = bdTypeMultiColumnListView;
        CY();
    }

    private void CY() {
        this.fuy = new e((TbPageContext) this.dJb, com.baidu.tieba.ala.frsgamelive.b.c.fuH);
        this.fuz = new h((TbPageContext) this.dJb, com.baidu.tieba.ala.frsgamelive.b.c.fuI);
        this.aSj.add(this.fuy);
        this.aSj.add(this.fuz);
        this.fux.addAdapters(this.aSj);
    }

    public void setDatas(List<o> list) {
        if (this.fux != null) {
            this.fux.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fuy != null) {
            this.fuy.a(dVar);
        }
        if (this.fuz != null) {
            this.fuz.a(dVar);
        }
    }
}
