package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private t hWA;
    private i hWB;
    private j hWC;
    private n hWD;
    private com.baidu.tieba.homepage.concern.a.b hWE;
    private k hWF;
    private com.baidu.tieba.homepage.concern.a.c hWG;
    private l hWH;
    private m hWI;
    private List<com.baidu.adp.widget.ListView.a> hWo = new ArrayList();
    private BdTypeRecyclerView hWp;
    private q hWq;
    private h hWr;
    private com.baidu.tieba.homepage.concern.a.a hWs;
    private r hWt;
    private s hWu;
    private p hWv;
    private g hWw;
    private f hWx;
    private e hWy;
    private d hWz;
    private List<o> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hWp = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eK(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.hWo);
    }

    private void eK(Context context) {
        this.hWu = new s(this.mPageContext, com.baidu.tieba.card.data.k.gHu);
        this.hWB = new i(this.mPageContext, com.baidu.tieba.card.data.k.gHB);
        this.hWC = new j(this.mPageContext, com.baidu.tieba.card.data.k.gHC);
        this.hWv = new p(this.mPageContext, com.baidu.tieba.card.data.k.gHA);
        this.hWw = new g(this.mPageContext, com.baidu.tieba.card.data.k.gHw);
        this.hWx = new f(this.mPageContext, com.baidu.tieba.card.data.k.gHx);
        this.hWy = new e(this.mPageContext, com.baidu.tieba.card.data.k.gHy);
        this.hWA = new t(this.mPageContext, com.baidu.tieba.card.data.l.dEV);
        this.hWE = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.e.gGW);
        this.hWz = new d(this.mPageContext, com.baidu.tieba.card.data.k.gHz);
        this.hWD = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.hXW);
        this.hWo.add(this.hWu);
        this.hWo.add(this.hWB);
        this.hWo.add(this.hWC);
        this.hWo.add(this.hWv);
        this.hWo.add(this.hWw);
        this.hWo.add(this.hWx);
        this.hWo.add(this.hWy);
        this.hWo.add(this.hWA);
        this.hWo.add(this.hWz);
        this.hWo.add(this.hWD);
        this.hWq = new q(this.mPageContext.getContext());
        this.hWr = new h(this.mPageContext.getContext());
        this.hWs = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hWt = new r(this.mPageContext, com.baidu.tieba.card.data.k.dEZ);
        this.hWF = new k(this.mPageContext, com.baidu.tieba.card.data.k.dFa);
        this.hWG = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.dFb);
        this.hWH = new l(this.mPageContext, com.baidu.tieba.card.data.k.dFc);
        this.hWI = new m(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.hXV);
        this.hWo.add(this.hWq);
        this.hWo.add(this.hWr);
        this.hWo.add(this.hWs);
        this.hWo.add(this.hWt);
        this.hWo.add(this.hWF);
        this.hWo.add(this.hWG);
        this.hWo.add(this.hWH);
        this.hWo.add(this.hWE);
        this.hWo.add(this.hWI);
        zL("page_concern");
    }

    public void bE(List<o> list) {
        this.mDataList = list;
        this.hWp.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.hWp != null) {
            this.hWp.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hWs.epM = bdUniqueId;
        this.hWs.epM = bdUniqueId;
        this.hWt.epM = bdUniqueId;
        this.hWH.epM = bdUniqueId;
        this.hWF.epM = bdUniqueId;
        this.hWG.epM = bdUniqueId;
        this.hWE.epM = bdUniqueId;
        this.hWz.epM = bdUniqueId;
        this.hWD.epM = bdUniqueId;
    }

    private void zL(String str) {
        if (this.hWo != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hWo) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).zL(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.t tVar) {
        this.hWu.a(tVar);
        this.hWB.a(tVar);
        this.hWC.a(tVar);
        this.hWv.a(tVar);
        this.hWD.a(tVar);
        this.hWw.a(tVar);
        this.hWx.a(tVar);
        this.hWy.a(tVar);
        this.hWA.a(tVar);
        this.hWz.a(tVar);
        this.hWE.a(tVar);
        this.hWG.a(tVar);
        this.hWF.a(tVar);
        this.hWH.a(tVar);
    }

    public List<o> getDataList() {
        return this.mDataList;
    }
}
