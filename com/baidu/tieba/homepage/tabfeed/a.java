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
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
    private BdTypeRecyclerView hAy;
    private m iRA;
    private l iRB;
    private o iRC;
    private d iRD;
    private com.baidu.tieba.homepage.tabfeed.a.b iRE;
    private com.baidu.tieba.homepage.tabfeed.a.a iRF;
    private com.baidu.tieba.homepage.tabfeed.a.c iRG;
    private j iRH;
    private n iRI;
    private HomePageTabFeedFragment iRr;
    private p iRs;
    private e iRt;
    private g iRu;
    private f iRv;
    private h iRw;
    private q iRx;
    private i iRy;
    private k iRz;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iRr = homePageTabFeedFragment;
        this.hAy = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.iRs = new p(this.iRr.getPageContext(), bw.eaX, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRs.a(this.hAy);
        this.bbu.add(this.iRs);
        this.iRt = new e(this.iRr.getPageContext(), bw.ebc, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRt.a(this.hAy);
        this.bbu.add(this.iRt);
        this.iRu = new g(this.iRr.getPageContext(), bw.eba, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRu.a(this.hAy);
        this.bbu.add(this.iRu);
        this.iRv = new f(this.iRr.getPageContext(), bw.ebb, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRv.a(this.hAy);
        this.bbu.add(this.iRv);
        this.iRw = new h(this.iRr.getPageContext(), bw.eaY, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRw.a(this.hAy);
        this.bbu.add(this.iRw);
        this.iRx = new q(this.iRr.getPageContext(), bw.ebo, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRx.a(this.hAy);
        this.bbu.add(this.iRx);
        this.iRy = new i(this.iRr.getPageContext(), bw.ebh, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRy.a(this.hAy);
        this.bbu.add(this.iRy);
        this.iRz = new k(this.iRr.getPageContext(), bw.ebi, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRz.a(this.hAy);
        this.bbu.add(this.iRz);
        this.iRA = new m(this.iRr.getPageContext(), bw.ebk, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRA.a(this.hAy);
        this.bbu.add(this.iRA);
        this.iRB = new l(this.iRr.getPageContext(), bw.ebl, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRB.a(this.hAy);
        this.bbu.add(this.iRB);
        this.iRC = new o(this.iRr.getPageContext(), bw.ebd, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRC.a(this.hAy);
        this.bbu.add(this.iRC);
        this.iRD = new d(this.iRr.getPageContext(), bw.ebg, this.iRr.getUniqueId(), this.iRr.getTabName());
        this.iRD.a(this.hAy);
        this.bbu.add(this.iRD);
        this.iRG = new com.baidu.tieba.homepage.tabfeed.a.c(this.iRr.getPageContext(), com.baidu.tieba.card.data.k.TYPE, this.iRr.getTabName());
        this.bbu.add(this.iRG);
        this.iRE = new com.baidu.tieba.homepage.tabfeed.a.b(this.iRr.getPageContext(), bo.dXF);
        this.iRE.a(this.hAy);
        this.bbu.add(this.iRE);
        this.iRF = new com.baidu.tieba.homepage.tabfeed.a.a(this.iRr.getPageContext(), bj.dXF);
        this.iRF.a(this.hAy);
        this.bbu.add(this.iRF);
        this.iRH = new j(this.iRr.getPageContext());
        this.iRH.a(this.hAy);
        this.bbu.add(this.iRH);
        this.iRI = new n(this.iRr.getPageContext());
        this.iRI.a(this.hAy);
        this.bbu.add(this.iRI);
        this.hAy.addAdapters(this.bbu);
    }

    public void notifyDataSetChanged() {
        this.hAy.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.hAy.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.iRF != null) {
            this.iRF.setTabName(str);
        }
    }
}
