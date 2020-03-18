package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private com.baidu.adp.base.e cVR;
    private f eCi;
    private c eCj;
    private a eCk;
    private b eCl;
    private BdTypeListView ekE;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.cVR = eVar;
        this.ekE = bdTypeListView;
        iy(z);
    }

    private void iy(boolean z) {
        if (z) {
            this.eCj = new c((TbPageContext) this.cVR, com.baidu.tieba.ala.gamelist.b.a.etY);
            this.asP.add(this.eCj);
        } else {
            this.eCi = new f((TbPageContext) this.cVR, com.baidu.tieba.ala.gamelist.b.a.etY);
            this.asP.add(this.eCi);
        }
        this.eCk = new a((TbPageContext) this.cVR, com.baidu.tieba.ala.frsgamelive.b.a.eCn);
        this.eCl = new b((TbPageContext) this.cVR, com.baidu.tieba.ala.frsgamelive.b.b.eCo);
        this.asP.add(this.eCk);
        this.asP.add(this.eCl);
        this.ekE.addAdapters(this.asP);
    }

    public void setDatas(List<m> list) {
        if (this.ekE != null) {
            this.ekE.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.eCi != null) {
            this.eCi.a(dVar);
        }
        if (this.eCj != null) {
            this.eCj.a(dVar);
        }
    }
}
