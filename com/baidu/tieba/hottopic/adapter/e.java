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
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private BdTypeListView gih;
    private j jNp;
    private h jNq;
    private k jNr;
    private f jNs;
    private g jNt;
    private a jNu;
    private i jNv;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.jNs = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.jNp = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.jPX);
        this.jNq = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.jPF);
        this.jNr = new k(hotTopicActivity, n.jQa);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.jNt = new g(pageContext, com.baidu.tieba.card.data.l.TYPE);
        this.jNu = new a(pageContext, com.baidu.tieba.card.data.m.eDW);
        this.jNv = new i(pageContext, com.baidu.tieba.card.data.l.eEb);
        this.bky.add(this.jNp);
        this.bky.add(this.jNq);
        this.bky.add(this.jNr);
        this.bky.add(this.jNs);
        this.bky.add(this.jNt);
        this.bky.add(this.jNu);
        this.bky.add(this.jNv);
        this.gih = bdTypeListView;
        this.gih.addAdapters(this.bky);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.cNe() != null) {
            arrayList = eVar.cNe();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.gih != null) {
            this.gih.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jNt != null) {
            this.jNt.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gih.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }
}
