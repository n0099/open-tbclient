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
    private g gWA;
    private m gWB;
    private u gWC;
    private u gWD;
    private com.baidu.tieba.homepage.concern.a.a gWE;
    private r gWF;
    private s gWG;
    private p gWH;
    private f gWI;
    private e gWJ;
    private d gWK;
    private com.baidu.tieba.homepage.concern.a.c gWL;
    private t gWM;
    private h gWN;
    private i gWO;
    private n gWP;
    private com.baidu.tieba.homepage.personalize.a.c gWQ;
    private j gWR;
    private com.baidu.tieba.homepage.concern.a.b gWS;
    private k gWT;
    private l gWU;
    private List<com.baidu.adp.widget.ListView.a> gWx = new ArrayList();
    private BdTypeRecyclerView gWy;
    private q gWz;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gWy = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eP(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gWx);
    }

    private void eP(Context context) {
        this.gWG = new s(this.mPageContext, com.baidu.tieba.card.data.k.fNl);
        this.gWN = new h(this.mPageContext, com.baidu.tieba.card.data.k.fNr);
        this.gWO = new i(this.mPageContext, com.baidu.tieba.card.data.k.fNt);
        this.gWH = new p(this.mPageContext, com.baidu.tieba.card.data.k.fNu);
        this.gWI = new f(this.mPageContext, com.baidu.tieba.card.data.k.fNm);
        this.gWJ = new e(this.mPageContext, com.baidu.tieba.card.data.k.fNo);
        this.gWK = new d(this.mPageContext, com.baidu.tieba.card.data.k.fNp);
        this.gWM = new t(this.mPageContext, com.baidu.tieba.card.data.l.cRA);
        this.gWQ = new com.baidu.tieba.homepage.personalize.a.c(this.mPageContext, com.baidu.tieba.card.data.e.fMM);
        this.gWL = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.fNq);
        this.gWP = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.gYp);
        this.gWQ.setFrom(1);
        this.gWx.add(this.gWG);
        this.gWx.add(this.gWN);
        this.gWx.add(this.gWO);
        this.gWx.add(this.gWH);
        this.gWx.add(this.gWI);
        this.gWx.add(this.gWJ);
        this.gWx.add(this.gWK);
        this.gWx.add(this.gWM);
        this.gWx.add(this.gWL);
        this.gWx.add(this.gWP);
        this.gWB = new m(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gWC = new u(this.mPageContext, com.baidu.tieba.card.data.l.fNB);
        this.gWD = new u(this.mPageContext, com.baidu.tieba.card.data.l.fNC);
        this.gWz = new q(this.mPageContext.getContext());
        this.gWA = new g(this.mPageContext.getContext());
        this.gWE = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gWF = new r(this.mPageContext, com.baidu.tieba.card.data.k.cRE);
        this.gWR = new j(this.mPageContext, com.baidu.tieba.card.data.k.cRF);
        this.gWS = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.cRG);
        this.gWT = new k(this.mPageContext, com.baidu.tieba.card.data.k.cRH);
        this.gWU = new l(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.gYo);
        this.gWx.add(this.gWB);
        this.gWx.add(this.gWC);
        this.gWx.add(this.gWD);
        this.gWx.add(this.gWz);
        this.gWx.add(this.gWA);
        this.gWx.add(this.gWE);
        this.gWx.add(this.gWF);
        this.gWx.add(this.gWR);
        this.gWx.add(this.gWS);
        this.gWx.add(this.gWT);
        this.gWx.add(this.gWQ);
        this.gWx.add(this.gWU);
        wP("page_concern");
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gWy.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gWy != null) {
            this.gWy.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gWE.dBx = bdUniqueId;
        this.gWB.dBx = bdUniqueId;
        this.gWC.dBx = bdUniqueId;
        this.gWD.dBx = bdUniqueId;
        this.gWE.dBx = bdUniqueId;
        this.gWF.dBx = bdUniqueId;
        this.gWT.dBx = bdUniqueId;
        this.gWR.dBx = bdUniqueId;
        this.gWS.dBx = bdUniqueId;
        this.gWQ.dBx = bdUniqueId;
        this.gWL.dBx = bdUniqueId;
        this.gWP.dBx = bdUniqueId;
    }

    private void wP(String str) {
        if (this.gWx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gWx) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wP(str);
                }
            }
        }
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gWG.b(rVar);
        this.gWN.b(rVar);
        this.gWO.b(rVar);
        this.gWH.b(rVar);
        this.gWP.b(rVar);
        this.gWI.b(rVar);
        this.gWJ.b(rVar);
        this.gWK.b(rVar);
        this.gWM.b(rVar);
        this.gWL.b(rVar);
        this.gWQ.b(rVar);
        this.gWS.b(rVar);
        this.gWR.b(rVar);
        this.gWT.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
