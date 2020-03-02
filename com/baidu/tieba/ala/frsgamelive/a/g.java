package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private com.baidu.adp.base.e cVD;
    private c eBA;
    private a eBB;
    private b eBC;
    private f eBz;
    private BdTypeListView ekb;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.cVD = eVar;
        this.ekb = bdTypeListView;
        iw(z);
    }

    private void iw(boolean z) {
        if (z) {
            this.eBA = new c((TbPageContext) this.cVD, com.baidu.tieba.ala.gamelist.b.a.etp);
            this.asE.add(this.eBA);
        } else {
            this.eBz = new f((TbPageContext) this.cVD, com.baidu.tieba.ala.gamelist.b.a.etp);
            this.asE.add(this.eBz);
        }
        this.eBB = new a((TbPageContext) this.cVD, com.baidu.tieba.ala.frsgamelive.b.a.eBE);
        this.eBC = new b((TbPageContext) this.cVD, com.baidu.tieba.ala.frsgamelive.b.b.eBF);
        this.asE.add(this.eBB);
        this.asE.add(this.eBC);
        this.ekb.addAdapters(this.asE);
    }

    public void setDatas(List<m> list) {
        if (this.ekb != null) {
            this.ekb.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.eBz != null) {
            this.eBz.a(dVar);
        }
        if (this.eBA != null) {
            this.eBA.a(dVar);
        }
    }
}
