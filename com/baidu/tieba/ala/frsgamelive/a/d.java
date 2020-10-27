package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private com.baidu.adp.base.e eCK;
    private BdTypeMultiColumnListView gwO;
    private e gwP;
    private h gwQ;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eCK = eVar;
        this.gwO = bdTypeMultiColumnListView;
        Ly();
    }

    private void Ly() {
        this.gwP = new e((TbPageContext) this.eCK, com.baidu.tieba.ala.frsgamelive.b.c.gwY);
        this.gwQ = new h((TbPageContext) this.eCK, com.baidu.tieba.ala.frsgamelive.b.c.gwZ);
        this.bje.add(this.gwP);
        this.bje.add(this.gwQ);
        this.gwO.addAdapters(this.bje);
    }

    public void setDatas(List<q> list) {
        if (this.gwO != null) {
            this.gwO.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gwP != null) {
            this.gwP.a(fVar);
        }
        if (this.gwQ != null) {
            this.gwQ.a(fVar);
        }
    }
}
