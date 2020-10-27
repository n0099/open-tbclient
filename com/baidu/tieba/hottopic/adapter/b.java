package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private BdTypeListView gcr;
    private d jHk;
    private c jHl;
    private m jHm;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.jHk = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.jJb);
        this.jHl = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.jJa);
        this.jHm = new m(hotRanklistActivity, o.jKg);
        this.bje.add(this.jHk);
        this.bje.add(this.jHl);
        this.bje.add(this.jHm);
        this.gcr = bdTypeListView;
        this.gcr.addAdapters(this.bje);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cKD() != null) {
            arrayList = jVar.cKD();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.jHm != null) {
            this.jHm.cJT();
        }
        if (this.jHk != null) {
            this.jHk.LD(str);
        }
        if (this.gcr != null) {
            this.gcr.setData(arrayList);
        }
    }
}
