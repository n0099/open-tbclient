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
    private List<com.baidu.adp.widget.ListView.a> fWA = new ArrayList();
    private BdTypeRecyclerView fWB;
    private com.baidu.tieba.b.a fWC;
    private j fWD;
    private e fWE;
    private h fWF;
    private n fWG;
    private n fWH;
    private com.baidu.tieba.homepage.concern.a.a fWI;
    private k fWJ;
    private l fWK;
    private f fWL;
    private g fWM;
    private i fWN;
    private d fWO;
    private com.baidu.tieba.homepage.concern.a.c fWP;
    private com.baidu.tieba.homepage.concern.a.b fWQ;
    private m fWR;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fWB = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dD(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.fWA);
    }

    private void dD(Context context) {
        this.fWK = new l(this.mPageContext, com.baidu.tieba.card.data.k.eAY);
        this.fWL = new f(this.mPageContext, com.baidu.tieba.card.data.k.eBd);
        this.fWM = new g(this.mPageContext, com.baidu.tieba.card.data.k.eBe);
        this.fWN = new i(this.mPageContext, com.baidu.tieba.card.data.k.eBf);
        this.fWO = new d(this.mPageContext, com.baidu.tieba.card.data.k.eAZ);
        this.fWP = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.eBb);
        this.fWQ = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.eBc);
        this.fWR = new m(this.mPageContext, com.baidu.tieba.card.data.l.bIx);
        this.fWA.add(this.fWK);
        this.fWA.add(this.fWL);
        this.fWA.add(this.fWM);
        this.fWA.add(this.fWN);
        this.fWA.add(this.fWO);
        this.fWA.add(this.fWP);
        this.fWA.add(this.fWQ);
        this.fWA.add(this.fWR);
        this.fWC = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.cpa);
        this.fWF = new h(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.fWG = new n(this.mPageContext, com.baidu.tieba.card.data.l.eBl);
        this.fWH = new n(this.mPageContext, com.baidu.tieba.card.data.l.eBm);
        this.fWD = new j(this.mPageContext.getContext());
        this.fWE = new e(this.mPageContext.getContext());
        this.fWI = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.fWJ = new k(this.mPageContext, com.baidu.tieba.card.data.k.bIB);
        this.fWA.add(this.fWC);
        this.fWA.add(this.fWF);
        this.fWA.add(this.fWG);
        this.fWA.add(this.fWH);
        this.fWA.add(this.fWD);
        this.fWA.add(this.fWE);
        this.fWA.add(this.fWI);
        this.fWA.add(this.fWJ);
        rU("page_concern");
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.fWB.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.fWB != null) {
            this.fWB.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fWI.cwi = bdUniqueId;
        this.fWF.cwi = bdUniqueId;
        this.fWG.cwi = bdUniqueId;
        this.fWH.cwi = bdUniqueId;
        this.fWI.cwi = bdUniqueId;
        this.fWJ.cwi = bdUniqueId;
    }

    private void rU(String str) {
        if (this.fWA != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fWA) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rU(str);
                }
            }
        }
    }

    private void b(r rVar) {
        this.fWK.b(rVar);
        this.fWL.b(rVar);
        this.fWM.b(rVar);
        this.fWN.b(rVar);
        this.fWO.b(rVar);
        this.fWP.b(rVar);
        this.fWQ.b(rVar);
        this.fWR.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
