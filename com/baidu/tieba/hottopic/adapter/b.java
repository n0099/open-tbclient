package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private BdTypeListView fGf;
    private d jfM;
    private c jfN;
    private m jfO;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.jfM = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.jhD);
        this.jfN = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.jhC);
        this.jfO = new m(hotRanklistActivity, o.jiJ);
        this.bdV.add(this.jfM);
        this.bdV.add(this.jfN);
        this.bdV.add(this.jfO);
        this.fGf = bdTypeListView;
        this.fGf.addAdapters(this.bdV);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cDN() != null) {
            arrayList = jVar.cDN();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.jfO != null) {
            this.jfO.cDd();
        }
        if (this.jfM != null) {
            this.jfM.Kq(str);
        }
        if (this.fGf != null) {
            this.fGf.setData(arrayList);
        }
    }
}
