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
    private BdTypeListView fbb;
    private f fuA;
    private c fuB;
    private a fuC;
    private b fuD;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.dJb = eVar;
        this.fbb = bdTypeListView;
        jS(z);
    }

    private void jS(boolean z) {
        if (z) {
            this.fuB = new c((TbPageContext) this.dJb, com.baidu.tieba.ala.gamelist.b.a.fkt);
            this.aSj.add(this.fuB);
        } else {
            this.fuA = new f((TbPageContext) this.dJb, com.baidu.tieba.ala.gamelist.b.a.fkt);
            this.aSj.add(this.fuA);
        }
        this.fuC = new a((TbPageContext) this.dJb, com.baidu.tieba.ala.frsgamelive.b.a.fuF);
        this.fuD = new b((TbPageContext) this.dJb, com.baidu.tieba.ala.frsgamelive.b.b.fuG);
        this.aSj.add(this.fuC);
        this.aSj.add(this.fuD);
        this.fbb.addAdapters(this.aSj);
    }

    public void setDatas(List<o> list) {
        if (this.fbb != null) {
            this.fbb.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fuA != null) {
            this.fuA.a(dVar);
        }
        if (this.fuB != null) {
            this.fuB.a(dVar);
        }
    }
}
