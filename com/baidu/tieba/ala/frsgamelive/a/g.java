package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private com.baidu.adp.base.f eTl;
    private f gSr;
    private c gSs;
    private a gSt;
    private b gSu;
    private BdTypeListView gwr;

    public g(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.eTl = fVar;
        this.gwr = bdTypeListView;
        nd(z);
    }

    private void nd(boolean z) {
        if (z) {
            this.gSs = new c((TbPageContext) this.eTl, com.baidu.tieba.ala.gamelist.b.a.gFV);
            this.bjZ.add(this.gSs);
        } else {
            this.gSr = new f((TbPageContext) this.eTl, com.baidu.tieba.ala.gamelist.b.a.gFV);
            this.bjZ.add(this.gSr);
        }
        this.gSt = new a((TbPageContext) this.eTl, com.baidu.tieba.ala.frsgamelive.b.a.gSw);
        this.gSu = new b((TbPageContext) this.eTl, com.baidu.tieba.ala.frsgamelive.b.b.gSx);
        this.bjZ.add(this.gSt);
        this.bjZ.add(this.gSu);
        this.gwr.addAdapters(this.bjZ);
    }

    public void setDatas(List<n> list) {
        if (this.gwr != null) {
            this.gwr.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.g gVar) {
        if (this.gSr != null) {
            this.gSr.a(gVar);
        }
        if (this.gSs != null) {
            this.gSs.a(gVar);
        }
    }
}
