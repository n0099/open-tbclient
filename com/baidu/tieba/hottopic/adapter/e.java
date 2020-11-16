package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private BdTypeListView ghN;
    private j jNZ;
    private h jOa;
    private k jOb;
    private f jOc;
    private g jOd;
    private a jOe;
    private i jOf;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.jOc = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.jNZ = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.jQH);
        this.jOa = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.jQp);
        this.jOb = new k(hotTopicActivity, n.jQK);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.jOd = new g(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jOe = new a(pageContext, com.baidu.tieba.card.data.l.eCo);
        this.jOf = new i(pageContext, com.baidu.tieba.card.data.k.eCt);
        this.biN.add(this.jNZ);
        this.biN.add(this.jOa);
        this.biN.add(this.jOb);
        this.biN.add(this.jOc);
        this.biN.add(this.jOd);
        this.biN.add(this.jOe);
        this.biN.add(this.jOf);
        this.ghN = bdTypeListView;
        this.ghN.addAdapters(this.biN);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cML() != null) {
            arrayList = eVar.cML();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.ghN != null) {
            this.ghN.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jOd != null) {
            this.jOd.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.ghN.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }
}
