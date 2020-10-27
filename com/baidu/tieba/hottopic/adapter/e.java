package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private BdTypeListView gcr;
    private j jHr;
    private h jHs;
    private k jHt;
    private f jHu;
    private g jHv;
    private a jHw;
    private i jHx;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.jHu = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.jHr = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.jJZ);
        this.jHs = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.jJH);
        this.jHt = new k(hotTopicActivity, n.jKc);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.jHv = new g(pageContext, com.baidu.tieba.card.data.l.TYPE);
        this.jHw = new a(pageContext, com.baidu.tieba.card.data.m.eyg);
        this.jHx = new i(pageContext, com.baidu.tieba.card.data.l.eyl);
        this.bje.add(this.jHr);
        this.bje.add(this.jHs);
        this.bje.add(this.jHt);
        this.bje.add(this.jHu);
        this.bje.add(this.jHv);
        this.bje.add(this.jHw);
        this.bje.add(this.jHx);
        this.gcr = bdTypeListView;
        this.gcr.addAdapters(this.bje);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cKD() != null) {
            arrayList = eVar.cKD();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.gcr != null) {
            this.gcr.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jHv != null) {
            this.jHv.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gcr.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }
}
