package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.a.f;
import com.baidu.tieba.homepage.concern.a.g;
import com.baidu.tieba.homepage.concern.a.h;
import com.baidu.tieba.homepage.concern.a.i;
import com.baidu.tieba.homepage.concern.a.j;
import com.baidu.tieba.homepage.concern.a.k;
import com.baidu.tieba.homepage.concern.a.l;
import com.baidu.tieba.homepage.concern.a.m;
import com.baidu.tieba.homepage.concern.a.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> gee = new ArrayList();
    private BdTypeRecyclerView gef;
    private com.baidu.tieba.b.a geg;
    private j geh;
    private e gei;
    private h gej;
    private n gek;
    private n gel;
    private com.baidu.tieba.homepage.concern.a.a gem;
    private k gen;
    private l gep;
    private f geq;
    private g ger;
    private i ges;
    private d get;
    private com.baidu.tieba.homepage.concern.a.c geu;
    private com.baidu.tieba.homepage.concern.a.b gev;
    private m gew;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gef = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dG(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gee);
    }

    private void dG(Context context) {
        this.gep = new l(this.mPageContext, com.baidu.tieba.card.data.k.eHK);
        this.geq = new f(this.mPageContext, com.baidu.tieba.card.data.k.eHP);
        this.ger = new g(this.mPageContext, com.baidu.tieba.card.data.k.eHQ);
        this.ges = new i(this.mPageContext, com.baidu.tieba.card.data.k.eHR);
        this.get = new d(this.mPageContext, com.baidu.tieba.card.data.k.eHL);
        this.geu = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.eHN);
        this.gev = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.eHO);
        this.gew = new m(this.mPageContext, com.baidu.tieba.card.data.l.bKa);
        this.gee.add(this.gep);
        this.gee.add(this.geq);
        this.gee.add(this.ger);
        this.gee.add(this.ges);
        this.gee.add(this.get);
        this.gee.add(this.geu);
        this.gee.add(this.gev);
        this.gee.add(this.gew);
        this.geg = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.crp);
        this.gej = new h(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gek = new n(this.mPageContext, com.baidu.tieba.card.data.l.eHX);
        this.gel = new n(this.mPageContext, com.baidu.tieba.card.data.l.eHY);
        this.geh = new j(this.mPageContext.getContext());
        this.gei = new e(this.mPageContext.getContext());
        this.gem = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gen = new k(this.mPageContext, com.baidu.tieba.card.data.k.bKe);
        this.gee.add(this.geg);
        this.gee.add(this.gej);
        this.gee.add(this.gek);
        this.gee.add(this.gel);
        this.gee.add(this.geh);
        this.gee.add(this.gei);
        this.gee.add(this.gem);
        this.gee.add(this.gen);
        sy("page_concern");
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gef.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gef != null) {
            this.gef.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gem.cyA = bdUniqueId;
        this.gej.cyA = bdUniqueId;
        this.gek.cyA = bdUniqueId;
        this.gel.cyA = bdUniqueId;
        this.gem.cyA = bdUniqueId;
        this.gen.cyA = bdUniqueId;
    }

    private void sy(String str) {
        if (this.gee != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gee) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).sy(str);
                }
            }
        }
    }

    private void b(r rVar) {
        this.gep.b(rVar);
        this.geq.b(rVar);
        this.ger.b(rVar);
        this.ges.b(rVar);
        this.get.b(rVar);
        this.geu.b(rVar);
        this.gev.b(rVar);
        this.gew.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
