package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bu;
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
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private BdTypeRecyclerView hhX;
    private com.baidu.tieba.homepage.tabfeed.a.b iwA;
    private com.baidu.tieba.homepage.tabfeed.a.a iwB;
    private com.baidu.tieba.homepage.tabfeed.a.c iwC;
    private j iwD;
    private n iwE;
    private HomePageTabFeedFragment iwn;
    private p iwo;
    private e iwp;
    private g iwq;
    private f iwr;
    private h iws;
    private q iwt;
    private i iwu;
    private k iwv;
    private m iww;
    private l iwx;
    private o iwy;
    private d iwz;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iwn = homePageTabFeedFragment;
        this.hhX = bdTypeRecyclerView;
        Dz();
    }

    private void Dz() {
        this.iwo = new p(this.iwn.getPageContext(), bu.dLq, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwo.a(this.hhX);
        this.aUP.add(this.iwo);
        this.iwp = new e(this.iwn.getPageContext(), bu.dLv, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwp.a(this.hhX);
        this.aUP.add(this.iwp);
        this.iwq = new g(this.iwn.getPageContext(), bu.dLt, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwq.a(this.hhX);
        this.aUP.add(this.iwq);
        this.iwr = new f(this.iwn.getPageContext(), bu.dLu, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwr.a(this.hhX);
        this.aUP.add(this.iwr);
        this.iws = new h(this.iwn.getPageContext(), bu.dLr, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iws.a(this.hhX);
        this.aUP.add(this.iws);
        this.iwt = new q(this.iwn.getPageContext(), bu.dLH, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwt.a(this.hhX);
        this.aUP.add(this.iwt);
        this.iwu = new i(this.iwn.getPageContext(), bu.dLA, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwu.a(this.hhX);
        this.aUP.add(this.iwu);
        this.iwv = new k(this.iwn.getPageContext(), bu.dLB, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwv.a(this.hhX);
        this.aUP.add(this.iwv);
        this.iww = new m(this.iwn.getPageContext(), bu.dLD, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iww.a(this.hhX);
        this.aUP.add(this.iww);
        this.iwx = new l(this.iwn.getPageContext(), bu.dLE, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwx.a(this.hhX);
        this.aUP.add(this.iwx);
        this.iwy = new o(this.iwn.getPageContext(), bu.dLw, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwy.a(this.hhX);
        this.aUP.add(this.iwy);
        this.iwz = new d(this.iwn.getPageContext(), bu.dLz, this.iwn.getUniqueId(), this.iwn.getTabName());
        this.iwz.a(this.hhX);
        this.aUP.add(this.iwz);
        this.iwC = new com.baidu.tieba.homepage.tabfeed.a.c(this.iwn.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.iwn.getTabName());
        this.aUP.add(this.iwC);
        this.iwA = new com.baidu.tieba.homepage.tabfeed.a.b(this.iwn.getPageContext(), bm.dIb);
        this.iwA.a(this.hhX);
        this.aUP.add(this.iwA);
        this.iwB = new com.baidu.tieba.homepage.tabfeed.a.a(this.iwn.getPageContext(), bh.dIb);
        this.iwB.a(this.hhX);
        this.aUP.add(this.iwB);
        this.iwD = new j(this.iwn.getPageContext());
        this.iwD.a(this.hhX);
        this.aUP.add(this.iwD);
        this.iwE = new n(this.iwn.getPageContext());
        this.iwE.a(this.hhX);
        this.aUP.add(this.iwE);
        this.hhX.addAdapters(this.aUP);
    }

    public void notifyDataSetChanged() {
        this.hhX.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.hhX.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.iwB != null) {
            this.iwB.setTabName(str);
        }
    }
}
