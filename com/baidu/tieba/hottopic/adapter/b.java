package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private BdTypeListView gpX;
    private d kbv;
    private c kbw;
    private m kbx;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.kbv = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.kdm);
        this.kbw = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.kdl);
        this.kbx = new m(hotRanklistActivity, o.ker);
        this.bnf.add(this.kbv);
        this.bnf.add(this.kbw);
        this.bnf.add(this.kbx);
        this.gpX = bdTypeListView;
        this.gpX.addAdapters(this.bnf);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cRZ() != null) {
            arrayList = jVar.cRZ();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.kbx != null) {
            this.kbx.cRp();
        }
        if (this.kbv != null) {
            this.kbv.MC(str);
        }
        if (this.gpX != null) {
            this.gpX.setData(arrayList);
        }
    }
}
