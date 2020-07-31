package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private com.baidu.adp.base.e dWk;
    private BdTypeMultiColumnListView fLc;
    private e fLd;
    private h fLe;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.dWk = eVar;
        this.fLc = bdTypeMultiColumnListView;
        DS();
    }

    private void DS() {
        this.fLd = new e((TbPageContext) this.dWk, com.baidu.tieba.ala.frsgamelive.b.c.fLm);
        this.fLe = new h((TbPageContext) this.dWk, com.baidu.tieba.ala.frsgamelive.b.c.fLn);
        this.aWf.add(this.fLd);
        this.aWf.add(this.fLe);
        this.fLc.addAdapters(this.aWf);
    }

    public void setDatas(List<q> list) {
        if (this.fLc != null) {
            this.fLc.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.e eVar) {
        if (this.fLd != null) {
            this.fLd.a(eVar);
        }
        if (this.fLe != null) {
            this.fLe.a(eVar);
        }
    }
}
