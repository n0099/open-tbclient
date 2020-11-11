package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private BdTypeListView gih;
    private d jNi;
    private c jNj;
    private m jNk;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.jNi = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.jOZ);
        this.jNj = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.jOY);
        this.jNk = new m(hotRanklistActivity, o.jQe);
        this.bky.add(this.jNi);
        this.bky.add(this.jNj);
        this.bky.add(this.jNk);
        this.gih = bdTypeListView;
        this.gih.addAdapters(this.bky);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cNe() != null) {
            arrayList = jVar.cNe();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.jNk != null) {
            this.jNk.cMu();
        }
        if (this.jNi != null) {
            this.jNi.LU(str);
        }
        if (this.gih != null) {
            this.gih.setData(arrayList);
        }
    }
}
