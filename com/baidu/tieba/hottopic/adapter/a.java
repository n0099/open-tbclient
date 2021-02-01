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
    private BdTypeListView gzb;
    private c ksl;
    private b ksm;
    private k ksn;

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.ksl = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.kuc);
        this.ksm = new b(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.kub);
        this.ksn = new k(hotRanklistActivity, o.kvi);
        this.bns.add(this.ksl);
        this.bns.add(this.ksm);
        this.bns.add(this.ksn);
        this.gzb = bdTypeListView;
        this.gzb.addAdapters(this.bns);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.cTo() != null) {
            arrayList = jVar.cTo();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.ksn != null) {
            this.ksn.cSE();
        }
        if (this.ksl != null) {
            this.ksl.Mi(str);
        }
        if (this.gzb != null) {
            this.gzb.setData(arrayList);
        }
    }
}
