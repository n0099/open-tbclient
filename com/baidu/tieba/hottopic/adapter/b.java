package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private BdTypeListView frv;
    private d iIa;
    private c iIb;
    private m iIc;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.iIa = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.iJS);
        this.iIb = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.iJR);
        this.iIc = new m(hotRanklistActivity, o.iKX);
        this.aWf.add(this.iIa);
        this.aWf.add(this.iIb);
        this.aWf.add(this.iIc);
        this.frv = bdTypeListView;
        this.frv.addAdapters(this.aWf);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cpm() != null) {
            arrayList = jVar.cpm();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.iIc != null) {
            this.iIc.coC();
        }
        if (this.iIa != null) {
            this.iIa.GV(str);
        }
        if (this.frv != null) {
            this.frv.setData(arrayList);
        }
    }
}
