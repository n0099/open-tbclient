package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private BdTypeListView fCP;
    private j iXh;
    private h iXi;
    private k iXj;
    private f iXk;
    private g iXl;
    private a iXm;
    private i iXn;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.iXk = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.iXh = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.iZQ);
        this.iXi = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.iZy);
        this.iXj = new k(hotTopicActivity, n.iZT);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.iXl = new g(pageContext, com.baidu.tieba.card.data.l.TYPE);
        this.iXm = new a(pageContext, com.baidu.tieba.card.data.m.ebo);
        this.iXn = new i(pageContext, com.baidu.tieba.card.data.l.ebs);
        this.bbu.add(this.iXh);
        this.bbu.add(this.iXi);
        this.bbu.add(this.iXj);
        this.bbu.add(this.iXk);
        this.bbu.add(this.iXl);
        this.bbu.add(this.iXm);
        this.bbu.add(this.iXn);
        this.fCP = bdTypeListView;
        this.fCP.addAdapters(this.bbu);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cAf() != null) {
            arrayList = eVar.cAf();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.fCP != null) {
            this.fCP.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.iXl != null) {
            this.iXl.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCP.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }
}
