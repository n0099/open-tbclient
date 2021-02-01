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
    private BdTypeListView gzb;
    private i kss;
    private g kst;
    private RelateCardForumAdapter ksu;
    private e ksv;
    private f ksw;
    private HomePageVideoThreadAdapter ksx;
    private h ksy;

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.ksv = new e(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.kss = new i(hotTopicActivity, m.kvb);
        this.kst = new g(hotTopicActivity, com.baidu.tieba.hottopic.data.i.kuJ);
        this.ksu = new RelateCardForumAdapter(hotTopicActivity, n.kve);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.ksw = new f(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ksx = new HomePageVideoThreadAdapter(pageContext, l.eQK);
        this.ksy = new h(pageContext, com.baidu.tieba.card.data.k.eQP);
        this.bns.add(this.kss);
        this.bns.add(this.kst);
        this.bns.add(this.ksu);
        this.bns.add(this.ksv);
        this.bns.add(this.ksw);
        this.bns.add(this.ksx);
        this.bns.add(this.ksy);
        this.gzb = bdTypeListView;
        this.gzb.addAdapters(this.bns);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList;
        if (eVar.cTo() != null) {
            arrayList = eVar.cTo();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.gzb != null) {
            this.gzb.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.ksw != null) {
            this.ksw.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }
}
