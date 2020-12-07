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
    private BdTypeListView gpX;
    private j kbC;
    private h kbD;
    private k kbE;
    private f kbF;
    private g kbG;
    private a kbH;
    private i kbI;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.kbF = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.kbC = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.kek);
        this.kbD = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.kdS);
        this.kbE = new k(hotTopicActivity, n.ken);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.kbG = new g(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kbH = new a(pageContext, com.baidu.tieba.card.data.l.eJq);
        this.kbI = new i(pageContext, com.baidu.tieba.card.data.k.eJv);
        this.bnf.add(this.kbC);
        this.bnf.add(this.kbD);
        this.bnf.add(this.kbE);
        this.bnf.add(this.kbF);
        this.bnf.add(this.kbG);
        this.bnf.add(this.kbH);
        this.bnf.add(this.kbI);
        this.gpX = bdTypeListView;
        this.gpX.addAdapters(this.bnf);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cRZ() != null) {
            arrayList = eVar.cRZ();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.gpX != null) {
            this.gpX.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.kbG != null) {
            this.kbG.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gpX.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }
}
