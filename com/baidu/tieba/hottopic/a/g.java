package com.baidu.tieba.hottopic.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.data.z;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private List<com.baidu.adp.widget.ListView.a> aRI = new ArrayList();
    private BdTypeListView aRs;
    private n bCA;
    private j bCB;
    private s bCC;
    private a bCD;
    private h bCy;
    private k bCz;

    public g(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.bCy = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.d.bDP);
        this.bCz = new k(hotTopicActivity, com.baidu.tieba.hottopic.data.g.bEe);
        this.bCA = new n(hotTopicActivity, com.baidu.tieba.hottopic.data.i.bEs);
        this.bCB = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.e.bDT);
        this.bCC = new s(hotTopicActivity, com.baidu.tieba.hottopic.data.j.bEv);
        this.bCD = new a(hotTopicActivity, z.Wc);
        this.aRI.add(this.bCy);
        this.aRI.add(this.bCz);
        this.aRI.add(this.bCA);
        this.aRI.add(this.bCB);
        this.aRI.add(this.bCC);
        this.aRI.add(this.bCD);
        this.aRs = bdTypeListView;
        this.aRs.g(this.aRI);
    }

    public void a(com.baidu.tieba.hottopic.data.c cVar) {
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList;
        if (cVar.Ux() != null) {
            arrayList = cVar.Ux();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.aRs != null) {
            this.aRs.setData(arrayList);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetChanged();
        }
    }
}
