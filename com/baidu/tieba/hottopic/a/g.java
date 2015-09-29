package com.baidu.tieba.hottopic.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.v;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private BdTypeListView aUV;
    private List<com.baidu.adp.widget.ListView.a> aVr = new ArrayList();
    private h bnW;
    private i bnX;
    private l bnY;
    private a bnZ;

    public g(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.bnW = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.c.boM);
        this.bnX = new i(hotTopicActivity, com.baidu.tieba.hottopic.data.e.boQ);
        this.bnY = new l(hotTopicActivity, com.baidu.tieba.hottopic.data.g.bpe);
        this.bnZ = new a(hotTopicActivity, v.Vs);
        this.aVr.add(this.bnW);
        this.aVr.add(this.bnX);
        this.aVr.add(this.bnY);
        this.aVr.add(this.bnZ);
        this.aUV = bdTypeListView;
        this.aUV.h(this.aVr);
    }

    public void a(com.baidu.tieba.hottopic.data.b bVar) {
        ArrayList<u> arrayList;
        if (bVar.QU() != null) {
            arrayList = bVar.QU();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.aUV != null) {
            this.aUV.setData(arrayList);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aUV.getAdapter()).notifyDataSetChanged();
        }
    }
}
