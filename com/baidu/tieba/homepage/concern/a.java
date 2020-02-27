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
    private i gWA;
    private n gWB;
    private com.baidu.tieba.homepage.personalize.a.c gWC;
    private j gWD;
    private com.baidu.tieba.homepage.concern.a.b gWE;
    private k gWF;
    private l gWG;
    private List<com.baidu.adp.widget.ListView.a> gWj = new ArrayList();
    private BdTypeRecyclerView gWk;
    private q gWl;
    private g gWm;
    private m gWn;
    private u gWo;
    private u gWp;
    private com.baidu.tieba.homepage.concern.a.a gWq;
    private r gWr;
    private s gWs;
    private p gWt;
    private f gWu;
    private e gWv;
    private d gWw;
    private com.baidu.tieba.homepage.concern.a.c gWx;
    private t gWy;
    private h gWz;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gWk = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eP(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gWj);
    }

    private void eP(Context context) {
        this.gWs = new s(this.mPageContext, com.baidu.tieba.card.data.k.fMW);
        this.gWz = new h(this.mPageContext, com.baidu.tieba.card.data.k.fNc);
        this.gWA = new i(this.mPageContext, com.baidu.tieba.card.data.k.fNe);
        this.gWt = new p(this.mPageContext, com.baidu.tieba.card.data.k.fNf);
        this.gWu = new f(this.mPageContext, com.baidu.tieba.card.data.k.fMX);
        this.gWv = new e(this.mPageContext, com.baidu.tieba.card.data.k.fMZ);
        this.gWw = new d(this.mPageContext, com.baidu.tieba.card.data.k.fNa);
        this.gWy = new t(this.mPageContext, com.baidu.tieba.card.data.l.cRy);
        this.gWC = new com.baidu.tieba.homepage.personalize.a.c(this.mPageContext, com.baidu.tieba.card.data.e.fMx);
        this.gWx = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.fNb);
        this.gWB = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.gYb);
        this.gWC.setFrom(1);
        this.gWj.add(this.gWs);
        this.gWj.add(this.gWz);
        this.gWj.add(this.gWA);
        this.gWj.add(this.gWt);
        this.gWj.add(this.gWu);
        this.gWj.add(this.gWv);
        this.gWj.add(this.gWw);
        this.gWj.add(this.gWy);
        this.gWj.add(this.gWx);
        this.gWj.add(this.gWB);
        this.gWn = new m(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gWo = new u(this.mPageContext, com.baidu.tieba.card.data.l.fNm);
        this.gWp = new u(this.mPageContext, com.baidu.tieba.card.data.l.fNn);
        this.gWl = new q(this.mPageContext.getContext());
        this.gWm = new g(this.mPageContext.getContext());
        this.gWq = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gWr = new r(this.mPageContext, com.baidu.tieba.card.data.k.cRC);
        this.gWD = new j(this.mPageContext, com.baidu.tieba.card.data.k.cRD);
        this.gWE = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.cRE);
        this.gWF = new k(this.mPageContext, com.baidu.tieba.card.data.k.cRF);
        this.gWG = new l(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.gYa);
        this.gWj.add(this.gWn);
        this.gWj.add(this.gWo);
        this.gWj.add(this.gWp);
        this.gWj.add(this.gWl);
        this.gWj.add(this.gWm);
        this.gWj.add(this.gWq);
        this.gWj.add(this.gWr);
        this.gWj.add(this.gWD);
        this.gWj.add(this.gWE);
        this.gWj.add(this.gWF);
        this.gWj.add(this.gWC);
        this.gWj.add(this.gWG);
        wO("page_concern");
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gWk.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gWk != null) {
            this.gWk.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gWq.dBj = bdUniqueId;
        this.gWn.dBj = bdUniqueId;
        this.gWo.dBj = bdUniqueId;
        this.gWp.dBj = bdUniqueId;
        this.gWq.dBj = bdUniqueId;
        this.gWr.dBj = bdUniqueId;
        this.gWF.dBj = bdUniqueId;
        this.gWD.dBj = bdUniqueId;
        this.gWE.dBj = bdUniqueId;
        this.gWC.dBj = bdUniqueId;
        this.gWx.dBj = bdUniqueId;
        this.gWB.dBj = bdUniqueId;
    }

    private void wO(String str) {
        if (this.gWj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gWj) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wO(str);
                }
            }
        }
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gWs.b(rVar);
        this.gWz.b(rVar);
        this.gWA.b(rVar);
        this.gWt.b(rVar);
        this.gWB.b(rVar);
        this.gWu.b(rVar);
        this.gWv.b(rVar);
        this.gWw.b(rVar);
        this.gWy.b(rVar);
        this.gWx.b(rVar);
        this.gWC.b(rVar);
        this.gWE.b(rVar);
        this.gWD.b(rVar);
        this.gWF.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
