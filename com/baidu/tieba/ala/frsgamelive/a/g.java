package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private com.baidu.adp.base.e eNZ;
    private f gLj;
    private c gLk;
    private a gLl;
    private b gLm;
    private BdTypeListView gpX;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.eNZ = eVar;
        this.gpX = bdTypeListView;
        mH(z);
    }

    private void mH(boolean z) {
        if (z) {
            this.gLk = new c((TbPageContext) this.eNZ, com.baidu.tieba.ala.gamelist.b.a.gzw);
            this.bnf.add(this.gLk);
        } else {
            this.gLj = new f((TbPageContext) this.eNZ, com.baidu.tieba.ala.gamelist.b.a.gzw);
            this.bnf.add(this.gLj);
        }
        this.gLl = new a((TbPageContext) this.eNZ, com.baidu.tieba.ala.frsgamelive.b.a.gLo);
        this.gLm = new b((TbPageContext) this.eNZ, com.baidu.tieba.ala.frsgamelive.b.b.gLp);
        this.bnf.add(this.gLl);
        this.bnf.add(this.gLm);
        this.gpX.addAdapters(this.bnf);
    }

    public void setDatas(List<q> list) {
        if (this.gpX != null) {
            this.gpX.setData(list);
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
