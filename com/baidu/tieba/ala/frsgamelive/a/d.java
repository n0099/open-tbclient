package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private com.baidu.adp.base.e eGT;
    private BdTypeMultiColumnListView gCj;
    private e gCk;
    private h gCl;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eGT = eVar;
        this.gCj = bdTypeMultiColumnListView;
        Lp();
    }

    private void Lp() {
        this.gCk = new e((TbPageContext) this.eGT, com.baidu.tieba.ala.frsgamelive.b.c.gCt);
        this.gCl = new h((TbPageContext) this.eGT, com.baidu.tieba.ala.frsgamelive.b.c.gCu);
        this.biN.add(this.gCk);
        this.biN.add(this.gCl);
        this.gCj.addAdapters(this.biN);
    }

    public void setDatas(List<q> list) {
        if (this.gCj != null) {
            this.gCj.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gCk != null) {
            this.gCk.a(fVar);
        }
        if (this.gCl != null) {
            this.gCl.a(fVar);
        }
    }
}
