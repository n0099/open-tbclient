package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private BdTypeListView fCT;
    private d iXg;
    private c iXh;
    private m iXi;

    public b(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.iXg = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.iYY);
        this.iXh = new c(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.iYX);
        this.iXi = new m(hotRanklistActivity, o.jad);
        this.bbw.add(this.iXg);
        this.bbw.add(this.iXh);
        this.bbw.add(this.iXi);
        this.fCT = bdTypeListView;
        this.fCT.addAdapters(this.bbw);
    }

    public void a(com.baidu.tieba.hottopic.data.j jVar, String str) {
        ArrayList<q> arrayList;
        if (jVar.cAg() != null) {
            arrayList = jVar.cAg();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.iXi != null) {
            this.iXi.czw();
        }
        if (this.iXg != null) {
            this.iXg.JO(str);
        }
        if (this.fCT != null) {
            this.fCT.setData(arrayList);
        }
    }
}
