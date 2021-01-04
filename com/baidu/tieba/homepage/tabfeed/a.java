package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bz;
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
    private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
    private BdTypeRecyclerView iMU;
    private HomePageTabFeedFragment kjb;
    private p kjc;
    private e kjd;
    private g kje;
    private f kjf;
    private h kjg;
    private q kjh;
    private i kji;
    private k kjj;
    private m kjk;
    private l kjl;
    private o kjm;
    private d kjn;
    private com.baidu.tieba.homepage.tabfeed.a.b kjo;
    private com.baidu.tieba.homepage.tabfeed.a.a kjp;
    private com.baidu.tieba.homepage.tabfeed.a.c kjq;
    private j kjr;
    private n kjs;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kjb = homePageTabFeedFragment;
        this.iMU = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.kjc = new p(this.kjb.getPageContext(), bz.eSR, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjc.a(this.iMU);
        this.boM.add(this.kjc);
        this.kjd = new e(this.kjb.getPageContext(), bz.eSW, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjd.a(this.iMU);
        this.boM.add(this.kjd);
        this.kje = new g(this.kjb.getPageContext(), bz.eSU, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kje.a(this.iMU);
        this.boM.add(this.kje);
        this.kjf = new f(this.kjb.getPageContext(), bz.eSV, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjf.a(this.iMU);
        this.boM.add(this.kjf);
        this.kjg = new h(this.kjb.getPageContext(), bz.eSS, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjg.a(this.iMU);
        this.boM.add(this.kjg);
        this.kjh = new q(this.kjb.getPageContext(), bz.eTj, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjh.a(this.iMU);
        this.boM.add(this.kjh);
        this.kji = new i(this.kjb.getPageContext(), bz.eTb, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kji.a(this.iMU);
        this.boM.add(this.kji);
        this.kjj = new k(this.kjb.getPageContext(), bz.eTc, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjj.a(this.iMU);
        this.boM.add(this.kjj);
        this.kjk = new m(this.kjb.getPageContext(), bz.eTe, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjk.a(this.iMU);
        this.boM.add(this.kjk);
        this.kjl = new l(this.kjb.getPageContext(), bz.eTf, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjl.a(this.iMU);
        this.boM.add(this.kjl);
        this.kjm = new o(this.kjb.getPageContext(), bz.eSX, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjm.a(this.iMU);
        this.boM.add(this.kjm);
        this.kjn = new d(this.kjb.getPageContext(), bz.eTa, this.kjb.getUniqueId(), this.kjb.getTabName());
        this.kjn.a(this.iMU);
        this.boM.add(this.kjn);
        this.kjq = new com.baidu.tieba.homepage.tabfeed.a.c(this.kjb.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.kjb.getTabName());
        this.boM.add(this.kjq);
        this.kjo = new com.baidu.tieba.homepage.tabfeed.a.b(this.kjb.getPageContext(), br.ePu);
        this.kjo.a(this.iMU);
        this.boM.add(this.kjo);
        this.kjp = new com.baidu.tieba.homepage.tabfeed.a.a(this.kjb.getPageContext(), bm.ePu);
        this.kjp.a(this.iMU);
        this.boM.add(this.kjp);
        this.kjr = new j(this.kjb.getPageContext());
        this.kjr.a(this.iMU);
        this.boM.add(this.kjr);
        this.kjs = new n(this.kjb.getPageContext());
        this.kjs.a(this.iMU);
        this.boM.add(this.kjs);
        this.iMU.addAdapters(this.boM);
    }

    public void notifyDataSetChanged() {
        this.iMU.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        this.iMU.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.kjp != null) {
            this.kjp.setTabName(str);
        }
    }
}
