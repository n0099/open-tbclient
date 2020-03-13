package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private com.baidu.adp.base.e cVE;
    private f eBM;
    private c eBN;
    private a eBO;
    private b eBP;
    private BdTypeListView eko;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.cVE = eVar;
        this.eko = bdTypeListView;
        iw(z);
    }

    private void iw(boolean z) {
        if (z) {
            this.eBN = new c((TbPageContext) this.cVE, com.baidu.tieba.ala.gamelist.b.a.etC);
            this.asF.add(this.eBN);
        } else {
            this.eBM = new f((TbPageContext) this.cVE, com.baidu.tieba.ala.gamelist.b.a.etC);
            this.asF.add(this.eBM);
        }
        this.eBO = new a((TbPageContext) this.cVE, com.baidu.tieba.ala.frsgamelive.b.a.eBR);
        this.eBP = new b((TbPageContext) this.cVE, com.baidu.tieba.ala.frsgamelive.b.b.eBS);
        this.asF.add(this.eBO);
        this.asF.add(this.eBP);
        this.eko.addAdapters(this.asF);
    }

    public void setDatas(List<m> list) {
        if (this.eko != null) {
            this.eko.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.eBM != null) {
            this.eBM.a(dVar);
        }
        if (this.eBN != null) {
            this.eBN.a(dVar);
        }
    }
}
