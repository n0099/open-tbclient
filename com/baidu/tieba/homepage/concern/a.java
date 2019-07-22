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
    private j gbA;
    private e gbB;
    private h gbC;
    private n gbD;
    private n gbE;
    private com.baidu.tieba.homepage.concern.a.a gbF;
    private k gbG;
    private l gbH;
    private f gbI;
    private g gbJ;
    private i gbK;
    private d gbL;
    private com.baidu.tieba.homepage.concern.a.c gbM;
    private com.baidu.tieba.homepage.concern.a.b gbN;
    private m gbO;
    private List<com.baidu.adp.widget.ListView.a> gbx = new ArrayList();
    private BdTypeRecyclerView gby;
    private com.baidu.tieba.b.a gbz;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gby = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dE(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gbx);
    }

    private void dE(Context context) {
        this.gbH = new l(this.mPageContext, com.baidu.tieba.card.data.k.eFU);
        this.gbI = new f(this.mPageContext, com.baidu.tieba.card.data.k.eFZ);
        this.gbJ = new g(this.mPageContext, com.baidu.tieba.card.data.k.eGa);
        this.gbK = new i(this.mPageContext, com.baidu.tieba.card.data.k.eGb);
        this.gbL = new d(this.mPageContext, com.baidu.tieba.card.data.k.eFV);
        this.gbM = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.eFX);
        this.gbN = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.eFY);
        this.gbO = new m(this.mPageContext, com.baidu.tieba.card.data.l.bJx);
        this.gbx.add(this.gbH);
        this.gbx.add(this.gbI);
        this.gbx.add(this.gbJ);
        this.gbx.add(this.gbK);
        this.gbx.add(this.gbL);
        this.gbx.add(this.gbM);
        this.gbx.add(this.gbN);
        this.gbx.add(this.gbO);
        this.gbz = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.cqn);
        this.gbC = new h(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gbD = new n(this.mPageContext, com.baidu.tieba.card.data.l.eGh);
        this.gbE = new n(this.mPageContext, com.baidu.tieba.card.data.l.eGi);
        this.gbA = new j(this.mPageContext.getContext());
        this.gbB = new e(this.mPageContext.getContext());
        this.gbF = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gbG = new k(this.mPageContext, com.baidu.tieba.card.data.k.bJB);
        this.gbx.add(this.gbz);
        this.gbx.add(this.gbC);
        this.gbx.add(this.gbD);
        this.gbx.add(this.gbE);
        this.gbx.add(this.gbA);
        this.gbx.add(this.gbB);
        this.gbx.add(this.gbF);
        this.gbx.add(this.gbG);
        sm("page_concern");
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gby.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gby != null) {
            this.gby.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gbF.cxx = bdUniqueId;
        this.gbC.cxx = bdUniqueId;
        this.gbD.cxx = bdUniqueId;
        this.gbE.cxx = bdUniqueId;
        this.gbF.cxx = bdUniqueId;
        this.gbG.cxx = bdUniqueId;
    }

    private void sm(String str) {
        if (this.gbx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gbx) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).sm(str);
                }
            }
        }
    }

    private void b(r rVar) {
        this.gbH.b(rVar);
        this.gbI.b(rVar);
        this.gbJ.b(rVar);
        this.gbK.b(rVar);
        this.gbL.b(rVar);
        this.gbM.b(rVar);
        this.gbN.b(rVar);
        this.gbO.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
