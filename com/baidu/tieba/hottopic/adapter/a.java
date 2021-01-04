package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private BdTypeListView gAY;
    private c koJ;
    private b koK;
    private k koL;

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.koJ = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.kqA);
        this.koK = new b(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.kqz);
        this.koL = new k(hotRanklistActivity, o.krG);
        this.boM.add(this.koJ);
        this.boM.add(this.koK);
        this.boM.add(this.koL);
        this.gAY = bdTypeListView;
        this.gAY.addAdapters(this.boM);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.cVg() != null) {
            arrayList = jVar.cVg();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.koL != null) {
            this.koL.cUw();
        }
        if (this.koJ != null) {
            this.koJ.MC(str);
        }
        if (this.gAY != null) {
            this.gAY.setData(arrayList);
        }
    }
}
