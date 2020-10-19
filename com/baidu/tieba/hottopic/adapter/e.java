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
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private BdTypeListView fSo;
    private j juS;
    private h juT;
    private k juU;
    private f juV;
    private g juW;
    private a juX;
    private i juY;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.juV = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.juS = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.jxA);
        this.juT = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.jxi);
        this.juU = new k(hotTopicActivity, n.jxD);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.juW = new g(pageContext, com.baidu.tieba.card.data.l.TYPE);
        this.juX = new a(pageContext, com.baidu.tieba.card.data.m.epH);
        this.juY = new i(pageContext, com.baidu.tieba.card.data.l.epL);
        this.bhH.add(this.juS);
        this.bhH.add(this.juT);
        this.bhH.add(this.juU);
        this.bhH.add(this.juV);
        this.bhH.add(this.juW);
        this.bhH.add(this.juX);
        this.bhH.add(this.juY);
        this.fSo = bdTypeListView;
        this.fSo.addAdapters(this.bhH);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cHw() != null) {
            arrayList = eVar.cHw();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.fSo != null) {
            this.fSo.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.juW != null) {
            this.juW.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fSo.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }
}
