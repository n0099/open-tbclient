package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private com.baidu.adp.base.f eVB;
    private f gVp;
    private c gVq;
    private a gVr;
    private b gVs;
    private BdTypeListView gzp;

    public g(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.eVB = fVar;
        this.gzp = bdTypeListView;
        ni(z);
    }

    private void ni(boolean z) {
        if (z) {
            this.gVq = new c((TbPageContext) this.eVB, com.baidu.tieba.ala.gamelist.b.a.gIT);
            this.bns.add(this.gVq);
        } else {
            this.gVp = new f((TbPageContext) this.eVB, com.baidu.tieba.ala.gamelist.b.a.gIT);
            this.bns.add(this.gVp);
        }
        this.gVr = new a((TbPageContext) this.eVB, com.baidu.tieba.ala.frsgamelive.b.a.gVu);
        this.gVs = new b((TbPageContext) this.eVB, com.baidu.tieba.ala.frsgamelive.b.b.gVv);
        this.bns.add(this.gVr);
        this.bns.add(this.gVs);
        this.gzp.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
        if (this.gzp != null) {
            this.gzp.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.h hVar) {
        if (this.gVp != null) {
            this.gVp.a(hVar);
        }
        if (this.gVq != null) {
            this.gVq.a(hVar);
        }
    }
}
