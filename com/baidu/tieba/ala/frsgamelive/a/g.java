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
    private f gLl;
    private c gLm;
    private a gLn;
    private b gLo;
    private BdTypeListView gpZ;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.eNZ = eVar;
        this.gpZ = bdTypeListView;
        mH(z);
    }

    private void mH(boolean z) {
        if (z) {
            this.gLm = new c((TbPageContext) this.eNZ, com.baidu.tieba.ala.gamelist.b.a.gzy);
            this.bnf.add(this.gLm);
        } else {
            this.gLl = new f((TbPageContext) this.eNZ, com.baidu.tieba.ala.gamelist.b.a.gzy);
            this.bnf.add(this.gLl);
        }
        this.gLn = new a((TbPageContext) this.eNZ, com.baidu.tieba.ala.frsgamelive.b.a.gLq);
        this.gLo = new b((TbPageContext) this.eNZ, com.baidu.tieba.ala.frsgamelive.b.b.gLr);
        this.bnf.add(this.gLn);
        this.bnf.add(this.gLo);
        this.gpZ.addAdapters(this.bnf);
    }

    public void setDatas(List<q> list) {
        if (this.gpZ != null) {
            this.gpZ.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gLl != null) {
            this.gLl.a(fVar);
        }
        if (this.gLm != null) {
            this.gLm.a(fVar);
        }
    }
}
