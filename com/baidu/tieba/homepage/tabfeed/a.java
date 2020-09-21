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
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private BdTypeRecyclerView hHG;
    private HomePageTabFeedFragment jad;
    private p jae;
    private e jaf;
    private g jag;
    private f jah;
    private h jai;
    private q jaj;
    private i jak;
    private k jal;
    private m jam;
    private l jan;
    private o jao;
    private d jap;
    private com.baidu.tieba.homepage.tabfeed.a.b jaq;
    private com.baidu.tieba.homepage.tabfeed.a.a jar;
    private com.baidu.tieba.homepage.tabfeed.a.c jas;
    private j jat;
    private n jau;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jad = homePageTabFeedFragment;
        this.hHG = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.jae = new p(this.jad.getPageContext(), bw.edl, this.jad.getUniqueId(), this.jad.getTabName());
        this.jae.a(this.hHG);
        this.bdV.add(this.jae);
        this.jaf = new e(this.jad.getPageContext(), bw.edq, this.jad.getUniqueId(), this.jad.getTabName());
        this.jaf.a(this.hHG);
        this.bdV.add(this.jaf);
        this.jag = new g(this.jad.getPageContext(), bw.edo, this.jad.getUniqueId(), this.jad.getTabName());
        this.jag.a(this.hHG);
        this.bdV.add(this.jag);
        this.jah = new f(this.jad.getPageContext(), bw.edp, this.jad.getUniqueId(), this.jad.getTabName());
        this.jah.a(this.hHG);
        this.bdV.add(this.jah);
        this.jai = new h(this.jad.getPageContext(), bw.edm, this.jad.getUniqueId(), this.jad.getTabName());
        this.jai.a(this.hHG);
        this.bdV.add(this.jai);
        this.jaj = new q(this.jad.getPageContext(), bw.edC, this.jad.getUniqueId(), this.jad.getTabName());
        this.jaj.a(this.hHG);
        this.bdV.add(this.jaj);
        this.jak = new i(this.jad.getPageContext(), bw.edv, this.jad.getUniqueId(), this.jad.getTabName());
        this.jak.a(this.hHG);
        this.bdV.add(this.jak);
        this.jal = new k(this.jad.getPageContext(), bw.edw, this.jad.getUniqueId(), this.jad.getTabName());
        this.jal.a(this.hHG);
        this.bdV.add(this.jal);
        this.jam = new m(this.jad.getPageContext(), bw.edy, this.jad.getUniqueId(), this.jad.getTabName());
        this.jam.a(this.hHG);
        this.bdV.add(this.jam);
        this.jan = new l(this.jad.getPageContext(), bw.edz, this.jad.getUniqueId(), this.jad.getTabName());
        this.jan.a(this.hHG);
        this.bdV.add(this.jan);
        this.jao = new o(this.jad.getPageContext(), bw.edr, this.jad.getUniqueId(), this.jad.getTabName());
        this.jao.a(this.hHG);
        this.bdV.add(this.jao);
        this.jap = new d(this.jad.getPageContext(), bw.edu, this.jad.getUniqueId(), this.jad.getTabName());
        this.jap.a(this.hHG);
        this.bdV.add(this.jap);
        this.jas = new com.baidu.tieba.homepage.tabfeed.a.c(this.jad.getPageContext(), com.baidu.tieba.card.data.k.TYPE, this.jad.getTabName());
        this.bdV.add(this.jas);
        this.jaq = new com.baidu.tieba.homepage.tabfeed.a.b(this.jad.getPageContext(), bo.dZT);
        this.jaq.a(this.hHG);
        this.bdV.add(this.jaq);
        this.jar = new com.baidu.tieba.homepage.tabfeed.a.a(this.jad.getPageContext(), bj.dZT);
        this.jar.a(this.hHG);
        this.bdV.add(this.jar);
        this.jat = new j(this.jad.getPageContext());
        this.jat.a(this.hHG);
        this.bdV.add(this.jat);
        this.jau = new n(this.jad.getPageContext());
        this.jau.a(this.hHG);
        this.bdV.add(this.jau);
        this.hHG.addAdapters(this.bdV);
    }

    public void notifyDataSetChanged() {
        this.hHG.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.hHG.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.jar != null) {
            this.jar.setTabName(str);
        }
    }
}
