package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private com.baidu.adp.base.e dvg;
    private BdTypeMultiColumnListView fgD;
    private e fgE;
    private h fgF;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.dvg = eVar;
        this.fgD = bdTypeMultiColumnListView;
        BB();
    }

    private void BB() {
        this.fgE = new e((TbPageContext) this.dvg, com.baidu.tieba.ala.frsgamelive.b.c.fgN);
        this.fgF = new h((TbPageContext) this.dvg, com.baidu.tieba.ala.frsgamelive.b.c.fgO);
        this.aMj.add(this.fgE);
        this.aMj.add(this.fgF);
        this.fgD.addAdapters(this.aMj);
    }

    public void setDatas(List<m> list) {
        if (this.fgD != null) {
            this.fgD.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fgE != null) {
            this.fgE.a(dVar);
        }
        if (this.fgF != null) {
            this.fgF.a(dVar);
        }
    }
}
