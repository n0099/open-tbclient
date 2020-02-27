package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private com.baidu.adp.base.e cVC;
    private a eBA;
    private b eBB;
    private f eBy;
    private c eBz;
    private BdTypeListView eka;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.cVC = eVar;
        this.eka = bdTypeListView;
        iw(z);
    }

    private void iw(boolean z) {
        if (z) {
            this.eBz = new c((TbPageContext) this.cVC, com.baidu.tieba.ala.gamelist.b.a.eto);
            this.asE.add(this.eBz);
        } else {
            this.eBy = new f((TbPageContext) this.cVC, com.baidu.tieba.ala.gamelist.b.a.eto);
            this.asE.add(this.eBy);
        }
        this.eBA = new a((TbPageContext) this.cVC, com.baidu.tieba.ala.frsgamelive.b.a.eBD);
        this.eBB = new b((TbPageContext) this.cVC, com.baidu.tieba.ala.frsgamelive.b.b.eBE);
        this.asE.add(this.eBA);
        this.asE.add(this.eBB);
        this.eka.addAdapters(this.asE);
    }

    public void setDatas(List<m> list) {
        if (this.eka != null) {
            this.eka.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.eBy != null) {
            this.eBy.a(dVar);
        }
        if (this.eBz != null) {
            this.eBz.a(dVar);
        }
    }
}
