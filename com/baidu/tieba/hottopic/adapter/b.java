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
    private BdTypeListView gpZ;
    private d kbx;
    private c kby;
    private m kbz;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.kbx = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.kdo);
        this.kby = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.kdn);
        this.kbz = new m(hotRanklistActivity, o.ket);
        this.bnf.add(this.kbx);
        this.bnf.add(this.kby);
        this.bnf.add(this.kbz);
        this.gpZ = bdTypeListView;
        this.gpZ.addAdapters(this.bnf);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cSa() != null) {
            arrayList = jVar.cSa();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.kbz != null) {
            this.kbz.cRq();
        }
        if (this.kbx != null) {
            this.kbx.MC(str);
        }
        if (this.gpZ != null) {
            this.gpZ.setData(arrayList);
        }
    }
}
