package com.baidu.tieba.hottopic.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.w;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private List<com.baidu.adp.widget.ListView.a> aVK = new ArrayList();
    private BdTypeListView aVo;
    private h boL;
    private i boM;
    private l boN;
    private a boO;

    public g(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.boL = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.c.bpB);
        this.boM = new i(hotTopicActivity, com.baidu.tieba.hottopic.data.e.bpF);
        this.boN = new l(hotTopicActivity, com.baidu.tieba.hottopic.data.g.bpT);
        this.boO = new a(hotTopicActivity, w.Vx);
        this.aVK.add(this.boL);
        this.aVK.add(this.boM);
        this.aVK.add(this.boN);
        this.aVK.add(this.boO);
        this.aVo = bdTypeListView;
        this.aVo.h(this.aVK);
    }

    public void a(com.baidu.tieba.hottopic.data.b bVar) {
        ArrayList<u> arrayList;
        if (bVar.Rm() != null) {
            arrayList = bVar.Rm();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.aVo != null) {
            this.aVo.setData(arrayList);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVo.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVo.getAdapter()).notifyDataSetChanged();
        }
    }
}
