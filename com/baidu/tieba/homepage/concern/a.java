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
    private com.baidu.tieba.b.a fWA;
    private j fWB;
    private e fWC;
    private h fWD;
    private n fWE;
    private n fWF;
    private com.baidu.tieba.homepage.concern.a.a fWG;
    private k fWH;
    private l fWI;
    private f fWJ;
    private g fWK;
    private i fWL;
    private d fWM;
    private com.baidu.tieba.homepage.concern.a.c fWN;
    private com.baidu.tieba.homepage.concern.a.b fWO;
    private m fWP;
    private List<com.baidu.adp.widget.ListView.a> fWy = new ArrayList();
    private BdTypeRecyclerView fWz;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fWz = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dD(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.fWy);
    }

    private void dD(Context context) {
        this.fWI = new l(this.mPageContext, com.baidu.tieba.card.data.k.eAY);
        this.fWJ = new f(this.mPageContext, com.baidu.tieba.card.data.k.eBd);
        this.fWK = new g(this.mPageContext, com.baidu.tieba.card.data.k.eBe);
        this.fWL = new i(this.mPageContext, com.baidu.tieba.card.data.k.eBf);
        this.fWM = new d(this.mPageContext, com.baidu.tieba.card.data.k.eAZ);
        this.fWN = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.eBb);
        this.fWO = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.eBc);
        this.fWP = new m(this.mPageContext, com.baidu.tieba.card.data.l.bIw);
        this.fWy.add(this.fWI);
        this.fWy.add(this.fWJ);
        this.fWy.add(this.fWK);
        this.fWy.add(this.fWL);
        this.fWy.add(this.fWM);
        this.fWy.add(this.fWN);
        this.fWy.add(this.fWO);
        this.fWy.add(this.fWP);
        this.fWA = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.coZ);
        this.fWD = new h(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.fWE = new n(this.mPageContext, com.baidu.tieba.card.data.l.eBl);
        this.fWF = new n(this.mPageContext, com.baidu.tieba.card.data.l.eBm);
        this.fWB = new j(this.mPageContext.getContext());
        this.fWC = new e(this.mPageContext.getContext());
        this.fWG = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.fWH = new k(this.mPageContext, com.baidu.tieba.card.data.k.bIA);
        this.fWy.add(this.fWA);
        this.fWy.add(this.fWD);
        this.fWy.add(this.fWE);
        this.fWy.add(this.fWF);
        this.fWy.add(this.fWB);
        this.fWy.add(this.fWC);
        this.fWy.add(this.fWG);
        this.fWy.add(this.fWH);
        rV("page_concern");
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.fWz.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.fWz != null) {
            this.fWz.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fWG.cwh = bdUniqueId;
        this.fWD.cwh = bdUniqueId;
        this.fWE.cwh = bdUniqueId;
        this.fWF.cwh = bdUniqueId;
        this.fWG.cwh = bdUniqueId;
        this.fWH.cwh = bdUniqueId;
    }

    private void rV(String str) {
        if (this.fWy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fWy) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rV(str);
                }
            }
        }
    }

    private void b(r rVar) {
        this.fWI.b(rVar);
        this.fWJ.b(rVar);
        this.fWK.b(rVar);
        this.fWL.b(rVar);
        this.fWM.b(rVar);
        this.fWN.b(rVar);
        this.fWO.b(rVar);
        this.fWP.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
