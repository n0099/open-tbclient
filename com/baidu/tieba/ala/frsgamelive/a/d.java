package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private com.baidu.adp.base.e cVE;
    private BdTypeMultiColumnListView eBJ;
    private e eBK;
    private h eBL;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.cVE = eVar;
        this.eBJ = bdTypeMultiColumnListView;
        wM();
    }

    private void wM() {
        this.eBK = new e((TbPageContext) this.cVE, com.baidu.tieba.ala.frsgamelive.b.c.eBT);
        this.eBL = new h((TbPageContext) this.cVE, com.baidu.tieba.ala.frsgamelive.b.c.eBU);
        this.asF.add(this.eBK);
        this.asF.add(this.eBL);
        this.eBJ.addAdapters(this.asF);
    }

    public void setDatas(List<m> list) {
        if (this.eBJ != null) {
            this.eBJ.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.eBK != null) {
            this.eBK.a(dVar);
        }
        if (this.eBL != null) {
            this.eBL.a(dVar);
        }
    }
}
