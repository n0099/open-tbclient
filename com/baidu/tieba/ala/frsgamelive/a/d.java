package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private com.baidu.adp.base.f eTl;
    private BdTypeMultiColumnListView gSo;
    private e gSp;
    private h gSq;

    public d(com.baidu.adp.base.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eTl = fVar;
        this.gSo = bdTypeMultiColumnListView;
        IY();
    }

    private void IY() {
        this.gSp = new e((TbPageContext) this.eTl, com.baidu.tieba.ala.frsgamelive.b.c.gSy);
        this.gSq = new h((TbPageContext) this.eTl, com.baidu.tieba.ala.frsgamelive.b.c.gSz);
        this.bjZ.add(this.gSp);
        this.bjZ.add(this.gSq);
        this.gSo.addAdapters(this.bjZ);
    }

    public void setDatas(List<n> list) {
        if (this.gSo != null) {
            this.gSo.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.g gVar) {
        if (this.gSp != null) {
            this.gSp.a(gVar);
        }
        if (this.gSq != null) {
            this.gSq.a(gVar);
        }
    }
}
