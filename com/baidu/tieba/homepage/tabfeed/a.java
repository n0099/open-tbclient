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
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private BdTypeRecyclerView iPS;
    private HomePageTabFeedFragment koT;
    private p koU;
    private e koV;
    private g koW;
    private f koX;
    private h koY;
    private q koZ;
    private i kpa;
    private k kpb;
    private m kpc;
    private l kpd;
    private o kpe;
    private d kpf;
    private com.baidu.tieba.homepage.tabfeed.a.b kpg;
    private com.baidu.tieba.homepage.tabfeed.a.a kph;
    private com.baidu.tieba.homepage.tabfeed.a.c kpi;
    private j kpj;
    private n kpk;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.koT = homePageTabFeedFragment;
        this.iPS = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.koU = new p(this.koT.getPageContext(), cb.eRT, this.koT.getUniqueId(), this.koT.getTabName());
        this.koU.a(this.iPS);
        this.boS.add(this.koU);
        this.koV = new e(this.koT.getPageContext(), cb.eRY, this.koT.getUniqueId(), this.koT.getTabName());
        this.koV.a(this.iPS);
        this.boS.add(this.koV);
        this.koW = new g(this.koT.getPageContext(), cb.eRW, this.koT.getUniqueId(), this.koT.getTabName());
        this.koW.a(this.iPS);
        this.boS.add(this.koW);
        this.koX = new f(this.koT.getPageContext(), cb.eRX, this.koT.getUniqueId(), this.koT.getTabName());
        this.koX.a(this.iPS);
        this.boS.add(this.koX);
        this.koY = new h(this.koT.getPageContext(), cb.eRU, this.koT.getUniqueId(), this.koT.getTabName());
        this.koY.a(this.iPS);
        this.boS.add(this.koY);
        this.koZ = new q(this.koT.getPageContext(), cb.eSl, this.koT.getUniqueId(), this.koT.getTabName());
        this.koZ.a(this.iPS);
        this.boS.add(this.koZ);
        this.kpa = new i(this.koT.getPageContext(), cb.eSd, this.koT.getUniqueId(), this.koT.getTabName());
        this.kpa.a(this.iPS);
        this.boS.add(this.kpa);
        this.kpb = new k(this.koT.getPageContext(), cb.eSe, this.koT.getUniqueId(), this.koT.getTabName());
        this.kpb.a(this.iPS);
        this.boS.add(this.kpb);
        this.kpc = new m(this.koT.getPageContext(), cb.eSg, this.koT.getUniqueId(), this.koT.getTabName());
        this.kpc.a(this.iPS);
        this.boS.add(this.kpc);
        this.kpd = new l(this.koT.getPageContext(), cb.eSh, this.koT.getUniqueId(), this.koT.getTabName());
        this.kpd.a(this.iPS);
        this.boS.add(this.kpd);
        this.kpe = new o(this.koT.getPageContext(), cb.eRZ, this.koT.getUniqueId(), this.koT.getTabName());
        this.kpe.a(this.iPS);
        this.boS.add(this.kpe);
        this.kpf = new d(this.koT.getPageContext(), cb.eSc, this.koT.getUniqueId(), this.koT.getTabName());
        this.kpf.a(this.iPS);
        this.boS.add(this.kpf);
        this.kpi = new com.baidu.tieba.homepage.tabfeed.a.c(this.koT.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.koT.getTabName());
        this.boS.add(this.kpi);
        this.kpg = new com.baidu.tieba.homepage.tabfeed.a.b(this.koT.getPageContext(), bt.eOw);
        this.kpg.a(this.iPS);
        this.boS.add(this.kpg);
        this.kph = new com.baidu.tieba.homepage.tabfeed.a.a(this.koT.getPageContext(), bo.eOw);
        this.kph.a(this.iPS);
        this.boS.add(this.kph);
        this.kpj = new j(this.koT.getPageContext());
        this.kpj.a(this.iPS);
        this.boS.add(this.kpj);
        this.kpk = new n(this.koT.getPageContext());
        this.kpk.a(this.iPS);
        this.boS.add(this.kpk);
        this.iPS.addAdapters(this.boS);
    }

    public void notifyDataSetChanged() {
        this.iPS.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        this.iPS.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.kph != null) {
            this.kph.setTabName(str);
        }
    }
}
