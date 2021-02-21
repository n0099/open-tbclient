package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private BdTypeListView gzp;
    private b ksA;
    private k ksB;
    private c ksz;

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.ksz = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.kuq);
        this.ksA = new b(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.kup);
        this.ksB = new k(hotRanklistActivity, o.kvw);
        this.bns.add(this.ksz);
        this.bns.add(this.ksA);
        this.bns.add(this.ksB);
        this.gzp = bdTypeListView;
        this.gzp.addAdapters(this.bns);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.cTv() != null) {
            arrayList = jVar.cTv();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.ksB != null) {
            this.ksB.cSL();
        }
        if (this.ksz != null) {
            this.ksz.Mj(str);
        }
        if (this.gzp != null) {
            this.gzp.setData(arrayList);
        }
    }
}
