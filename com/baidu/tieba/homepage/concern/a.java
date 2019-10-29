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
    private List<com.baidu.adp.widget.ListView.a> gdB = new ArrayList();
    private BdTypeRecyclerView gdC;
    private com.baidu.tieba.b.a gdD;
    private j gdE;
    private e gdF;
    private h gdG;
    private n gdH;
    private n gdI;
    private com.baidu.tieba.homepage.concern.a.a gdJ;
    private k gdK;
    private l gdL;
    private f gdM;
    private g gdN;
    private i gdO;
    private d gdP;
    private com.baidu.tieba.homepage.concern.a.c gdQ;
    private com.baidu.tieba.homepage.concern.a.b gdR;
    private m gdS;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gdC = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dt(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gdB);
    }

    private void dt(Context context) {
        this.gdL = new l(this.mPageContext, com.baidu.tieba.card.data.k.eQp);
        this.gdM = new f(this.mPageContext, com.baidu.tieba.card.data.k.eQu);
        this.gdN = new g(this.mPageContext, com.baidu.tieba.card.data.k.eQv);
        this.gdO = new i(this.mPageContext, com.baidu.tieba.card.data.k.eQw);
        this.gdP = new d(this.mPageContext, com.baidu.tieba.card.data.k.eQq);
        this.gdQ = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.eQs);
        this.gdR = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.eQt);
        this.gdS = new m(this.mPageContext, com.baidu.tieba.card.data.l.cbI);
        this.gdB.add(this.gdL);
        this.gdB.add(this.gdM);
        this.gdB.add(this.gdN);
        this.gdB.add(this.gdO);
        this.gdB.add(this.gdP);
        this.gdB.add(this.gdQ);
        this.gdB.add(this.gdR);
        this.gdB.add(this.gdS);
        this.gdD = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.cDN);
        this.gdG = new h(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gdH = new n(this.mPageContext, com.baidu.tieba.card.data.l.eQC);
        this.gdI = new n(this.mPageContext, com.baidu.tieba.card.data.l.eQD);
        this.gdE = new j(this.mPageContext.getContext());
        this.gdF = new e(this.mPageContext.getContext());
        this.gdJ = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gdK = new k(this.mPageContext, com.baidu.tieba.card.data.k.cbM);
        this.gdB.add(this.gdD);
        this.gdB.add(this.gdG);
        this.gdB.add(this.gdH);
        this.gdB.add(this.gdI);
        this.gdB.add(this.gdE);
        this.gdB.add(this.gdF);
        this.gdB.add(this.gdJ);
        this.gdB.add(this.gdK);
        rh("page_concern");
    }

    public void aY(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gdC.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gdC != null) {
            this.gdC.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gdJ.cKf = bdUniqueId;
        this.gdG.cKf = bdUniqueId;
        this.gdH.cKf = bdUniqueId;
        this.gdI.cKf = bdUniqueId;
        this.gdJ.cKf = bdUniqueId;
        this.gdK.cKf = bdUniqueId;
    }

    private void rh(String str) {
        if (this.gdB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gdB) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rh(str);
                }
            }
        }
    }

    private void b(r rVar) {
        this.gdL.b(rVar);
        this.gdM.b(rVar);
        this.gdN.b(rVar);
        this.gdO.b(rVar);
        this.gdP.b(rVar);
        this.gdQ.b(rVar);
        this.gdR.b(rVar);
        this.gdS.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
