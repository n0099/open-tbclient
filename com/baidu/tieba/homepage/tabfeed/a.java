package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.homepage.tabfeed.a.d;
import com.baidu.tieba.homepage.tabfeed.a.e;
import com.baidu.tieba.homepage.tabfeed.a.f;
import com.baidu.tieba.homepage.tabfeed.a.g;
import com.baidu.tieba.homepage.tabfeed.a.h;
import com.baidu.tieba.homepage.tabfeed.a.i;
import com.baidu.tieba.homepage.tabfeed.a.j;
import com.baidu.tieba.homepage.tabfeed.a.k;
import com.baidu.tieba.homepage.tabfeed.a.l;
import com.baidu.tieba.homepage.tabfeed.a.m;
import com.baidu.tieba.homepage.tabfeed.a.n;
import com.baidu.tieba.homepage.tabfeed.a.o;
import com.baidu.tieba.homepage.tabfeed.a.p;
import com.baidu.tieba.homepage.tabfeed.a.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private BdTypeRecyclerView iNV;
    private HomePageTabFeedFragment kmD;
    private p kmE;
    private e kmF;
    private g kmG;
    private f kmH;
    private h kmI;
    private q kmJ;
    private i kmK;
    private k kmL;
    private m kmM;
    private l kmN;
    private o kmO;
    private d kmP;
    private com.baidu.tieba.homepage.tabfeed.a.b kmQ;
    private com.baidu.tieba.homepage.tabfeed.a.a kmR;
    private com.baidu.tieba.homepage.tabfeed.a.c kmS;
    private j kmT;
    private n kmU;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kmD = homePageTabFeedFragment;
        this.iNV = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.kmE = new p(this.kmD.getPageContext(), cb.eQs, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmE.a(this.iNV);
        this.bns.add(this.kmE);
        this.kmF = new e(this.kmD.getPageContext(), cb.eQx, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmF.a(this.iNV);
        this.bns.add(this.kmF);
        this.kmG = new g(this.kmD.getPageContext(), cb.eQv, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmG.a(this.iNV);
        this.bns.add(this.kmG);
        this.kmH = new f(this.kmD.getPageContext(), cb.eQw, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmH.a(this.iNV);
        this.bns.add(this.kmH);
        this.kmI = new h(this.kmD.getPageContext(), cb.eQt, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmI.a(this.iNV);
        this.bns.add(this.kmI);
        this.kmJ = new q(this.kmD.getPageContext(), cb.eQK, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmJ.a(this.iNV);
        this.bns.add(this.kmJ);
        this.kmK = new i(this.kmD.getPageContext(), cb.eQC, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmK.a(this.iNV);
        this.bns.add(this.kmK);
        this.kmL = new k(this.kmD.getPageContext(), cb.eQD, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmL.a(this.iNV);
        this.bns.add(this.kmL);
        this.kmM = new m(this.kmD.getPageContext(), cb.eQF, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmM.a(this.iNV);
        this.bns.add(this.kmM);
        this.kmN = new l(this.kmD.getPageContext(), cb.eQG, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmN.a(this.iNV);
        this.bns.add(this.kmN);
        this.kmO = new o(this.kmD.getPageContext(), cb.eQy, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmO.a(this.iNV);
        this.bns.add(this.kmO);
        this.kmP = new d(this.kmD.getPageContext(), cb.eQB, this.kmD.getUniqueId(), this.kmD.getTabName());
        this.kmP.a(this.iNV);
        this.bns.add(this.kmP);
        this.kmS = new com.baidu.tieba.homepage.tabfeed.a.c(this.kmD.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.kmD.getTabName());
        this.bns.add(this.kmS);
        this.kmQ = new com.baidu.tieba.homepage.tabfeed.a.b(this.kmD.getPageContext(), bt.eMV);
        this.kmQ.a(this.iNV);
        this.bns.add(this.kmQ);
        this.kmR = new com.baidu.tieba.homepage.tabfeed.a.a(this.kmD.getPageContext(), bo.eMV);
        this.kmR.a(this.iNV);
        this.bns.add(this.kmR);
        this.kmT = new j(this.kmD.getPageContext());
        this.kmT.a(this.iNV);
        this.bns.add(this.kmT);
        this.kmU = new n(this.kmD.getPageContext());
        this.kmU.a(this.iNV);
        this.bns.add(this.kmU);
        this.iNV.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        this.iNV.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        this.iNV.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.kmR != null) {
            this.kmR.setTabName(str);
        }
    }
}
