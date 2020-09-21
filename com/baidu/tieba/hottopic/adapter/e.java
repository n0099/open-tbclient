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
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private BdTypeListView fGf;
    private j jfT;
    private h jfU;
    private k jfV;
    private f jfW;
    private g jfX;
    private a jfY;
    private i jfZ;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.jfW = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.jfT = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.jiC);
        this.jfU = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.jik);
        this.jfV = new k(hotTopicActivity, n.jiF);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.jfX = new g(pageContext, com.baidu.tieba.card.data.l.TYPE);
        this.jfY = new a(pageContext, com.baidu.tieba.card.data.m.edC);
        this.jfZ = new i(pageContext, com.baidu.tieba.card.data.l.edG);
        this.bdV.add(this.jfT);
        this.bdV.add(this.jfU);
        this.bdV.add(this.jfV);
        this.bdV.add(this.jfW);
        this.bdV.add(this.jfX);
        this.bdV.add(this.jfY);
        this.bdV.add(this.jfZ);
        this.fGf = bdTypeListView;
        this.fGf.addAdapters(this.bdV);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cDN() != null) {
            arrayList = eVar.cDN();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.fGf != null) {
            this.fGf.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jfX != null) {
            this.jfX.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fGf.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }
}
