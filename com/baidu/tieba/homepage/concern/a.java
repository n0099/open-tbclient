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
    private List<com.baidu.adp.widget.ListView.a> gXE = new ArrayList();
    private BdTypeRecyclerView gXF;
    private q gXG;
    private g gXH;
    private m gXI;
    private u gXJ;
    private u gXK;
    private com.baidu.tieba.homepage.concern.a.a gXL;
    private r gXM;
    private s gXN;
    private p gXO;
    private f gXP;
    private e gXQ;
    private d gXR;
    private com.baidu.tieba.homepage.concern.a.c gXS;
    private t gXT;
    private h gXU;
    private i gXV;
    private n gXW;
    private com.baidu.tieba.homepage.personalize.a.e gXX;
    private j gXY;
    private com.baidu.tieba.homepage.concern.a.b gXZ;
    private k gYa;
    private l gYb;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gXF = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eO(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gXE);
    }

    private void eO(Context context) {
        this.gXN = new s(this.mPageContext, com.baidu.tieba.card.data.k.fNT);
        this.gXU = new h(this.mPageContext, com.baidu.tieba.card.data.k.fNZ);
        this.gXV = new i(this.mPageContext, com.baidu.tieba.card.data.k.fOb);
        this.gXO = new p(this.mPageContext, com.baidu.tieba.card.data.k.fOc);
        this.gXP = new f(this.mPageContext, com.baidu.tieba.card.data.k.fNU);
        this.gXQ = new e(this.mPageContext, com.baidu.tieba.card.data.k.fNW);
        this.gXR = new d(this.mPageContext, com.baidu.tieba.card.data.k.fNX);
        this.gXT = new t(this.mPageContext, com.baidu.tieba.card.data.l.cRN);
        this.gXX = new com.baidu.tieba.homepage.personalize.a.e(this.mPageContext, com.baidu.tieba.card.data.e.fNu);
        this.gXS = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.fNY);
        this.gXW = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.gZw);
        this.gXX.setFrom(1);
        this.gXE.add(this.gXN);
        this.gXE.add(this.gXU);
        this.gXE.add(this.gXV);
        this.gXE.add(this.gXO);
        this.gXE.add(this.gXP);
        this.gXE.add(this.gXQ);
        this.gXE.add(this.gXR);
        this.gXE.add(this.gXT);
        this.gXE.add(this.gXS);
        this.gXE.add(this.gXW);
        this.gXI = new m(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gXJ = new u(this.mPageContext, com.baidu.tieba.card.data.l.fOj);
        this.gXK = new u(this.mPageContext, com.baidu.tieba.card.data.l.fOk);
        this.gXG = new q(this.mPageContext.getContext());
        this.gXH = new g(this.mPageContext.getContext());
        this.gXL = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gXM = new r(this.mPageContext, com.baidu.tieba.card.data.k.cRR);
        this.gXY = new j(this.mPageContext, com.baidu.tieba.card.data.k.cRS);
        this.gXZ = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.cRT);
        this.gYa = new k(this.mPageContext, com.baidu.tieba.card.data.k.cRU);
        this.gYb = new l(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.gZv);
        this.gXE.add(this.gXI);
        this.gXE.add(this.gXJ);
        this.gXE.add(this.gXK);
        this.gXE.add(this.gXG);
        this.gXE.add(this.gXH);
        this.gXE.add(this.gXL);
        this.gXE.add(this.gXM);
        this.gXE.add(this.gXY);
        this.gXE.add(this.gXZ);
        this.gXE.add(this.gYa);
        this.gXE.add(this.gXX);
        this.gXE.add(this.gYb);
        wP("page_concern");
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gXF.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gXF != null) {
            this.gXF.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gXL.dBK = bdUniqueId;
        this.gXI.dBK = bdUniqueId;
        this.gXJ.dBK = bdUniqueId;
        this.gXK.dBK = bdUniqueId;
        this.gXL.dBK = bdUniqueId;
        this.gXM.dBK = bdUniqueId;
        this.gYa.dBK = bdUniqueId;
        this.gXY.dBK = bdUniqueId;
        this.gXZ.dBK = bdUniqueId;
        this.gXX.dBK = bdUniqueId;
        this.gXS.dBK = bdUniqueId;
        this.gXW.dBK = bdUniqueId;
    }

    private void wP(String str) {
        if (this.gXE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gXE) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wP(str);
                }
            }
        }
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gXN.b(rVar);
        this.gXU.b(rVar);
        this.gXV.b(rVar);
        this.gXO.b(rVar);
        this.gXW.b(rVar);
        this.gXP.b(rVar);
        this.gXQ.b(rVar);
        this.gXR.b(rVar);
        this.gXT.b(rVar);
        this.gXS.b(rVar);
        this.gXX.b(rVar);
        this.gXZ.b(rVar);
        this.gXY.b(rVar);
        this.gYa.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
