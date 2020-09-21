package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private com.baidu.adp.base.e eid;
    private BdTypeMultiColumnListView gas;
    private e gat;
    private h gau;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eid = eVar;
        this.gas = bdTypeMultiColumnListView;
        JZ();
    }

    private void JZ() {
        this.gat = new e((TbPageContext) this.eid, com.baidu.tieba.ala.frsgamelive.b.c.gaC);
        this.gau = new h((TbPageContext) this.eid, com.baidu.tieba.ala.frsgamelive.b.c.gaD);
        this.bdV.add(this.gat);
        this.bdV.add(this.gau);
        this.gas.addAdapters(this.bdV);
    }

    public void setDatas(List<q> list) {
        if (this.gas != null) {
            this.gas.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gat != null) {
            this.gat.a(fVar);
        }
        if (this.gau != null) {
            this.gau.a(fVar);
        }
    }
}
