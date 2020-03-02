package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
import com.baidu.tieba.homepage.concern.a.p;
import com.baidu.tieba.homepage.concern.a.q;
import com.baidu.tieba.homepage.concern.a.r;
import com.baidu.tieba.homepage.concern.a.s;
import com.baidu.tieba.homepage.concern.a.t;
import com.baidu.tieba.homepage.concern.a.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private t gWA;
    private h gWB;
    private i gWC;
    private n gWD;
    private com.baidu.tieba.homepage.personalize.a.c gWE;
    private j gWF;
    private com.baidu.tieba.homepage.concern.a.b gWG;
    private k gWH;
    private l gWI;
    private List<com.baidu.adp.widget.ListView.a> gWl = new ArrayList();
    private BdTypeRecyclerView gWm;
    private q gWn;
    private g gWo;
    private m gWp;
    private u gWq;
    private u gWr;
    private com.baidu.tieba.homepage.concern.a.a gWs;
    private r gWt;
    private s gWu;
    private p gWv;
    private f gWw;
    private e gWx;
    private d gWy;
    private com.baidu.tieba.homepage.concern.a.c gWz;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gWm = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eP(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gWl);
    }

    private void eP(Context context) {
        this.gWu = new s(this.mPageContext, com.baidu.tieba.card.data.k.fMY);
        this.gWB = new h(this.mPageContext, com.baidu.tieba.card.data.k.fNe);
        this.gWC = new i(this.mPageContext, com.baidu.tieba.card.data.k.fNg);
        this.gWv = new p(this.mPageContext, com.baidu.tieba.card.data.k.fNh);
        this.gWw = new f(this.mPageContext, com.baidu.tieba.card.data.k.fMZ);
        this.gWx = new e(this.mPageContext, com.baidu.tieba.card.data.k.fNb);
        this.gWy = new d(this.mPageContext, com.baidu.tieba.card.data.k.fNc);
        this.gWA = new t(this.mPageContext, com.baidu.tieba.card.data.l.cRz);
        this.gWE = new com.baidu.tieba.homepage.personalize.a.c(this.mPageContext, com.baidu.tieba.card.data.e.fMz);
        this.gWz = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.fNd);
        this.gWD = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.gYd);
        this.gWE.setFrom(1);
        this.gWl.add(this.gWu);
        this.gWl.add(this.gWB);
        this.gWl.add(this.gWC);
        this.gWl.add(this.gWv);
        this.gWl.add(this.gWw);
        this.gWl.add(this.gWx);
        this.gWl.add(this.gWy);
        this.gWl.add(this.gWA);
        this.gWl.add(this.gWz);
        this.gWl.add(this.gWD);
        this.gWp = new m(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gWq = new u(this.mPageContext, com.baidu.tieba.card.data.l.fNo);
        this.gWr = new u(this.mPageContext, com.baidu.tieba.card.data.l.fNp);
        this.gWn = new q(this.mPageContext.getContext());
        this.gWo = new g(this.mPageContext.getContext());
        this.gWs = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gWt = new r(this.mPageContext, com.baidu.tieba.card.data.k.cRD);
        this.gWF = new j(this.mPageContext, com.baidu.tieba.card.data.k.cRE);
        this.gWG = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.cRF);
        this.gWH = new k(this.mPageContext, com.baidu.tieba.card.data.k.cRG);
        this.gWI = new l(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.gYc);
        this.gWl.add(this.gWp);
        this.gWl.add(this.gWq);
        this.gWl.add(this.gWr);
        this.gWl.add(this.gWn);
        this.gWl.add(this.gWo);
        this.gWl.add(this.gWs);
        this.gWl.add(this.gWt);
        this.gWl.add(this.gWF);
        this.gWl.add(this.gWG);
        this.gWl.add(this.gWH);
        this.gWl.add(this.gWE);
        this.gWl.add(this.gWI);
        wO("page_concern");
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gWm.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gWm != null) {
            this.gWm.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gWs.dBk = bdUniqueId;
        this.gWp.dBk = bdUniqueId;
        this.gWq.dBk = bdUniqueId;
        this.gWr.dBk = bdUniqueId;
        this.gWs.dBk = bdUniqueId;
        this.gWt.dBk = bdUniqueId;
        this.gWH.dBk = bdUniqueId;
        this.gWF.dBk = bdUniqueId;
        this.gWG.dBk = bdUniqueId;
        this.gWE.dBk = bdUniqueId;
        this.gWz.dBk = bdUniqueId;
        this.gWD.dBk = bdUniqueId;
    }

    private void wO(String str) {
        if (this.gWl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gWl) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wO(str);
                }
            }
        }
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gWu.b(rVar);
        this.gWB.b(rVar);
        this.gWC.b(rVar);
        this.gWv.b(rVar);
        this.gWD.b(rVar);
        this.gWw.b(rVar);
        this.gWx.b(rVar);
        this.gWy.b(rVar);
        this.gWA.b(rVar);
        this.gWz.b(rVar);
        this.gWE.b(rVar);
        this.gWG.b(rVar);
        this.gWF.b(rVar);
        this.gWH.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
