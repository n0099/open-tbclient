package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private com.baidu.adp.base.e eCK;
    private BdTypeListView gcr;
    private f gwR;
    private c gwS;
    private a gwT;
    private b gwU;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.eCK = eVar;
        this.gcr = bdTypeListView;
        mc(z);
    }

    private void mc(boolean z) {
        if (z) {
            this.gwS = new c((TbPageContext) this.eCK, com.baidu.tieba.ala.gamelist.b.a.glT);
            this.bje.add(this.gwS);
        } else {
            this.gwR = new f((TbPageContext) this.eCK, com.baidu.tieba.ala.gamelist.b.a.glT);
            this.bje.add(this.gwR);
        }
        this.gwT = new a((TbPageContext) this.eCK, com.baidu.tieba.ala.frsgamelive.b.a.gwW);
        this.gwU = new b((TbPageContext) this.eCK, com.baidu.tieba.ala.frsgamelive.b.b.gwX);
        this.bje.add(this.gwT);
        this.bje.add(this.gwU);
        this.gcr.addAdapters(this.bje);
    }

    public void setDatas(List<q> list) {
        if (this.gcr != null) {
            this.gcr.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gwR != null) {
            this.gwR.a(fVar);
        }
        if (this.gwS != null) {
            this.gwS.a(fVar);
        }
    }
}
