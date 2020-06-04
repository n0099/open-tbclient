package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tieba.homepage.concern.a.p;
import com.baidu.tieba.homepage.concern.a.q;
import com.baidu.tieba.homepage.concern.a.r;
import com.baidu.tieba.homepage.concern.a.s;
import com.baidu.tieba.homepage.concern.a.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> hXb = new ArrayList();
    private BdTypeRecyclerView hXc;
    private q hXd;
    private h hXe;
    private com.baidu.tieba.homepage.concern.a.a hXf;
    private r hXg;
    private s hXh;
    private p hXi;
    private g hXj;
    private f hXk;
    private e hXl;
    private d hXm;
    private t hXn;
    private i hXo;
    private j hXp;
    private n hXq;
    private com.baidu.tieba.homepage.concern.a.b hXr;
    private k hXs;
    private com.baidu.tieba.homepage.concern.a.c hXt;
    private l hXu;
    private m hXv;
    private List<o> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hXc = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eK(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.hXb);
    }

    private void eK(Context context) {
        this.hXh = new s(this.mPageContext, com.baidu.tieba.card.data.k.gHF);
        this.hXo = new i(this.mPageContext, com.baidu.tieba.card.data.k.gHM);
        this.hXp = new j(this.mPageContext, com.baidu.tieba.card.data.k.gHN);
        this.hXi = new p(this.mPageContext, com.baidu.tieba.card.data.k.gHL);
        this.hXj = new g(this.mPageContext, com.baidu.tieba.card.data.k.gHH);
        this.hXk = new f(this.mPageContext, com.baidu.tieba.card.data.k.gHI);
        this.hXl = new e(this.mPageContext, com.baidu.tieba.card.data.k.gHJ);
        this.hXn = new t(this.mPageContext, com.baidu.tieba.card.data.l.dEV);
        this.hXr = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.e.gHh);
        this.hXm = new d(this.mPageContext, com.baidu.tieba.card.data.k.gHK);
        this.hXq = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.hYJ);
        this.hXb.add(this.hXh);
        this.hXb.add(this.hXo);
        this.hXb.add(this.hXp);
        this.hXb.add(this.hXi);
        this.hXb.add(this.hXj);
        this.hXb.add(this.hXk);
        this.hXb.add(this.hXl);
        this.hXb.add(this.hXn);
        this.hXb.add(this.hXm);
        this.hXb.add(this.hXq);
        this.hXd = new q(this.mPageContext.getContext());
        this.hXe = new h(this.mPageContext.getContext());
        this.hXf = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hXg = new r(this.mPageContext, com.baidu.tieba.card.data.k.dEZ);
        this.hXs = new k(this.mPageContext, com.baidu.tieba.card.data.k.dFa);
        this.hXt = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.dFb);
        this.hXu = new l(this.mPageContext, com.baidu.tieba.card.data.k.dFc);
        this.hXv = new m(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.hYI);
        this.hXb.add(this.hXd);
        this.hXb.add(this.hXe);
        this.hXb.add(this.hXf);
        this.hXb.add(this.hXg);
        this.hXb.add(this.hXs);
        this.hXb.add(this.hXt);
        this.hXb.add(this.hXu);
        this.hXb.add(this.hXr);
        this.hXb.add(this.hXv);
        zL("page_concern");
    }

    public void bE(List<o> list) {
        this.mDataList = list;
        this.hXc.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.hXc != null) {
            this.hXc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hXf.epM = bdUniqueId;
        this.hXf.epM = bdUniqueId;
        this.hXg.epM = bdUniqueId;
        this.hXu.epM = bdUniqueId;
        this.hXs.epM = bdUniqueId;
        this.hXt.epM = bdUniqueId;
        this.hXr.epM = bdUniqueId;
        this.hXm.epM = bdUniqueId;
        this.hXq.epM = bdUniqueId;
    }

    private void zL(String str) {
        if (this.hXb != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hXb) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).zL(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.t tVar) {
        this.hXh.a(tVar);
        this.hXo.a(tVar);
        this.hXp.a(tVar);
        this.hXi.a(tVar);
        this.hXq.a(tVar);
        this.hXj.a(tVar);
        this.hXk.a(tVar);
        this.hXl.a(tVar);
        this.hXn.a(tVar);
        this.hXm.a(tVar);
        this.hXr.a(tVar);
        this.hXt.a(tVar);
        this.hXs.a(tVar);
        this.hXu.a(tVar);
    }

    public List<o> getDataList() {
        return this.mDataList;
    }
}
