package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private com.baidu.adp.base.e cVC;
    private BdTypeMultiColumnListView eBv;
    private e eBw;
    private h eBx;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.cVC = eVar;
        this.eBv = bdTypeMultiColumnListView;
        wM();
    }

    private void wM() {
        this.eBw = new e((TbPageContext) this.cVC, com.baidu.tieba.ala.frsgamelive.b.c.eBF);
        this.eBx = new h((TbPageContext) this.cVC, com.baidu.tieba.ala.frsgamelive.b.c.eBG);
        this.asE.add(this.eBw);
        this.asE.add(this.eBx);
        this.eBv.addAdapters(this.asE);
    }

    public void setDatas(List<m> list) {
        if (this.eBv != null) {
            this.eBv.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.eBw != null) {
            this.eBw.a(dVar);
        }
        if (this.eBx != null) {
            this.eBx.a(dVar);
        }
    }
}
