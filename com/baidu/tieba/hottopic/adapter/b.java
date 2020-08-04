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
    private d iIc;
    private c iId;
    private m iIe;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.iIc = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.iJU);
        this.iId = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.iJT);
        this.iIe = new m(hotRanklistActivity, o.iKZ);
        this.aWf.add(this.iIc);
        this.aWf.add(this.iId);
        this.aWf.add(this.iIe);
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
        if (this.iIe != null) {
            this.iIe.coC();
        }
        if (this.iIc != null) {
            this.iIc.GV(str);
        }
        if (this.frv != null) {
            this.frv.setData(arrayList);
        }
    }
}
