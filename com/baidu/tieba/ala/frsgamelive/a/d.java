package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private com.baidu.adp.base.e cRq;
    private BdTypeMultiColumnListView ewa;
    private e ewb;
    private h ewc;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.cRq = eVar;
        this.ewa = bdTypeMultiColumnListView;
        uR();
    }

    private void uR() {
        this.ewb = new e((TbPageContext) this.cRq, com.baidu.tieba.ala.frsgamelive.b.c.ewk);
        this.ewc = new h((TbPageContext) this.cRq, com.baidu.tieba.ala.frsgamelive.b.c.ewl);
        this.aoz.add(this.ewb);
        this.aoz.add(this.ewc);
        this.ewa.addAdapters(this.aoz);
    }

    public void setDatas(List<m> list) {
        if (this.ewa != null) {
            this.ewa.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.ewb != null) {
            this.ewb.a(dVar);
        }
        if (this.ewc != null) {
            this.ewc.a(dVar);
        }
    }
}
