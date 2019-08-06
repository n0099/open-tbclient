package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.a.f;
import com.baidu.tieba.homepage.concern.a.g;
import com.baidu.tieba.homepage.concern.a.h;
import com.baidu.tieba.homepage.concern.a.i;
import com.baidu.tieba.homepage.concern.a.j;
import com.baidu.tieba.homepage.concern.a.k;
import com.baidu.tieba.homepage.concern.a.l;
import com.baidu.tieba.homepage.concern.a.m;
import com.baidu.tieba.homepage.concern.a.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private i gcA;
    private d gcB;
    private com.baidu.tieba.homepage.concern.a.c gcC;
    private com.baidu.tieba.homepage.concern.a.b gcD;
    private m gcE;
    private List<com.baidu.adp.widget.ListView.a> gcn = new ArrayList();
    private BdTypeRecyclerView gco;
    private com.baidu.tieba.b.a gcp;
    private j gcq;
    private e gcr;
    private h gcs;
    private n gct;
    private n gcu;
    private com.baidu.tieba.homepage.concern.a.a gcv;
    private k gcw;
    private l gcx;
    private f gcy;
    private g gcz;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gco = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dF(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gcn);
    }

    private void dF(Context context) {
        this.gcx = new l(this.mPageContext, com.baidu.tieba.card.data.k.eGb);
        this.gcy = new f(this.mPageContext, com.baidu.tieba.card.data.k.eGg);
        this.gcz = new g(this.mPageContext, com.baidu.tieba.card.data.k.eGh);
        this.gcA = new i(this.mPageContext, com.baidu.tieba.card.data.k.eGi);
        this.gcB = new d(this.mPageContext, com.baidu.tieba.card.data.k.eGc);
        this.gcC = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.eGe);
        this.gcD = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.eGf);
        this.gcE = new m(this.mPageContext, com.baidu.tieba.card.data.l.bJC);
        this.gcn.add(this.gcx);
        this.gcn.add(this.gcy);
        this.gcn.add(this.gcz);
        this.gcn.add(this.gcA);
        this.gcn.add(this.gcB);
        this.gcn.add(this.gcC);
        this.gcn.add(this.gcD);
        this.gcn.add(this.gcE);
        this.gcp = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.cqu);
        this.gcs = new h(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gct = new n(this.mPageContext, com.baidu.tieba.card.data.l.eGo);
        this.gcu = new n(this.mPageContext, com.baidu.tieba.card.data.l.eGp);
        this.gcq = new j(this.mPageContext.getContext());
        this.gcr = new e(this.mPageContext.getContext());
        this.gcv = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gcw = new k(this.mPageContext, com.baidu.tieba.card.data.k.bJG);
        this.gcn.add(this.gcp);
        this.gcn.add(this.gcs);
        this.gcn.add(this.gct);
        this.gcn.add(this.gcu);
        this.gcn.add(this.gcq);
        this.gcn.add(this.gcr);
        this.gcn.add(this.gcv);
        this.gcn.add(this.gcw);
        sm("page_concern");
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gco.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gco != null) {
            this.gco.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gcv.cxE = bdUniqueId;
        this.gcs.cxE = bdUniqueId;
        this.gct.cxE = bdUniqueId;
        this.gcu.cxE = bdUniqueId;
        this.gcv.cxE = bdUniqueId;
        this.gcw.cxE = bdUniqueId;
    }

    private void sm(String str) {
        if (this.gcn != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gcn) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).sm(str);
                }
            }
        }
    }

    private void b(r rVar) {
        this.gcx.b(rVar);
        this.gcy.b(rVar);
        this.gcz.b(rVar);
        this.gcA.b(rVar);
        this.gcB.b(rVar);
        this.gcC.b(rVar);
        this.gcD.b(rVar);
        this.gcE.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
