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
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private BdTypeRecyclerView hWB;
    private HomePageTabFeedFragment jpc;
    private p jpd;
    private e jpe;
    private g jpf;
    private f jpg;
    private h jph;
    private q jpi;
    private i jpj;
    private k jpk;
    private m jpl;
    private l jpm;
    private o jpn;
    private d jpo;
    private com.baidu.tieba.homepage.tabfeed.a.b jpp;
    private com.baidu.tieba.homepage.tabfeed.a.a jpq;
    private com.baidu.tieba.homepage.tabfeed.a.c jpr;
    private j jps;
    private n jpt;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jpc = homePageTabFeedFragment;
        this.hWB = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.jpd = new p(this.jpc.getPageContext(), bw.epq, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpd.a(this.hWB);
        this.bhH.add(this.jpd);
        this.jpe = new e(this.jpc.getPageContext(), bw.epv, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpe.a(this.hWB);
        this.bhH.add(this.jpe);
        this.jpf = new g(this.jpc.getPageContext(), bw.ept, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpf.a(this.hWB);
        this.bhH.add(this.jpf);
        this.jpg = new f(this.jpc.getPageContext(), bw.epu, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpg.a(this.hWB);
        this.bhH.add(this.jpg);
        this.jph = new h(this.jpc.getPageContext(), bw.epr, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jph.a(this.hWB);
        this.bhH.add(this.jph);
        this.jpi = new q(this.jpc.getPageContext(), bw.epH, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpi.a(this.hWB);
        this.bhH.add(this.jpi);
        this.jpj = new i(this.jpc.getPageContext(), bw.epA, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpj.a(this.hWB);
        this.bhH.add(this.jpj);
        this.jpk = new k(this.jpc.getPageContext(), bw.epB, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpk.a(this.hWB);
        this.bhH.add(this.jpk);
        this.jpl = new m(this.jpc.getPageContext(), bw.epD, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpl.a(this.hWB);
        this.bhH.add(this.jpl);
        this.jpm = new l(this.jpc.getPageContext(), bw.epE, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpm.a(this.hWB);
        this.bhH.add(this.jpm);
        this.jpn = new o(this.jpc.getPageContext(), bw.epw, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpn.a(this.hWB);
        this.bhH.add(this.jpn);
        this.jpo = new d(this.jpc.getPageContext(), bw.epz, this.jpc.getUniqueId(), this.jpc.getTabName());
        this.jpo.a(this.hWB);
        this.bhH.add(this.jpo);
        this.jpr = new com.baidu.tieba.homepage.tabfeed.a.c(this.jpc.getPageContext(), com.baidu.tieba.card.data.k.TYPE, this.jpc.getTabName());
        this.bhH.add(this.jpr);
        this.jpp = new com.baidu.tieba.homepage.tabfeed.a.b(this.jpc.getPageContext(), bo.elV);
        this.jpp.a(this.hWB);
        this.bhH.add(this.jpp);
        this.jpq = new com.baidu.tieba.homepage.tabfeed.a.a(this.jpc.getPageContext(), bj.elV);
        this.jpq.a(this.hWB);
        this.bhH.add(this.jpq);
        this.jps = new j(this.jpc.getPageContext());
        this.jps.a(this.hWB);
        this.bhH.add(this.jps);
        this.jpt = new n(this.jpc.getPageContext());
        this.jpt.a(this.hWB);
        this.bhH.add(this.jpt);
        this.hWB.addAdapters(this.bhH);
    }

    public void notifyDataSetChanged() {
        this.hWB.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.hWB.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.jpq != null) {
            this.jpq.setTabName(str);
        }
    }
}
