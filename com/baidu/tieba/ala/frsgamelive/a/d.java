package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private com.baidu.adp.base.e eNZ;
    private BdTypeMultiColumnListView gLi;
    private e gLj;
    private h gLk;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eNZ = eVar;
        this.gLi = bdTypeMultiColumnListView;
        Nt();
    }

    private void Nt() {
        this.gLj = new e((TbPageContext) this.eNZ, com.baidu.tieba.ala.frsgamelive.b.c.gLs);
        this.gLk = new h((TbPageContext) this.eNZ, com.baidu.tieba.ala.frsgamelive.b.c.gLt);
        this.bnf.add(this.gLj);
        this.bnf.add(this.gLk);
        this.gLi.addAdapters(this.bnf);
    }

    public void setDatas(List<q> list) {
        if (this.gLi != null) {
            this.gLi.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gLj != null) {
            this.gLj.a(fVar);
        }
        if (this.gLk != null) {
            this.gLk.a(fVar);
        }
    }
}
