package com.baidu.tieba.hottopic.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private List<com.baidu.adp.widget.ListView.a> aXX = new ArrayList();
    private BdTypeListView aXu;
    private h bJo;
    private s bJp;
    private n bJq;
    private u bJr;
    private k bJs;
    private l bJt;
    private o bJu;
    private q bJv;

    public g(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.bJo = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.f.aSH);
        this.bJp = new s(hotTopicActivity, com.baidu.tieba.hottopic.data.l.bLy);
        this.bJq = new n(hotTopicActivity, com.baidu.tieba.hottopic.data.h.bLi);
        this.bJr = new u(hotTopicActivity, com.baidu.tieba.hottopic.data.m.bLD);
        this.bJs = new k(hotTopicActivity, com.baidu.tieba.hottopic.data.g.aRS);
        this.bJt = new l(hotTopicActivity.getPageContext(), com.baidu.tieba.card.a.q.aRS);
        this.bJt.setPageUniqueId(hotTopicActivity.getUniqueId());
        this.bJu = new o(hotTopicActivity.getPageContext(), com.baidu.tieba.card.a.r.aRS);
        this.bJv = new q(hotTopicActivity.getPageContext(), com.baidu.tieba.card.a.s.aSz);
        this.bJv.setPageUniqueId(hotTopicActivity.getUniqueId());
        this.aXX.add(this.bJo);
        this.aXX.add(this.bJp);
        this.aXX.add(this.bJq);
        this.aXX.add(this.bJr);
        this.aXX.add(this.bJs);
        this.aXX.add(this.bJt);
        this.aXX.add(this.bJu);
        this.aXX.add(this.bJv);
        this.aXu = bdTypeListView;
        this.aXu.g(this.aXX);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList;
        if (eVar.XT() != null) {
            arrayList = eVar.XT();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.aXu != null) {
            this.aXu.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.bJt != null) {
            this.bJt.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetChanged();
        }
    }
}
