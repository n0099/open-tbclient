package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.homepage.concern.adapter.ConcernEmotionTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.ConcernTipAdapter;
import com.baidu.tieba.homepage.concern.adapter.e;
import com.baidu.tieba.homepage.concern.adapter.f;
import com.baidu.tieba.homepage.concern.adapter.g;
import com.baidu.tieba.homepage.concern.adapter.h;
import com.baidu.tieba.homepage.concern.adapter.i;
import com.baidu.tieba.homepage.concern.adapter.j;
import com.baidu.tieba.homepage.concern.adapter.k;
import com.baidu.tieba.homepage.concern.adapter.l;
import com.baidu.tieba.homepage.concern.adapter.m;
import com.baidu.tieba.homepage.concern.adapter.n;
import com.baidu.tieba.homepage.concern.adapter.o;
import com.baidu.tieba.homepage.concern.adapter.p;
import com.baidu.tieba.homepage.concern.adapter.q;
import com.baidu.tieba.homepage.concern.adapter.r;
import com.baidu.tieba.homepage.concern.adapter.s;
import com.baidu.tieba.homepage.concern.adapter.t;
import com.baidu.tieba.homepage.concern.adapter.u;
import com.baidu.tieba.homepage.concern.adapter.v;
import com.baidu.tieba.homepage.concern.adapter.w;
import com.baidu.tieba.homepage.concern.adapter.x;
import com.baidu.tieba.homepage.concern.adapter.y;
import com.baidu.tieba.homepage.concern.adapter.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private t jZA;
    private o jZB;
    private s jZC;
    private com.baidu.tieba.homepage.concern.adapter.d jZD;
    private p jZE;
    private e jZF;
    private q jZG;
    private ConcernEmotionTipAdapter jZH;
    private z jZI;
    ArrayList<com.baidu.adp.widget.ListView.a> jZJ;
    private BdTypeRecyclerView jZf;
    private ConcernTipAdapter jZg;
    private ConcernEmotionTipAdapter jZh;
    private com.baidu.tieba.homepage.concern.adapter.b jZi;
    private com.baidu.tieba.homepage.concern.adapter.a jZj;
    private v jZk;
    private x jZm;
    private x jZn;
    private j jZo;
    private w jZp;
    private l jZq;
    private u jZr;
    private i jZs;
    private h jZt;
    private g jZu;
    private f jZv;
    private y jZw;
    private k jZx;
    private m jZy;
    private n jZz;
    private List<com.baidu.adp.widget.ListView.n> mDataList;
    private TbPageContext<?> mPageContext;
    private ArrayList<r> jZl = new ArrayList<>();
    private List<com.baidu.adp.widget.ListView.a> jOi = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jZf = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.K(context);
        gm(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jOi);
    }

    private void gm(Context context) {
        for (int i = 0; i < com.baidu.tieba.card.data.b.iAo.size(); i++) {
            for (int i2 = 0; i2 < com.baidu.tieba.card.data.b.iAp.size(); i2++) {
                this.jZl.add(new r(this.mPageContext, com.baidu.tieba.card.data.b.iAq[i][i2], com.baidu.tieba.card.data.b.iAo.get(i), com.baidu.tieba.card.data.b.iAp.get(i2)));
            }
        }
        this.jZm = new x(this.mPageContext, cb.eQK, com.baidu.tieba.card.data.b.iAe);
        this.jZn = new x(this.mPageContext, cb.eQn, com.baidu.tieba.card.data.b.iAf);
        this.jZo = new j(this.mPageContext, cb.eRd, com.baidu.tieba.card.data.b.iAe);
        this.jZp = new w(this.mPageContext, com.baidu.tieba.card.data.k.iBb);
        this.jZq = new l(this.mPageContext, com.baidu.tieba.card.data.k.eQr);
        this.jZx = new k(this.mPageContext, com.baidu.tieba.card.data.k.iBh);
        this.jZy = new m(this.mPageContext, com.baidu.tieba.card.data.k.iBi);
        this.jZr = new u(this.mPageContext, com.baidu.tieba.card.data.k.iBg);
        this.jZs = new i(this.mPageContext, com.baidu.tieba.card.data.k.iBc);
        this.jZt = new h(this.mPageContext, com.baidu.tieba.card.data.k.iBd);
        this.jZu = new g(this.mPageContext, com.baidu.tieba.card.data.k.iBe);
        this.jZw = new y(this.mPageContext, com.baidu.tieba.card.data.l.eQK);
        this.jZD = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.e.iAC);
        this.jZv = new f(this.mPageContext, com.baidu.tieba.card.data.k.iBf);
        this.jZC = new s(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.eMV);
        this.jZz = new n(this.mPageContext, com.baidu.tieba.card.data.k.eQD);
        this.jZA = new t(this.mPageContext, com.baidu.tieba.card.data.k.eQF);
        this.jZB = new o(this.mPageContext, com.baidu.tieba.card.data.k.eQG);
        this.jOi.addAll(this.jZl);
        this.jOi.add(this.jZm);
        this.jOi.add(this.jZn);
        this.jOi.add(this.jZo);
        this.jOi.add(this.jZp);
        this.jOi.add(this.jZq);
        this.jOi.add(this.jZx);
        this.jOi.add(this.jZy);
        this.jOi.add(this.jZr);
        this.jOi.add(this.jZs);
        this.jOi.add(this.jZt);
        this.jOi.add(this.jZu);
        this.jOi.add(this.jZw);
        this.jOi.add(this.jZv);
        this.jOi.add(this.jZC);
        this.jOi.add(this.jZz);
        this.jOi.add(this.jZA);
        this.jOi.add(this.jZB);
        this.jZg = new ConcernTipAdapter(this.mPageContext.getContext());
        this.jZh = new ConcernEmotionTipAdapter(this.mPageContext.getContext());
        this.jZi = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jZj = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.j.iAH);
        this.jZk = new v(this.mPageContext, com.baidu.tieba.card.data.k.eQP);
        this.jZE = new p(this.mPageContext, com.baidu.tieba.card.data.k.eQQ);
        this.jZF = new e(this.mPageContext, com.baidu.tieba.card.data.k.eQR);
        this.jZG = new q(this.mPageContext, com.baidu.tieba.card.data.k.eQS);
        this.jZH = new ConcernEmotionTipAdapter(this.mPageContext.getContext(), com.baidu.tieba.homepage.concern.a.b.kbL);
        this.jZI = new z(this.mPageContext, com.baidu.tieba.card.data.k.iBa, (byte) 4);
        this.jOi.add(this.jZg);
        this.jOi.add(this.jZh);
        this.jOi.add(this.jZi);
        this.jOi.add(this.jZj);
        this.jOi.add(this.jZk);
        this.jOi.add(this.jZE);
        this.jOi.add(this.jZF);
        this.jOi.add(this.jZG);
        this.jOi.add(this.jZD);
        this.jOi.add(this.jZH);
        this.jOi.add(this.jZI);
        Ew("page_concern");
        cOL();
    }

    private void cOL() {
        if (!cb.eRa.get()) {
            AdvertAppInfo.eLs.set(false);
            return;
        }
        this.jZJ = new ArrayList<>();
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLg, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLj, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLn, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLo, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLp, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a7 = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLr, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a8 = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLq, "CONCERN");
        this.jZJ.add(a2);
        this.jZJ.add(a3);
        this.jZJ.add(a4);
        this.jZJ.add(a5);
        this.jZJ.add(a6);
        this.jZJ.add(a7);
        this.jZJ.add(a8);
        this.jOi.addAll(this.jZJ);
        AdvertAppInfo.eLs.set(true);
    }

    public void cx(List<com.baidu.adp.widget.ListView.n> list) {
        this.mDataList = list;
        this.jZf.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jZf != null) {
            this.jZf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.jZl.iterator();
        while (it.hasNext()) {
            it.next().fGZ = bdUniqueId;
        }
        this.jZi.fGZ = bdUniqueId;
        this.jZj.fGZ = bdUniqueId;
        this.jZk.fGZ = bdUniqueId;
        this.jZG.fGZ = bdUniqueId;
        this.jZE.fGZ = bdUniqueId;
        this.jZF.fGZ = bdUniqueId;
        this.jZD.fGZ = bdUniqueId;
        this.jZv.fGZ = bdUniqueId;
        this.jZC.fGZ = bdUniqueId;
        this.jZI.fGZ = bdUniqueId;
    }

    private void Ew(String str) {
        if (this.jOi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jOi) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ew(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        Iterator<r> it = this.jZl.iterator();
        while (it.hasNext()) {
            it.next().a(sVar);
        }
        this.jZm.a(sVar);
        this.jZn.a(sVar);
        this.jZo.a(sVar);
        this.jZp.a(sVar);
        this.jZq.a(sVar);
        this.jZx.a(sVar);
        this.jZy.a(sVar);
        this.jZr.a(sVar);
        this.jZC.a(sVar);
        this.jZz.a(sVar);
        this.jZA.a(sVar);
        this.jZB.a(sVar);
        this.jZs.a(sVar);
        this.jZt.a(sVar);
        this.jZu.a(sVar);
        this.jZw.a(sVar);
        this.jZv.a(sVar);
        this.jZD.a(sVar);
        this.jZF.a(sVar);
        this.jZE.a(sVar);
        this.jZG.a(sVar);
        this.jZI.a(sVar);
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.mDataList;
    }

    public void onDestroy() {
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(this.mDataList)) {
            Iterator<com.baidu.adp.widget.ListView.a> it = this.jZJ.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a next = it.next();
                if (next instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) next).onDestroy();
                }
            }
        }
    }
}
