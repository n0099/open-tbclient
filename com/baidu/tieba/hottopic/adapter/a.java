package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private BdTypeListView gAY;
    private c kuB;
    private b kuC;
    private k kuD;

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.kuB = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.kws);
        this.kuC = new b(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.kwr);
        this.kuD = new k(hotRanklistActivity, o.kxy);
        this.boS.add(this.kuB);
        this.boS.add(this.kuC);
        this.boS.add(this.kuD);
        this.gAY = bdTypeListView;
        this.gAY.addAdapters(this.boS);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.cTC() != null) {
            arrayList = jVar.cTC();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.kuD != null) {
            this.kuD.cSS();
        }
        if (this.kuB != null) {
            this.kuB.Mp(str);
        }
        if (this.gAY != null) {
            this.gAY.setData(arrayList);
        }
    }
}
