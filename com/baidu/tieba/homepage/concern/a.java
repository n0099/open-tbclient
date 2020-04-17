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
    private u hHA;
    private u hHB;
    private com.baidu.tieba.homepage.concern.a.a hHC;
    private r hHD;
    private s hHE;
    private p hHF;
    private f hHG;
    private e hHH;
    private d hHI;
    private com.baidu.tieba.homepage.concern.a.c hHJ;
    private t hHK;
    private h hHL;
    private i hHM;
    private n hHN;
    private com.baidu.tieba.homepage.personalize.a.e hHO;
    private j hHP;
    private com.baidu.tieba.homepage.concern.a.b hHQ;
    private k hHR;
    private l hHS;
    private List<com.baidu.adp.widget.ListView.a> hHv = new ArrayList();
    private BdTypeRecyclerView hHw;
    private q hHx;
    private g hHy;
    private m hHz;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hHw = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.T(context);
        eH(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.hHv);
    }

    private void eH(Context context) {
        this.hHE = new s(this.mPageContext, com.baidu.tieba.card.data.k.gsA);
        this.hHL = new h(this.mPageContext, com.baidu.tieba.card.data.k.gsG);
        this.hHM = new i(this.mPageContext, com.baidu.tieba.card.data.k.gsI);
        this.hHF = new p(this.mPageContext, com.baidu.tieba.card.data.k.gsJ);
        this.hHG = new f(this.mPageContext, com.baidu.tieba.card.data.k.gsB);
        this.hHH = new e(this.mPageContext, com.baidu.tieba.card.data.k.gsD);
        this.hHI = new d(this.mPageContext, com.baidu.tieba.card.data.k.gsE);
        this.hHK = new t(this.mPageContext, com.baidu.tieba.card.data.l.dqV);
        this.hHO = new com.baidu.tieba.homepage.personalize.a.e(this.mPageContext, com.baidu.tieba.card.data.e.gsb);
        this.hHJ = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.gsF);
        this.hHN = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.hJm);
        this.hHO.setFrom(1);
        this.hHv.add(this.hHE);
        this.hHv.add(this.hHL);
        this.hHv.add(this.hHM);
        this.hHv.add(this.hHF);
        this.hHv.add(this.hHG);
        this.hHv.add(this.hHH);
        this.hHv.add(this.hHI);
        this.hHv.add(this.hHK);
        this.hHv.add(this.hHJ);
        this.hHv.add(this.hHN);
        this.hHz = new m(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.hHA = new u(this.mPageContext, com.baidu.tieba.card.data.l.gsQ);
        this.hHB = new u(this.mPageContext, com.baidu.tieba.card.data.l.gsR);
        this.hHx = new q(this.mPageContext.getContext());
        this.hHy = new g(this.mPageContext.getContext());
        this.hHC = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hHD = new r(this.mPageContext, com.baidu.tieba.card.data.k.dqZ);
        this.hHP = new j(this.mPageContext, com.baidu.tieba.card.data.k.dra);
        this.hHQ = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.drb);
        this.hHR = new k(this.mPageContext, com.baidu.tieba.card.data.k.drc);
        this.hHS = new l(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.hJl);
        this.hHv.add(this.hHz);
        this.hHv.add(this.hHA);
        this.hHv.add(this.hHB);
        this.hHv.add(this.hHx);
        this.hHv.add(this.hHy);
        this.hHv.add(this.hHC);
        this.hHv.add(this.hHD);
        this.hHv.add(this.hHP);
        this.hHv.add(this.hHQ);
        this.hHv.add(this.hHR);
        this.hHv.add(this.hHO);
        this.hHv.add(this.hHS);
        yc("page_concern");
    }

    public void ak(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.hHw.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.hHw != null) {
            this.hHw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hHC.ebv = bdUniqueId;
        this.hHz.ebv = bdUniqueId;
        this.hHA.ebv = bdUniqueId;
        this.hHB.ebv = bdUniqueId;
        this.hHC.ebv = bdUniqueId;
        this.hHD.ebv = bdUniqueId;
        this.hHR.ebv = bdUniqueId;
        this.hHP.ebv = bdUniqueId;
        this.hHQ.ebv = bdUniqueId;
        this.hHO.ebv = bdUniqueId;
        this.hHJ.ebv = bdUniqueId;
        this.hHN.ebv = bdUniqueId;
    }

    private void yc(String str) {
        if (this.hHv != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hHv) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).yc(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.r rVar) {
        this.hHE.a(rVar);
        this.hHL.a(rVar);
        this.hHM.a(rVar);
        this.hHF.a(rVar);
        this.hHN.a(rVar);
        this.hHG.a(rVar);
        this.hHH.a(rVar);
        this.hHI.a(rVar);
        this.hHK.a(rVar);
        this.hHJ.a(rVar);
        this.hHO.a(rVar);
        this.hHQ.a(rVar);
        this.hHP.a(rVar);
        this.hHR.a(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
