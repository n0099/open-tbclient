package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private com.baidu.adp.base.e eid;
    private BdTypeListView fGf;
    private f gav;
    private c gaw;
    private a gax;
    private b gay;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.eid = eVar;
        this.fGf = bdTypeListView;
        lo(z);
    }

    private void lo(boolean z) {
        if (z) {
            this.gaw = new c((TbPageContext) this.eid, com.baidu.tieba.ala.gamelist.b.a.fPx);
            this.bdV.add(this.gaw);
        } else {
            this.gav = new f((TbPageContext) this.eid, com.baidu.tieba.ala.gamelist.b.a.fPx);
            this.bdV.add(this.gav);
        }
        this.gax = new a((TbPageContext) this.eid, com.baidu.tieba.ala.frsgamelive.b.a.gaA);
        this.gay = new b((TbPageContext) this.eid, com.baidu.tieba.ala.frsgamelive.b.b.gaB);
        this.bdV.add(this.gax);
        this.bdV.add(this.gay);
        this.fGf.addAdapters(this.bdV);
    }

    public void setDatas(List<q> list) {
        if (this.fGf != null) {
            this.fGf.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gav != null) {
            this.gav.a(fVar);
        }
        if (this.gaw != null) {
            this.gaw.a(fVar);
        }
    }
}
