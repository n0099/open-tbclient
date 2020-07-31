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
    private m iCA;
    private l iCB;
    private o iCC;
    private d iCD;
    private com.baidu.tieba.homepage.tabfeed.a.b iCE;
    private com.baidu.tieba.homepage.tabfeed.a.a iCF;
    private com.baidu.tieba.homepage.tabfeed.a.c iCG;
    private j iCH;
    private n iCI;
    private HomePageTabFeedFragment iCr;
    private p iCs;
    private e iCt;
    private g iCu;
    private f iCv;
    private h iCw;
    private q iCx;
    private i iCy;
    private k iCz;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iCr = homePageTabFeedFragment;
        this.hnH = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.iCs = new p(this.iCr.getPageContext(), bv.dRB, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCs.a(this.hnH);
        this.aWf.add(this.iCs);
        this.iCt = new e(this.iCr.getPageContext(), bv.dRG, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCt.a(this.hnH);
        this.aWf.add(this.iCt);
        this.iCu = new g(this.iCr.getPageContext(), bv.dRE, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCu.a(this.hnH);
        this.aWf.add(this.iCu);
        this.iCv = new f(this.iCr.getPageContext(), bv.dRF, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCv.a(this.hnH);
        this.aWf.add(this.iCv);
        this.iCw = new h(this.iCr.getPageContext(), bv.dRC, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCw.a(this.hnH);
        this.aWf.add(this.iCw);
        this.iCx = new q(this.iCr.getPageContext(), bv.dRS, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCx.a(this.hnH);
        this.aWf.add(this.iCx);
        this.iCy = new i(this.iCr.getPageContext(), bv.dRL, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCy.a(this.hnH);
        this.aWf.add(this.iCy);
        this.iCz = new k(this.iCr.getPageContext(), bv.dRM, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCz.a(this.hnH);
        this.aWf.add(this.iCz);
        this.iCA = new m(this.iCr.getPageContext(), bv.dRO, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCA.a(this.hnH);
        this.aWf.add(this.iCA);
        this.iCB = new l(this.iCr.getPageContext(), bv.dRP, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCB.a(this.hnH);
        this.aWf.add(this.iCB);
        this.iCC = new o(this.iCr.getPageContext(), bv.dRH, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCC.a(this.hnH);
        this.aWf.add(this.iCC);
        this.iCD = new d(this.iCr.getPageContext(), bv.dRK, this.iCr.getUniqueId(), this.iCr.getTabName());
        this.iCD.a(this.hnH);
        this.aWf.add(this.iCD);
        this.iCG = new com.baidu.tieba.homepage.tabfeed.a.c(this.iCr.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.iCr.getTabName());
        this.aWf.add(this.iCG);
        this.iCE = new com.baidu.tieba.homepage.tabfeed.a.b(this.iCr.getPageContext(), bn.dOm);
        this.iCE.a(this.hnH);
        this.aWf.add(this.iCE);
        this.iCF = new com.baidu.tieba.homepage.tabfeed.a.a(this.iCr.getPageContext(), bi.dOm);
        this.iCF.a(this.hnH);
        this.aWf.add(this.iCF);
        this.iCH = new j(this.iCr.getPageContext());
        this.iCH.a(this.hnH);
        this.aWf.add(this.iCH);
        this.iCI = new n(this.iCr.getPageContext());
        this.iCI.a(this.hnH);
        this.aWf.add(this.iCI);
        this.hnH.addAdapters(this.aWf);
    }

    public void notifyDataSetChanged() {
        this.hnH.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.hnH.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.iCF != null) {
            this.iCF.setTabName(str);
        }
    }
}
