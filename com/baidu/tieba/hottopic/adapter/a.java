package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private BdTypeListView gwr;
    private c kke;
    private b kkf;
    private k kkg;

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.kke = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.klV);
        this.kkf = new b(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.klU);
        this.kkg = new k(hotRanklistActivity, o.knb);
        this.bjZ.add(this.kke);
        this.bjZ.add(this.kkf);
        this.bjZ.add(this.kkg);
        this.gwr = bdTypeListView;
        this.gwr.addAdapters(this.bjZ);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.cRp() != null) {
            arrayList = jVar.cRp();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.kkg != null) {
            this.kkg.cQF();
        }
        if (this.kke != null) {
            this.kke.Lt(str);
        }
        if (this.gwr != null) {
            this.gwr.setData(arrayList);
        }
    }
}
