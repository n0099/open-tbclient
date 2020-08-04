package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.bv;
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
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private BdTypeRecyclerView hnH;
    private i iCA;
    private k iCB;
    private m iCC;
    private l iCD;
    private o iCE;
    private d iCF;
    private com.baidu.tieba.homepage.tabfeed.a.b iCG;
    private com.baidu.tieba.homepage.tabfeed.a.a iCH;
    private com.baidu.tieba.homepage.tabfeed.a.c iCI;
    private j iCJ;
    private n iCK;
    private HomePageTabFeedFragment iCt;
    private p iCu;
    private e iCv;
    private g iCw;
    private f iCx;
    private h iCy;
    private q iCz;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iCt = homePageTabFeedFragment;
        this.hnH = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.iCu = new p(this.iCt.getPageContext(), bv.dRB, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCu.a(this.hnH);
        this.aWf.add(this.iCu);
        this.iCv = new e(this.iCt.getPageContext(), bv.dRG, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCv.a(this.hnH);
        this.aWf.add(this.iCv);
        this.iCw = new g(this.iCt.getPageContext(), bv.dRE, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCw.a(this.hnH);
        this.aWf.add(this.iCw);
        this.iCx = new f(this.iCt.getPageContext(), bv.dRF, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCx.a(this.hnH);
        this.aWf.add(this.iCx);
        this.iCy = new h(this.iCt.getPageContext(), bv.dRC, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCy.a(this.hnH);
        this.aWf.add(this.iCy);
        this.iCz = new q(this.iCt.getPageContext(), bv.dRS, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCz.a(this.hnH);
        this.aWf.add(this.iCz);
        this.iCA = new i(this.iCt.getPageContext(), bv.dRL, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCA.a(this.hnH);
        this.aWf.add(this.iCA);
        this.iCB = new k(this.iCt.getPageContext(), bv.dRM, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCB.a(this.hnH);
        this.aWf.add(this.iCB);
        this.iCC = new m(this.iCt.getPageContext(), bv.dRO, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCC.a(this.hnH);
        this.aWf.add(this.iCC);
        this.iCD = new l(this.iCt.getPageContext(), bv.dRP, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCD.a(this.hnH);
        this.aWf.add(this.iCD);
        this.iCE = new o(this.iCt.getPageContext(), bv.dRH, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCE.a(this.hnH);
        this.aWf.add(this.iCE);
        this.iCF = new d(this.iCt.getPageContext(), bv.dRK, this.iCt.getUniqueId(), this.iCt.getTabName());
        this.iCF.a(this.hnH);
        this.aWf.add(this.iCF);
        this.iCI = new com.baidu.tieba.homepage.tabfeed.a.c(this.iCt.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.iCt.getTabName());
        this.aWf.add(this.iCI);
        this.iCG = new com.baidu.tieba.homepage.tabfeed.a.b(this.iCt.getPageContext(), bn.dOm);
        this.iCG.a(this.hnH);
        this.aWf.add(this.iCG);
        this.iCH = new com.baidu.tieba.homepage.tabfeed.a.a(this.iCt.getPageContext(), bi.dOm);
        this.iCH.a(this.hnH);
        this.aWf.add(this.iCH);
        this.iCJ = new j(this.iCt.getPageContext());
        this.iCJ.a(this.hnH);
        this.aWf.add(this.iCJ);
        this.iCK = new n(this.iCt.getPageContext());
        this.iCK.a(this.hnH);
        this.aWf.add(this.iCK);
        this.hnH.addAdapters(this.aWf);
    }

    public void notifyDataSetChanged() {
        this.hnH.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.hnH.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.iCH != null) {
            this.iCH.setTabName(str);
        }
    }
}
