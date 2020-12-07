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
    private BdTypeMultiColumnListView gLg;
    private e gLh;
    private h gLi;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eNZ = eVar;
        this.gLg = bdTypeMultiColumnListView;
        Nt();
    }

    private void Nt() {
        this.gLh = new e((TbPageContext) this.eNZ, com.baidu.tieba.ala.frsgamelive.b.c.gLq);
        this.gLi = new h((TbPageContext) this.eNZ, com.baidu.tieba.ala.frsgamelive.b.c.gLr);
        this.bnf.add(this.gLh);
        this.bnf.add(this.gLi);
        this.gLg.addAdapters(this.bnf);
    }

    public void setDatas(List<q> list) {
        if (this.gLg != null) {
            this.gLg.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gLh != null) {
            this.gLh.a(fVar);
        }
        if (this.gLi != null) {
            this.gLi.a(fVar);
        }
    }
}
