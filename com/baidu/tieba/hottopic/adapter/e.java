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
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private BdTypeListView gpZ;
    private j kbE;
    private h kbF;
    private k kbG;
    private f kbH;
    private g kbI;
    private a kbJ;
    private i kbK;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.kbH = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.kbE = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.kem);
        this.kbF = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.kdU);
        this.kbG = new k(hotTopicActivity, n.kep);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.kbI = new g(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kbJ = new a(pageContext, com.baidu.tieba.card.data.l.eJq);
        this.kbK = new i(pageContext, com.baidu.tieba.card.data.k.eJv);
        this.bnf.add(this.kbE);
        this.bnf.add(this.kbF);
        this.bnf.add(this.kbG);
        this.bnf.add(this.kbH);
        this.bnf.add(this.kbI);
        this.bnf.add(this.kbJ);
        this.bnf.add(this.kbK);
        this.gpZ = bdTypeListView;
        this.gpZ.addAdapters(this.bnf);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cSa() != null) {
            arrayList = eVar.cSa();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.gpZ != null) {
            this.gpZ.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.kbI != null) {
            this.kbI.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gpZ.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }
}
