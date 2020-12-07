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
    private BdTypeRecyclerView iAG;
    private HomePageTabFeedFragment jVN;
    private p jVO;
    private e jVP;
    private g jVQ;
    private f jVR;
    private h jVS;
    private q jVT;
    private i jVU;
    private k jVV;
    private m jVW;
    private l jVX;
    private o jVY;
    private d jVZ;
    private com.baidu.tieba.homepage.tabfeed.a.b jWa;
    private com.baidu.tieba.homepage.tabfeed.a.a jWb;
    private com.baidu.tieba.homepage.tabfeed.a.c jWc;
    private j jWd;
    private n jWe;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jVN = homePageTabFeedFragment;
        this.iAG = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.jVO = new p(this.jVN.getPageContext(), by.eIY, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVO.a(this.iAG);
        this.bnf.add(this.jVO);
        this.jVP = new e(this.jVN.getPageContext(), by.eJd, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVP.a(this.iAG);
        this.bnf.add(this.jVP);
        this.jVQ = new g(this.jVN.getPageContext(), by.eJb, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVQ.a(this.iAG);
        this.bnf.add(this.jVQ);
        this.jVR = new f(this.jVN.getPageContext(), by.eJc, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVR.a(this.iAG);
        this.bnf.add(this.jVR);
        this.jVS = new h(this.jVN.getPageContext(), by.eIZ, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVS.a(this.iAG);
        this.bnf.add(this.jVS);
        this.jVT = new q(this.jVN.getPageContext(), by.eJq, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVT.a(this.iAG);
        this.bnf.add(this.jVT);
        this.jVU = new i(this.jVN.getPageContext(), by.eJi, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVU.a(this.iAG);
        this.bnf.add(this.jVU);
        this.jVV = new k(this.jVN.getPageContext(), by.eJj, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVV.a(this.iAG);
        this.bnf.add(this.jVV);
        this.jVW = new m(this.jVN.getPageContext(), by.eJl, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVW.a(this.iAG);
        this.bnf.add(this.jVW);
        this.jVX = new l(this.jVN.getPageContext(), by.eJm, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVX.a(this.iAG);
        this.bnf.add(this.jVX);
        this.jVY = new o(this.jVN.getPageContext(), by.eJe, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVY.a(this.iAG);
        this.bnf.add(this.jVY);
        this.jVZ = new d(this.jVN.getPageContext(), by.eJh, this.jVN.getUniqueId(), this.jVN.getTabName());
        this.jVZ.a(this.iAG);
        this.bnf.add(this.jVZ);
        this.jWc = new com.baidu.tieba.homepage.tabfeed.a.c(this.jVN.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.jVN.getTabName());
        this.bnf.add(this.jWc);
        this.jWa = new com.baidu.tieba.homepage.tabfeed.a.b(this.jVN.getPageContext(), bq.eFE);
        this.jWa.a(this.iAG);
        this.bnf.add(this.jWa);
        this.jWb = new com.baidu.tieba.homepage.tabfeed.a.a(this.jVN.getPageContext(), bl.eFE);
        this.jWb.a(this.iAG);
        this.bnf.add(this.jWb);
        this.jWd = new j(this.jVN.getPageContext());
        this.jWd.a(this.iAG);
        this.bnf.add(this.jWd);
        this.jWe = new n(this.jVN.getPageContext());
        this.jWe.a(this.iAG);
        this.bnf.add(this.jWe);
        this.iAG.addAdapters(this.bnf);
    }

    public void notifyDataSetChanged() {
        this.iAG.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.iAG.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.jWb != null) {
            this.jWb.setTabName(str);
        }
    }
}
