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
    private j fWA;
    private e fWB;
    private h fWC;
    private n fWD;
    private n fWE;
    private com.baidu.tieba.homepage.concern.a.a fWF;
    private k fWG;
    private l fWH;
    private f fWI;
    private g fWJ;
    private i fWK;
    private d fWL;
    private com.baidu.tieba.homepage.concern.a.c fWM;
    private com.baidu.tieba.homepage.concern.a.b fWN;
    private m fWO;
    private List<com.baidu.adp.widget.ListView.a> fWx = new ArrayList();
    private BdTypeRecyclerView fWy;
    private com.baidu.tieba.b.a fWz;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fWy = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dD(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.fWx);
    }

    private void dD(Context context) {
        this.fWH = new l(this.mPageContext, com.baidu.tieba.card.data.k.eAX);
        this.fWI = new f(this.mPageContext, com.baidu.tieba.card.data.k.eBc);
        this.fWJ = new g(this.mPageContext, com.baidu.tieba.card.data.k.eBd);
        this.fWK = new i(this.mPageContext, com.baidu.tieba.card.data.k.eBe);
        this.fWL = new d(this.mPageContext, com.baidu.tieba.card.data.k.eAY);
        this.fWM = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.eBa);
        this.fWN = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.eBb);
        this.fWO = new m(this.mPageContext, com.baidu.tieba.card.data.l.bIw);
        this.fWx.add(this.fWH);
        this.fWx.add(this.fWI);
        this.fWx.add(this.fWJ);
        this.fWx.add(this.fWK);
        this.fWx.add(this.fWL);
        this.fWx.add(this.fWM);
        this.fWx.add(this.fWN);
        this.fWx.add(this.fWO);
        this.fWz = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.coZ);
        this.fWC = new h(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.fWD = new n(this.mPageContext, com.baidu.tieba.card.data.l.eBk);
        this.fWE = new n(this.mPageContext, com.baidu.tieba.card.data.l.eBl);
        this.fWA = new j(this.mPageContext.getContext());
        this.fWB = new e(this.mPageContext.getContext());
        this.fWF = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.fWG = new k(this.mPageContext, com.baidu.tieba.card.data.k.bIA);
        this.fWx.add(this.fWz);
        this.fWx.add(this.fWC);
        this.fWx.add(this.fWD);
        this.fWx.add(this.fWE);
        this.fWx.add(this.fWA);
        this.fWx.add(this.fWB);
        this.fWx.add(this.fWF);
        this.fWx.add(this.fWG);
        rV("page_concern");
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.fWy.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.fWy != null) {
            this.fWy.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fWF.cwh = bdUniqueId;
        this.fWC.cwh = bdUniqueId;
        this.fWD.cwh = bdUniqueId;
        this.fWE.cwh = bdUniqueId;
        this.fWF.cwh = bdUniqueId;
        this.fWG.cwh = bdUniqueId;
    }

    private void rV(String str) {
        if (this.fWx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fWx) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rV(str);
                }
            }
        }
    }

    private void b(r rVar) {
        this.fWH.b(rVar);
        this.fWI.b(rVar);
        this.fWJ.b(rVar);
        this.fWK.b(rVar);
        this.fWL.b(rVar);
        this.fWM.b(rVar);
        this.fWN.b(rVar);
        this.fWO.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
