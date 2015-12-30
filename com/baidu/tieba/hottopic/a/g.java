package com.baidu.tieba.hottopic.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.data.z;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private List<com.baidu.adp.widget.ListView.a> aVK = new ArrayList();
    private BdTypeListView aVi;
    private h bGc;
    private k bGd;
    private n bGe;
    private j bGf;
    private s bGg;
    private a bGh;

    public g(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.bGc = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.d.aQD);
        this.bGd = new k(hotTopicActivity, com.baidu.tieba.hottopic.data.g.bHH);
        this.bGe = new n(hotTopicActivity, com.baidu.tieba.hottopic.data.i.bHV);
        this.bGf = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.e.bHw);
        this.bGg = new s(hotTopicActivity, com.baidu.tieba.hottopic.data.j.bHZ);
        this.bGh = new a(hotTopicActivity, z.WC);
        this.aVK.add(this.bGc);
        this.aVK.add(this.bGd);
        this.aVK.add(this.bGe);
        this.aVK.add(this.bGf);
        this.aVK.add(this.bGg);
        this.aVK.add(this.bGh);
        this.aVi = bdTypeListView;
        this.aVi.g(this.aVK);
    }

    public void a(com.baidu.tieba.hottopic.data.c cVar) {
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList;
        if (cVar.VA() != null) {
            arrayList = cVar.VA();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.aVi != null) {
            this.aVi.setData(arrayList);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).notifyDataSetChanged();
        }
    }
}
