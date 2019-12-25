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
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> gQO = new ArrayList();
    private BdTypeRecyclerView gQP;
    private q gQQ;
    private g gQR;
    private m gQS;
    private u gQT;
    private u gQU;
    private com.baidu.tieba.homepage.concern.a.a gQV;
    private r gQW;
    private s gQX;
    private p gQY;
    private f gQZ;
    private e gRa;
    private d gRb;
    private com.baidu.tieba.homepage.concern.a.c gRc;
    private t gRd;
    private h gRe;
    private i gRf;
    private n gRg;
    private com.baidu.tieba.homepage.personalize.a.c gRh;
    private j gRi;
    private com.baidu.tieba.homepage.concern.a.b gRj;
    private k gRk;
    private l gRl;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gQP = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eM(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gQO);
    }

    private void eM(Context context) {
        this.gQX = new s(this.mPageContext, com.baidu.tieba.card.data.k.fHq);
        this.gRe = new h(this.mPageContext, com.baidu.tieba.card.data.k.fHw);
        this.gRf = new i(this.mPageContext, com.baidu.tieba.card.data.k.fHy);
        this.gQY = new p(this.mPageContext, com.baidu.tieba.card.data.k.fHz);
        this.gQZ = new f(this.mPageContext, com.baidu.tieba.card.data.k.fHr);
        this.gRa = new e(this.mPageContext, com.baidu.tieba.card.data.k.fHt);
        this.gRb = new d(this.mPageContext, com.baidu.tieba.card.data.k.fHu);
        this.gRd = new t(this.mPageContext, com.baidu.tieba.card.data.l.cNl);
        this.gRh = new com.baidu.tieba.homepage.personalize.a.c(this.mPageContext, com.baidu.tieba.card.data.e.fGR);
        this.gRc = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.fHv);
        this.gRg = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.gSG);
        this.gRh.setFrom(1);
        this.gQO.add(this.gQX);
        this.gQO.add(this.gRe);
        this.gQO.add(this.gRf);
        this.gQO.add(this.gQY);
        this.gQO.add(this.gQZ);
        this.gQO.add(this.gRa);
        this.gQO.add(this.gRb);
        this.gQO.add(this.gRd);
        this.gQO.add(this.gRc);
        this.gQO.add(this.gRg);
        this.gQS = new m(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gQT = new u(this.mPageContext, com.baidu.tieba.card.data.l.fHG);
        this.gQU = new u(this.mPageContext, com.baidu.tieba.card.data.l.fHH);
        this.gQQ = new q(this.mPageContext.getContext());
        this.gQR = new g(this.mPageContext.getContext());
        this.gQV = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gQW = new r(this.mPageContext, com.baidu.tieba.card.data.k.cNp);
        this.gRi = new j(this.mPageContext, com.baidu.tieba.card.data.k.cNq);
        this.gRj = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.cNr);
        this.gRk = new k(this.mPageContext, com.baidu.tieba.card.data.k.cNs);
        this.gRl = new l(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.gSF);
        this.gQO.add(this.gQS);
        this.gQO.add(this.gQT);
        this.gQO.add(this.gQU);
        this.gQO.add(this.gQQ);
        this.gQO.add(this.gQR);
        this.gQO.add(this.gQV);
        this.gQO.add(this.gQW);
        this.gQO.add(this.gRi);
        this.gQO.add(this.gRj);
        this.gQO.add(this.gRk);
        this.gQO.add(this.gRh);
        this.gQO.add(this.gRl);
        wq("page_concern");
    }

    public void ad(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gQP.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gQP != null) {
            this.gQP.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gQV.dwY = bdUniqueId;
        this.gQS.dwY = bdUniqueId;
        this.gQT.dwY = bdUniqueId;
        this.gQU.dwY = bdUniqueId;
        this.gQV.dwY = bdUniqueId;
        this.gQW.dwY = bdUniqueId;
        this.gRk.dwY = bdUniqueId;
        this.gRi.dwY = bdUniqueId;
        this.gRj.dwY = bdUniqueId;
        this.gRh.dwY = bdUniqueId;
        this.gRc.dwY = bdUniqueId;
        this.gRg.dwY = bdUniqueId;
    }

    private void wq(String str) {
        if (this.gQO != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gQO) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wq(str);
                }
            }
        }
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gQX.b(rVar);
        this.gRe.b(rVar);
        this.gRf.b(rVar);
        this.gQY.b(rVar);
        this.gRg.b(rVar);
        this.gQZ.b(rVar);
        this.gRa.b(rVar);
        this.gRb.b(rVar);
        this.gRd.b(rVar);
        this.gRc.b(rVar);
        this.gRh.b(rVar);
        this.gRj.b(rVar);
        this.gRi.b(rVar);
        this.gRk.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
