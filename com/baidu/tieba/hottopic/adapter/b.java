package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private BdTypeListView ghN;
    private d jNS;
    private c jNT;
    private m jNU;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.jNS = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.jPJ);
        this.jNT = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.jPI);
        this.jNU = new m(hotRanklistActivity, o.jQO);
        this.biN.add(this.jNS);
        this.biN.add(this.jNT);
        this.biN.add(this.jNU);
        this.ghN = bdTypeListView;
        this.ghN.addAdapters(this.biN);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cML() != null) {
            arrayList = jVar.cML();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.jNU != null) {
            this.jNU.cMb();
        }
        if (this.jNS != null) {
            this.jNS.Lv(str);
        }
        if (this.ghN != null) {
            this.ghN.setData(arrayList);
        }
    }
}
