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
    private f gVb;
    private c gVc;
    private a gVd;
    private b gVe;
    private BdTypeListView gzb;

    public g(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.eVB = fVar;
        this.gzb = bdTypeListView;
        ni(z);
    }

    private void ni(boolean z) {
        if (z) {
            this.gVc = new c((TbPageContext) this.eVB, com.baidu.tieba.ala.gamelist.b.a.gIF);
            this.bns.add(this.gVc);
        } else {
            this.gVb = new f((TbPageContext) this.eVB, com.baidu.tieba.ala.gamelist.b.a.gIF);
            this.bns.add(this.gVb);
        }
        this.gVd = new a((TbPageContext) this.eVB, com.baidu.tieba.ala.frsgamelive.b.a.gVg);
        this.gVe = new b((TbPageContext) this.eVB, com.baidu.tieba.ala.frsgamelive.b.b.gVh);
        this.bns.add(this.gVd);
        this.bns.add(this.gVe);
        this.gzb.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
        if (this.gzb != null) {
            this.gzb.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.h hVar) {
        if (this.gVb != null) {
            this.gVb.a(hVar);
        }
        if (this.gVc != null) {
            this.gVc.a(hVar);
        }
    }
}
