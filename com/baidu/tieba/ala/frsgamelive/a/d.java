package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private com.baidu.adp.base.e efK;
    private BdTypeMultiColumnListView fXa;
    private e fXb;
    private h fXc;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.efK = eVar;
        this.fXa = bdTypeMultiColumnListView;
        Jv();
    }

    private void Jv() {
        this.fXb = new e((TbPageContext) this.efK, com.baidu.tieba.ala.frsgamelive.b.c.fXk);
        this.fXc = new h((TbPageContext) this.efK, com.baidu.tieba.ala.frsgamelive.b.c.fXl);
        this.bbu.add(this.fXb);
        this.bbu.add(this.fXc);
        this.fXa.addAdapters(this.bbu);
    }

    public void setDatas(List<q> list) {
        if (this.fXa != null) {
            this.fXa.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.e eVar) {
        if (this.fXb != null) {
            this.fXb.a(eVar);
        }
        if (this.fXc != null) {
            this.fXc.a(eVar);
        }
    }
}
