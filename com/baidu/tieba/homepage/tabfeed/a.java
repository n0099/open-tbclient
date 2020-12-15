package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private BdTypeRecyclerView iAI;
    private HomePageTabFeedFragment jVP;
    private p jVQ;
    private e jVR;
    private g jVS;
    private f jVT;
    private h jVU;
    private q jVV;
    private i jVW;
    private k jVX;
    private m jVY;
    private l jVZ;
    private o jWa;
    private d jWb;
    private com.baidu.tieba.homepage.tabfeed.a.b jWc;
    private com.baidu.tieba.homepage.tabfeed.a.a jWd;
    private com.baidu.tieba.homepage.tabfeed.a.c jWe;
    private j jWf;
    private n jWg;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jVP = homePageTabFeedFragment;
        this.iAI = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.jVQ = new p(this.jVP.getPageContext(), by.eIY, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVQ.a(this.iAI);
        this.bnf.add(this.jVQ);
        this.jVR = new e(this.jVP.getPageContext(), by.eJd, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVR.a(this.iAI);
        this.bnf.add(this.jVR);
        this.jVS = new g(this.jVP.getPageContext(), by.eJb, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVS.a(this.iAI);
        this.bnf.add(this.jVS);
        this.jVT = new f(this.jVP.getPageContext(), by.eJc, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVT.a(this.iAI);
        this.bnf.add(this.jVT);
        this.jVU = new h(this.jVP.getPageContext(), by.eIZ, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVU.a(this.iAI);
        this.bnf.add(this.jVU);
        this.jVV = new q(this.jVP.getPageContext(), by.eJq, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVV.a(this.iAI);
        this.bnf.add(this.jVV);
        this.jVW = new i(this.jVP.getPageContext(), by.eJi, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVW.a(this.iAI);
        this.bnf.add(this.jVW);
        this.jVX = new k(this.jVP.getPageContext(), by.eJj, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVX.a(this.iAI);
        this.bnf.add(this.jVX);
        this.jVY = new m(this.jVP.getPageContext(), by.eJl, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVY.a(this.iAI);
        this.bnf.add(this.jVY);
        this.jVZ = new l(this.jVP.getPageContext(), by.eJm, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jVZ.a(this.iAI);
        this.bnf.add(this.jVZ);
        this.jWa = new o(this.jVP.getPageContext(), by.eJe, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jWa.a(this.iAI);
        this.bnf.add(this.jWa);
        this.jWb = new d(this.jVP.getPageContext(), by.eJh, this.jVP.getUniqueId(), this.jVP.getTabName());
        this.jWb.a(this.iAI);
        this.bnf.add(this.jWb);
        this.jWe = new com.baidu.tieba.homepage.tabfeed.a.c(this.jVP.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.jVP.getTabName());
        this.bnf.add(this.jWe);
        this.jWc = new com.baidu.tieba.homepage.tabfeed.a.b(this.jVP.getPageContext(), bq.eFE);
        this.jWc.a(this.iAI);
        this.bnf.add(this.jWc);
        this.jWd = new com.baidu.tieba.homepage.tabfeed.a.a(this.jVP.getPageContext(), bl.eFE);
        this.jWd.a(this.iAI);
        this.bnf.add(this.jWd);
        this.jWf = new j(this.jVP.getPageContext());
        this.jWf.a(this.iAI);
        this.bnf.add(this.jWf);
        this.jWg = new n(this.jVP.getPageContext());
        this.jWg.a(this.iAI);
        this.bnf.add(this.jWg);
        this.iAI.addAdapters(this.bnf);
    }

    public void notifyDataSetChanged() {
        this.iAI.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.iAI.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.jWd != null) {
            this.jWd.setTabName(str);
        }
    }
}
