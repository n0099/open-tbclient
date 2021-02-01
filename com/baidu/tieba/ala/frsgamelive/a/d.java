package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private com.baidu.adp.base.f eVB;
    private BdTypeMultiColumnListView gUY;
    private e gUZ;
    private h gVa;

    public d(com.baidu.adp.base.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eVB = fVar;
        this.gUY = bdTypeMultiColumnListView;
        Kw();
    }

    private void Kw() {
        this.gUZ = new e((TbPageContext) this.eVB, com.baidu.tieba.ala.frsgamelive.b.c.gVi);
        this.gVa = new h((TbPageContext) this.eVB, com.baidu.tieba.ala.frsgamelive.b.c.gVj);
        this.bns.add(this.gUZ);
        this.bns.add(this.gVa);
        this.gUY.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
        if (this.gUY != null) {
            this.gUY.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.h hVar) {
        if (this.gUZ != null) {
            this.gUZ.a(hVar);
        }
        if (this.gVa != null) {
            this.gVa.a(hVar);
        }
    }
}
