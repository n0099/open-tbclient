package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private com.baidu.adp.base.e cVR;
    private BdTypeMultiColumnListView eCf;
    private e eCg;
    private h eCh;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.cVR = eVar;
        this.eCf = bdTypeMultiColumnListView;
        wR();
    }

    private void wR() {
        this.eCg = new e((TbPageContext) this.cVR, com.baidu.tieba.ala.frsgamelive.b.c.eCp);
        this.eCh = new h((TbPageContext) this.cVR, com.baidu.tieba.ala.frsgamelive.b.c.eCq);
        this.asP.add(this.eCg);
        this.asP.add(this.eCh);
        this.eCf.addAdapters(this.asP);
    }

    public void setDatas(List<m> list) {
        if (this.eCf != null) {
            this.eCf.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.eCg != null) {
            this.eCg.a(dVar);
        }
        if (this.eCh != null) {
            this.eCh.a(dVar);
        }
    }
}
