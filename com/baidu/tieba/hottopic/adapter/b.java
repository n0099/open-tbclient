package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private BdTypeListView fml;
    private d iBW;
    private c iBX;
    private m iBY;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.iBW = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.iDO);
        this.iBX = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.iDN);
        this.iBY = new m(hotRanklistActivity, o.iET);
        this.aUP.add(this.iBW);
        this.aUP.add(this.iBX);
        this.aUP.add(this.iBY);
        this.fml = bdTypeListView;
        this.fml.addAdapters(this.aUP);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.clL() != null) {
            arrayList = jVar.clL();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.iBY != null) {
            this.iBY.clb();
        }
        if (this.iBW != null) {
            this.iBW.Gj(str);
        }
        if (this.fml != null) {
            this.fml.setData(arrayList);
        }
    }
}
