package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private com.baidu.adp.base.e dvc;
    private h fgA;
    private BdTypeMultiColumnListView fgy;
    private e fgz;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.dvc = eVar;
        this.fgy = bdTypeMultiColumnListView;
        BC();
    }

    private void BC() {
        this.fgz = new e((TbPageContext) this.dvc, com.baidu.tieba.ala.frsgamelive.b.c.fgI);
        this.fgA = new h((TbPageContext) this.dvc, com.baidu.tieba.ala.frsgamelive.b.c.fgJ);
        this.aMd.add(this.fgz);
        this.aMd.add(this.fgA);
        this.fgy.addAdapters(this.aMd);
    }

    public void setDatas(List<m> list) {
        if (this.fgy != null) {
            this.fgy.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fgz != null) {
            this.fgz.a(dVar);
        }
        if (this.fgA != null) {
            this.fgA.a(dVar);
        }
    }
}
