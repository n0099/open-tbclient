package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private BdTypeListView fCP;
    private d iXa;
    private c iXb;
    private m iXc;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.iXa = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.iYS);
        this.iXb = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.iYR);
        this.iXc = new m(hotRanklistActivity, o.iZX);
        this.bbu.add(this.iXa);
        this.bbu.add(this.iXb);
        this.bbu.add(this.iXc);
        this.fCP = bdTypeListView;
        this.fCP.addAdapters(this.bbu);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cAf() != null) {
            arrayList = jVar.cAf();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.iXc != null) {
            this.iXc.czv();
        }
        if (this.iXa != null) {
            this.iXa.JN(str);
        }
        if (this.fCP != null) {
            this.fCP.setData(arrayList);
        }
    }
}
