package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private com.baidu.adp.base.f eVB;
    private BdTypeMultiColumnListView gVm;
    private e gVn;
    private h gVo;

    public d(com.baidu.adp.base.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eVB = fVar;
        this.gVm = bdTypeMultiColumnListView;
        Kw();
    }

    private void Kw() {
        this.gVn = new e((TbPageContext) this.eVB, com.baidu.tieba.ala.frsgamelive.b.c.gVw);
        this.gVo = new h((TbPageContext) this.eVB, com.baidu.tieba.ala.frsgamelive.b.c.gVx);
        this.bns.add(this.gVn);
        this.bns.add(this.gVo);
        this.gVm.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
        if (this.gVm != null) {
            this.gVm.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.h hVar) {
        if (this.gVn != null) {
            this.gVn.a(hVar);
        }
        if (this.gVo != null) {
            this.gVo.a(hVar);
        }
    }
}
