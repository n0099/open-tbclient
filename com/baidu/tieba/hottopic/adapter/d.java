package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.m;
import com.baidu.tieba.hottopic.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private BdTypeListView gwr;
    private i kkl;
    private g kkm;
    private RelateCardForumAdapter kkn;
    private e kko;
    private f kkp;
    private HomePageVideoThreadAdapter kkq;
    private h kkr;

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.kko = new e(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.kkl = new i(hotTopicActivity, m.kmU);
        this.kkm = new g(hotTopicActivity, com.baidu.tieba.hottopic.data.i.kmC);
        this.kkn = new RelateCardForumAdapter(hotTopicActivity, n.kmX);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.kkp = new f(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kkq = new HomePageVideoThreadAdapter(pageContext, l.eOy);
        this.kkr = new h(pageContext, com.baidu.tieba.card.data.k.eOD);
        this.bjZ.add(this.kkl);
        this.bjZ.add(this.kkm);
        this.bjZ.add(this.kkn);
        this.bjZ.add(this.kko);
        this.bjZ.add(this.kkp);
        this.bjZ.add(this.kkq);
        this.bjZ.add(this.kkr);
        this.gwr = bdTypeListView;
        this.gwr.addAdapters(this.bjZ);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList;
        if (eVar.cRp() != null) {
            arrayList = eVar.cRp();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.gwr != null) {
            this.gwr.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.kkp != null) {
            this.kkp.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gwr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }
}
