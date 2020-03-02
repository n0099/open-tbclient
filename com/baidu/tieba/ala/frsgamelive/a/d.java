package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private com.baidu.adp.base.e cVD;
    private BdTypeMultiColumnListView eBw;
    private e eBx;
    private h eBy;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.cVD = eVar;
        this.eBw = bdTypeMultiColumnListView;
        wM();
    }

    private void wM() {
        this.eBx = new e((TbPageContext) this.cVD, com.baidu.tieba.ala.frsgamelive.b.c.eBG);
        this.eBy = new h((TbPageContext) this.cVD, com.baidu.tieba.ala.frsgamelive.b.c.eBH);
        this.asE.add(this.eBx);
        this.asE.add(this.eBy);
        this.eBw.addAdapters(this.asE);
    }

    public void setDatas(List<m> list) {
        if (this.eBw != null) {
            this.eBw.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.eBx != null) {
            this.eBx.a(dVar);
        }
        if (this.eBy != null) {
            this.eBy.a(dVar);
        }
    }
}
