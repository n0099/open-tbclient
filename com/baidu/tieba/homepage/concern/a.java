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
    private List<com.baidu.adp.widget.ListView.a> hHB = new ArrayList();
    private BdTypeRecyclerView hHC;
    private q hHD;
    private g hHE;
    private m hHF;
    private u hHG;
    private u hHH;
    private com.baidu.tieba.homepage.concern.a.a hHI;
    private r hHJ;
    private s hHK;
    private p hHL;
    private f hHM;
    private e hHN;
    private d hHO;
    private com.baidu.tieba.homepage.concern.a.c hHP;
    private t hHQ;
    private h hHR;
    private i hHS;
    private n hHT;
    private com.baidu.tieba.homepage.personalize.a.e hHU;
    private j hHV;
    private com.baidu.tieba.homepage.concern.a.b hHW;
    private k hHX;
    private l hHY;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hHC = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        ev(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.hHB);
    }

    private void ev(Context context) {
        this.hHK = new s(this.mPageContext, com.baidu.tieba.card.data.k.gsG);
        this.hHR = new h(this.mPageContext, com.baidu.tieba.card.data.k.gsM);
        this.hHS = new i(this.mPageContext, com.baidu.tieba.card.data.k.gsO);
        this.hHL = new p(this.mPageContext, com.baidu.tieba.card.data.k.gsP);
        this.hHM = new f(this.mPageContext, com.baidu.tieba.card.data.k.gsH);
        this.hHN = new e(this.mPageContext, com.baidu.tieba.card.data.k.gsJ);
        this.hHO = new d(this.mPageContext, com.baidu.tieba.card.data.k.gsK);
        this.hHQ = new t(this.mPageContext, com.baidu.tieba.card.data.l.dqZ);
        this.hHU = new com.baidu.tieba.homepage.personalize.a.e(this.mPageContext, com.baidu.tieba.card.data.e.gsh);
        this.hHP = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.gsL);
        this.hHT = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.hJs);
        this.hHU.setFrom(1);
        this.hHB.add(this.hHK);
        this.hHB.add(this.hHR);
        this.hHB.add(this.hHS);
        this.hHB.add(this.hHL);
        this.hHB.add(this.hHM);
        this.hHB.add(this.hHN);
        this.hHB.add(this.hHO);
        this.hHB.add(this.hHQ);
        this.hHB.add(this.hHP);
        this.hHB.add(this.hHT);
        this.hHF = new m(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.hHG = new u(this.mPageContext, com.baidu.tieba.card.data.l.gsW);
        this.hHH = new u(this.mPageContext, com.baidu.tieba.card.data.l.gsX);
        this.hHD = new q(this.mPageContext.getContext());
        this.hHE = new g(this.mPageContext.getContext());
        this.hHI = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hHJ = new r(this.mPageContext, com.baidu.tieba.card.data.k.drd);
        this.hHV = new j(this.mPageContext, com.baidu.tieba.card.data.k.dre);
        this.hHW = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.drf);
        this.hHX = new k(this.mPageContext, com.baidu.tieba.card.data.k.drg);
        this.hHY = new l(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.hJr);
        this.hHB.add(this.hHF);
        this.hHB.add(this.hHG);
        this.hHB.add(this.hHH);
        this.hHB.add(this.hHD);
        this.hHB.add(this.hHE);
        this.hHB.add(this.hHI);
        this.hHB.add(this.hHJ);
        this.hHB.add(this.hHV);
        this.hHB.add(this.hHW);
        this.hHB.add(this.hHX);
        this.hHB.add(this.hHU);
        this.hHB.add(this.hHY);
        yf("page_concern");
    }

    public void ak(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.hHC.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.hHC != null) {
            this.hHC.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hHI.ebA = bdUniqueId;
        this.hHF.ebA = bdUniqueId;
        this.hHG.ebA = bdUniqueId;
        this.hHH.ebA = bdUniqueId;
        this.hHI.ebA = bdUniqueId;
        this.hHJ.ebA = bdUniqueId;
        this.hHX.ebA = bdUniqueId;
        this.hHV.ebA = bdUniqueId;
        this.hHW.ebA = bdUniqueId;
        this.hHU.ebA = bdUniqueId;
        this.hHP.ebA = bdUniqueId;
        this.hHT.ebA = bdUniqueId;
    }

    private void yf(String str) {
        if (this.hHB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hHB) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).yf(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.r rVar) {
        this.hHK.a(rVar);
        this.hHR.a(rVar);
        this.hHS.a(rVar);
        this.hHL.a(rVar);
        this.hHT.a(rVar);
        this.hHM.a(rVar);
        this.hHN.a(rVar);
        this.hHO.a(rVar);
        this.hHQ.a(rVar);
        this.hHP.a(rVar);
        this.hHU.a(rVar);
        this.hHW.a(rVar);
        this.hHV.a(rVar);
        this.hHX.a(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
