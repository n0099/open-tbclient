package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private BdTypeRecyclerView ipO;
    private j jIA;
    private n jIB;
    private HomePageTabFeedFragment jIk;
    private p jIl;
    private e jIm;
    private g jIn;
    private f jIo;
    private h jIp;
    private q jIq;
    private i jIr;
    private k jIs;
    private m jIt;
    private l jIu;
    private o jIv;
    private d jIw;
    private com.baidu.tieba.homepage.tabfeed.a.b jIx;
    private com.baidu.tieba.homepage.tabfeed.a.a jIy;
    private com.baidu.tieba.homepage.tabfeed.a.c jIz;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jIk = homePageTabFeedFragment;
        this.ipO = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.jIl = new p(this.jIk.getPageContext(), bx.eBX, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIl.a(this.ipO);
        this.biN.add(this.jIl);
        this.jIm = new e(this.jIk.getPageContext(), bx.eCc, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIm.a(this.ipO);
        this.biN.add(this.jIm);
        this.jIn = new g(this.jIk.getPageContext(), bx.eCa, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIn.a(this.ipO);
        this.biN.add(this.jIn);
        this.jIo = new f(this.jIk.getPageContext(), bx.eCb, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIo.a(this.ipO);
        this.biN.add(this.jIo);
        this.jIp = new h(this.jIk.getPageContext(), bx.eBY, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIp.a(this.ipO);
        this.biN.add(this.jIp);
        this.jIq = new q(this.jIk.getPageContext(), bx.eCo, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIq.a(this.ipO);
        this.biN.add(this.jIq);
        this.jIr = new i(this.jIk.getPageContext(), bx.eCh, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIr.a(this.ipO);
        this.biN.add(this.jIr);
        this.jIs = new k(this.jIk.getPageContext(), bx.eCi, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIs.a(this.ipO);
        this.biN.add(this.jIs);
        this.jIt = new m(this.jIk.getPageContext(), bx.eCk, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIt.a(this.ipO);
        this.biN.add(this.jIt);
        this.jIu = new l(this.jIk.getPageContext(), bx.eCl, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIu.a(this.ipO);
        this.biN.add(this.jIu);
        this.jIv = new o(this.jIk.getPageContext(), bx.eCd, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIv.a(this.ipO);
        this.biN.add(this.jIv);
        this.jIw = new d(this.jIk.getPageContext(), bx.eCg, this.jIk.getUniqueId(), this.jIk.getTabName());
        this.jIw.a(this.ipO);
        this.biN.add(this.jIw);
        this.jIz = new com.baidu.tieba.homepage.tabfeed.a.c(this.jIk.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.jIk.getTabName());
        this.biN.add(this.jIz);
        this.jIx = new com.baidu.tieba.homepage.tabfeed.a.b(this.jIk.getPageContext(), bp.eyF);
        this.jIx.a(this.ipO);
        this.biN.add(this.jIx);
        this.jIy = new com.baidu.tieba.homepage.tabfeed.a.a(this.jIk.getPageContext(), bk.eyF);
        this.jIy.a(this.ipO);
        this.biN.add(this.jIy);
        this.jIA = new j(this.jIk.getPageContext());
        this.jIA.a(this.ipO);
        this.biN.add(this.jIA);
        this.jIB = new n(this.jIk.getPageContext());
        this.jIB.a(this.ipO);
        this.biN.add(this.jIB);
        this.ipO.addAdapters(this.biN);
    }

    public void notifyDataSetChanged() {
        this.ipO.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.ipO.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.jIy != null) {
            this.jIy.setTabName(str);
        }
    }
}
