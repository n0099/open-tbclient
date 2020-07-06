package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private BdTypeListView fml;
    private j iCd;
    private h iCe;
    private k iCf;
    private f iCg;
    private g iCh;
    private a iCi;
    private i iCj;

    public e(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.iCg = new f(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.iCd = new j(hotTopicActivity, com.baidu.tieba.hottopic.data.m.iEM);
        this.iCe = new h(hotTopicActivity, com.baidu.tieba.hottopic.data.i.iEu);
        this.iCf = new k(hotTopicActivity, n.iEP);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.iCh = new g(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.iCi = new a(pageContext, com.baidu.tieba.card.data.l.dLH);
        this.iCj = new i(pageContext, com.baidu.tieba.card.data.k.dLL);
        this.aUP.add(this.iCd);
        this.aUP.add(this.iCe);
        this.aUP.add(this.iCf);
        this.aUP.add(this.iCg);
        this.aUP.add(this.iCh);
        this.aUP.add(this.iCi);
        this.aUP.add(this.iCj);
        this.fml = bdTypeListView;
        this.fml.addAdapters(this.aUP);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<q> arrayList;
        if (eVar.clM() != null) {
            arrayList = eVar.clM();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.fml != null) {
            this.fml.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.iCh != null) {
            this.iCh.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.fml.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }
}
