package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.m;
import com.baidu.tieba.hottopic.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private BdTypeListView gzp;
    private i ksG;
    private g ksH;
    private RelateCardForumAdapter ksI;
    private e ksJ;
    private f ksK;
    private HomePageVideoThreadAdapter ksL;
    private h ksM;

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.ksJ = new e(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.ksG = new i(hotTopicActivity, m.kvp);
        this.ksH = new g(hotTopicActivity, com.baidu.tieba.hottopic.data.i.kuX);
        this.ksI = new RelateCardForumAdapter(hotTopicActivity, n.kvs);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.ksK = new f(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ksL = new HomePageVideoThreadAdapter(pageContext, l.eQK);
        this.ksM = new h(pageContext, com.baidu.tieba.card.data.k.eQP);
        this.bns.add(this.ksG);
        this.bns.add(this.ksH);
        this.bns.add(this.ksI);
        this.bns.add(this.ksJ);
        this.bns.add(this.ksK);
        this.bns.add(this.ksL);
        this.bns.add(this.ksM);
        this.gzp = bdTypeListView;
        this.gzp.addAdapters(this.bns);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList;
        if (eVar.cTv() != null) {
            arrayList = eVar.cTv();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.gzp != null) {
            this.gzp.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.ksK != null) {
            this.ksK.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzp.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }
}
