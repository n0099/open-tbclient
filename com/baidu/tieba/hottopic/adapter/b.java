package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private BdTypeListView fSo;
    private d juL;
    private c juM;
    private m juN;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.juL = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.jwC);
        this.juM = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.jwB);
        this.juN = new m(hotRanklistActivity, o.jxH);
        this.bhH.add(this.juL);
        this.bhH.add(this.juM);
        this.bhH.add(this.juN);
        this.fSo = bdTypeListView;
        this.fSo.addAdapters(this.bhH);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cHw() != null) {
            arrayList = jVar.cHw();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.juN != null) {
            this.juN.cGM();
        }
        if (this.juL != null) {
            this.juL.Lf(str);
        }
        if (this.fSo != null) {
            this.fSo.setData(arrayList);
        }
    }
}
