package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bw;
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
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private BdTypeRecyclerView hAE;
    private g iRA;
    private f iRB;
    private h iRC;
    private q iRD;
    private i iRE;
    private k iRF;
    private m iRG;
    private l iRH;
    private o iRI;
    private d iRJ;
    private com.baidu.tieba.homepage.tabfeed.a.b iRK;
    private com.baidu.tieba.homepage.tabfeed.a.a iRL;
    private com.baidu.tieba.homepage.tabfeed.a.c iRM;
    private j iRN;
    private n iRO;
    private HomePageTabFeedFragment iRx;
    private p iRy;
    private e iRz;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iRx = homePageTabFeedFragment;
        this.hAE = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.iRy = new p(this.iRx.getPageContext(), bw.ebb, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRy.a(this.hAE);
        this.bbw.add(this.iRy);
        this.iRz = new e(this.iRx.getPageContext(), bw.ebg, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRz.a(this.hAE);
        this.bbw.add(this.iRz);
        this.iRA = new g(this.iRx.getPageContext(), bw.ebe, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRA.a(this.hAE);
        this.bbw.add(this.iRA);
        this.iRB = new f(this.iRx.getPageContext(), bw.ebf, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRB.a(this.hAE);
        this.bbw.add(this.iRB);
        this.iRC = new h(this.iRx.getPageContext(), bw.ebc, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRC.a(this.hAE);
        this.bbw.add(this.iRC);
        this.iRD = new q(this.iRx.getPageContext(), bw.ebs, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRD.a(this.hAE);
        this.bbw.add(this.iRD);
        this.iRE = new i(this.iRx.getPageContext(), bw.ebl, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRE.a(this.hAE);
        this.bbw.add(this.iRE);
        this.iRF = new k(this.iRx.getPageContext(), bw.ebm, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRF.a(this.hAE);
        this.bbw.add(this.iRF);
        this.iRG = new m(this.iRx.getPageContext(), bw.ebo, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRG.a(this.hAE);
        this.bbw.add(this.iRG);
        this.iRH = new l(this.iRx.getPageContext(), bw.ebp, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRH.a(this.hAE);
        this.bbw.add(this.iRH);
        this.iRI = new o(this.iRx.getPageContext(), bw.ebh, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRI.a(this.hAE);
        this.bbw.add(this.iRI);
        this.iRJ = new d(this.iRx.getPageContext(), bw.ebk, this.iRx.getUniqueId(), this.iRx.getTabName());
        this.iRJ.a(this.hAE);
        this.bbw.add(this.iRJ);
        this.iRM = new com.baidu.tieba.homepage.tabfeed.a.c(this.iRx.getPageContext(), com.baidu.tieba.card.data.k.TYPE, this.iRx.getTabName());
        this.bbw.add(this.iRM);
        this.iRK = new com.baidu.tieba.homepage.tabfeed.a.b(this.iRx.getPageContext(), bo.dXJ);
        this.iRK.a(this.hAE);
        this.bbw.add(this.iRK);
        this.iRL = new com.baidu.tieba.homepage.tabfeed.a.a(this.iRx.getPageContext(), bj.dXJ);
        this.iRL.a(this.hAE);
        this.bbw.add(this.iRL);
        this.iRN = new j(this.iRx.getPageContext());
        this.iRN.a(this.hAE);
        this.bbw.add(this.iRN);
        this.iRO = new n(this.iRx.getPageContext());
        this.iRO.a(this.hAE);
        this.bbw.add(this.iRO);
        this.hAE.addAdapters(this.bbw);
    }

    public void notifyDataSetChanged() {
        this.hAE.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.hAE.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.iRL != null) {
            this.iRL.setTabName(str);
        }
    }
}
