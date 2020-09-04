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
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private BdTypeListView fCT;
    private j iXn;
    private h iXo;
    private k iXp;
    private f iXq;
    private g iXr;
    private a iXs;
    private i iXt;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.iXq = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.iXn = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.iZW);
        this.iXo = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.iZE);
        this.iXp = new k(hotTopicActivity, n.iZZ);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.iXr = new g(pageContext, com.baidu.tieba.card.data.l.TYPE);
        this.iXs = new a(pageContext, com.baidu.tieba.card.data.m.ebs);
        this.iXt = new i(pageContext, com.baidu.tieba.card.data.l.ebw);
        this.bbw.add(this.iXn);
        this.bbw.add(this.iXo);
        this.bbw.add(this.iXp);
        this.bbw.add(this.iXq);
        this.bbw.add(this.iXr);
        this.bbw.add(this.iXs);
        this.bbw.add(this.iXt);
        this.fCT = bdTypeListView;
        this.fCT.addAdapters(this.bbw);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cAg() != null) {
            arrayList = eVar.cAg();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.fCT != null) {
            this.fCT.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.iXr != null) {
            this.iXr.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCT.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }
}
