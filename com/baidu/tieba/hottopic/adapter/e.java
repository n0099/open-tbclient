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
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private BdTypeListView frv;
    private j iIh;
    private h iIi;
    private k iIj;
    private f iIk;
    private g iIl;
    private a iIm;
    private i iIn;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.iIk = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.iIh = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.iKQ);
        this.iIi = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.iKy);
        this.iIj = new k(hotTopicActivity, n.iKT);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.iIl = new g(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.iIm = new a(pageContext, com.baidu.tieba.card.data.l.dRS);
        this.iIn = new i(pageContext, com.baidu.tieba.card.data.k.dRW);
        this.aWf.add(this.iIh);
        this.aWf.add(this.iIi);
        this.aWf.add(this.iIj);
        this.aWf.add(this.iIk);
        this.aWf.add(this.iIl);
        this.aWf.add(this.iIm);
        this.aWf.add(this.iIn);
        this.frv = bdTypeListView;
        this.frv.addAdapters(this.aWf);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cpm() != null) {
            arrayList = eVar.cpm();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.frv != null) {
            this.frv.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.iIl != null) {
            this.iIl.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.frv.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }
}
