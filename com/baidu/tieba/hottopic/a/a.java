package com.baidu.tieba.hottopic.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aXX = new ArrayList();
    private BdTypeListView aXu;
    private d bJi;
    private b bJj;

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    private void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.bJi = new d(hotRanklistActivity, com.baidu.tieba.hottopic.data.c.bKM);
        this.bJj = new b(hotRanklistActivity, com.baidu.tieba.hottopic.data.b.bKL);
        this.aXX.add(this.bJi);
        this.aXX.add(this.bJj);
        this.aXu = bdTypeListView;
        this.aXu.g(this.aXX);
    }

    public void a(com.baidu.tieba.hottopic.data.i iVar) {
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList;
        if (iVar.XT() != null) {
            arrayList = iVar.XT();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.aXu != null) {
            this.aXu.setData(arrayList);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetChanged();
        }
    }
}
