package com.baidu.tieba.hottopic.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.w;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private List<com.baidu.adp.widget.ListView.a> aVC = new ArrayList();
    private BdTypeListView aVg;
    private h boh;
    private i boi;
    private l boj;
    private a bok;

    public g(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.boh = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.c.boX);
        this.boi = new i(hotTopicActivity, com.baidu.tieba.hottopic.data.e.bpb);
        this.boj = new l(hotTopicActivity, com.baidu.tieba.hottopic.data.g.bpp);
        this.bok = new a(hotTopicActivity, w.Vu);
        this.aVC.add(this.boh);
        this.aVC.add(this.boi);
        this.aVC.add(this.boj);
        this.aVC.add(this.bok);
        this.aVg = bdTypeListView;
        this.aVg.h(this.aVC);
    }

    public void a(com.baidu.tieba.hottopic.data.b bVar) {
        ArrayList<u> arrayList;
        if (bVar.QU() != null) {
            arrayList = bVar.QU();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.aVg != null) {
            this.aVg.setData(arrayList);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVg.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVg.getAdapter()).notifyDataSetChanged();
        }
    }
}
