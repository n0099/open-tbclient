package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private com.baidu.adp.base.e dJb;
    private BdTypeListView faQ;
    private f fup;
    private c fuq;
    private a fur;
    private b fus;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.dJb = eVar;
        this.faQ = bdTypeListView;
        jS(z);
    }

    private void jS(boolean z) {
        if (z) {
            this.fuq = new c((TbPageContext) this.dJb, com.baidu.tieba.ala.gamelist.b.a.fki);
            this.aSj.add(this.fuq);
        } else {
            this.fup = new f((TbPageContext) this.dJb, com.baidu.tieba.ala.gamelist.b.a.fki);
            this.aSj.add(this.fup);
        }
        this.fur = new a((TbPageContext) this.dJb, com.baidu.tieba.ala.frsgamelive.b.a.fuu);
        this.fus = new b((TbPageContext) this.dJb, com.baidu.tieba.ala.frsgamelive.b.b.fuv);
        this.aSj.add(this.fur);
        this.aSj.add(this.fus);
        this.faQ.addAdapters(this.aSj);
    }

    public void setDatas(List<o> list) {
        if (this.faQ != null) {
            this.faQ.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fup != null) {
            this.fup.a(dVar);
        }
        if (this.fuq != null) {
            this.fuq.a(dVar);
        }
    }
}
