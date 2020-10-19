package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private com.baidu.adp.base.e eul;
    private BdTypeMultiColumnListView gmJ;
    private e gmK;
    private h gmL;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.eul = eVar;
        this.gmJ = bdTypeMultiColumnListView;
        Le();
    }

    private void Le() {
        this.gmK = new e((TbPageContext) this.eul, com.baidu.tieba.ala.frsgamelive.b.c.gmT);
        this.gmL = new h((TbPageContext) this.eul, com.baidu.tieba.ala.frsgamelive.b.c.gmU);
        this.bhH.add(this.gmK);
        this.bhH.add(this.gmL);
        this.gmJ.addAdapters(this.bhH);
    }

    public void setDatas(List<q> list) {
        if (this.gmJ != null) {
            this.gmJ.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gmK != null) {
            this.gmK.a(fVar);
        }
        if (this.gmL != null) {
            this.gmL.a(fVar);
        }
    }
}
