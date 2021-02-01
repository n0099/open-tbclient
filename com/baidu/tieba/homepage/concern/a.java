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
    private BdTypeRecyclerView jYR;
    private ConcernTipAdapter jYS;
    private ConcernEmotionTipAdapter jYT;
    private com.baidu.tieba.homepage.concern.adapter.b jYU;
    private com.baidu.tieba.homepage.concern.adapter.a jYV;
    private v jYW;
    private x jYY;
    private x jYZ;
    private j jZa;
    private w jZb;
    private l jZc;
    private u jZd;
    private i jZe;
    private h jZf;
    private g jZg;
    private f jZh;
    private y jZi;
    private k jZj;
    private m jZk;
    private n jZl;
    private t jZm;
    private o jZn;
    private s jZo;
    private com.baidu.tieba.homepage.concern.adapter.d jZp;
    private p jZq;
    private e jZr;
    private q jZs;
    private ConcernEmotionTipAdapter jZt;
    private z jZu;
    ArrayList<com.baidu.adp.widget.ListView.a> jZv;
    private List<com.baidu.adp.widget.ListView.n> mDataList;
    private TbPageContext<?> mPageContext;
    private ArrayList<r> jYX = new ArrayList<>();
    private List<com.baidu.adp.widget.ListView.a> jNU = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jYR = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.K(context);
        gm(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jNU);
    }

    private void gm(Context context) {
        for (int i = 0; i < com.baidu.tieba.card.data.b.iAa.size(); i++) {
            for (int i2 = 0; i2 < com.baidu.tieba.card.data.b.iAb.size(); i2++) {
                this.jYX.add(new r(this.mPageContext, com.baidu.tieba.card.data.b.iAc[i][i2], com.baidu.tieba.card.data.b.iAa.get(i), com.baidu.tieba.card.data.b.iAb.get(i2)));
            }
        }
        this.jYY = new x(this.mPageContext, cb.eQK, com.baidu.tieba.card.data.b.izQ);
        this.jYZ = new x(this.mPageContext, cb.eQn, com.baidu.tieba.card.data.b.izR);
        this.jZa = new j(this.mPageContext, cb.eRd, com.baidu.tieba.card.data.b.izQ);
        this.jZb = new w(this.mPageContext, com.baidu.tieba.card.data.k.iAN);
        this.jZc = new l(this.mPageContext, com.baidu.tieba.card.data.k.eQr);
        this.jZj = new k(this.mPageContext, com.baidu.tieba.card.data.k.iAT);
        this.jZk = new m(this.mPageContext, com.baidu.tieba.card.data.k.iAU);
        this.jZd = new u(this.mPageContext, com.baidu.tieba.card.data.k.iAS);
        this.jZe = new i(this.mPageContext, com.baidu.tieba.card.data.k.iAO);
        this.jZf = new h(this.mPageContext, com.baidu.tieba.card.data.k.iAP);
        this.jZg = new g(this.mPageContext, com.baidu.tieba.card.data.k.iAQ);
        this.jZi = new y(this.mPageContext, com.baidu.tieba.card.data.l.eQK);
        this.jZp = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.e.iAo);
        this.jZh = new f(this.mPageContext, com.baidu.tieba.card.data.k.iAR);
        this.jZo = new s(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.eMV);
        this.jZl = new n(this.mPageContext, com.baidu.tieba.card.data.k.eQD);
        this.jZm = new t(this.mPageContext, com.baidu.tieba.card.data.k.eQF);
        this.jZn = new o(this.mPageContext, com.baidu.tieba.card.data.k.eQG);
        this.jNU.addAll(this.jYX);
        this.jNU.add(this.jYY);
        this.jNU.add(this.jYZ);
        this.jNU.add(this.jZa);
        this.jNU.add(this.jZb);
        this.jNU.add(this.jZc);
        this.jNU.add(this.jZj);
        this.jNU.add(this.jZk);
        this.jNU.add(this.jZd);
        this.jNU.add(this.jZe);
        this.jNU.add(this.jZf);
        this.jNU.add(this.jZg);
        this.jNU.add(this.jZi);
        this.jNU.add(this.jZh);
        this.jNU.add(this.jZo);
        this.jNU.add(this.jZl);
        this.jNU.add(this.jZm);
        this.jNU.add(this.jZn);
        this.jYS = new ConcernTipAdapter(this.mPageContext.getContext());
        this.jYT = new ConcernEmotionTipAdapter(this.mPageContext.getContext());
        this.jYU = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jYV = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.j.iAt);
        this.jYW = new v(this.mPageContext, com.baidu.tieba.card.data.k.eQP);
        this.jZq = new p(this.mPageContext, com.baidu.tieba.card.data.k.eQQ);
        this.jZr = new e(this.mPageContext, com.baidu.tieba.card.data.k.eQR);
        this.jZs = new q(this.mPageContext, com.baidu.tieba.card.data.k.eQS);
        this.jZt = new ConcernEmotionTipAdapter(this.mPageContext.getContext(), com.baidu.tieba.homepage.concern.a.b.kbx);
        this.jZu = new z(this.mPageContext, com.baidu.tieba.card.data.k.iAM, (byte) 4);
        this.jNU.add(this.jYS);
        this.jNU.add(this.jYT);
        this.jNU.add(this.jYU);
        this.jNU.add(this.jYV);
        this.jNU.add(this.jYW);
        this.jNU.add(this.jZq);
        this.jNU.add(this.jZr);
        this.jNU.add(this.jZs);
        this.jNU.add(this.jZp);
        this.jNU.add(this.jZt);
        this.jNU.add(this.jZu);
        Ey("page_concern");
        cOE();
    }

    private void cOE() {
        if (!cb.eRa.get()) {
            AdvertAppInfo.eLs.set(false);
            return;
        }
        this.jZv = new ArrayList<>();
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLg, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLj, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLn, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLo, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLp, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a7 = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLr, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a8 = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLq, "CONCERN");
        this.jZv.add(a2);
        this.jZv.add(a3);
        this.jZv.add(a4);
        this.jZv.add(a5);
        this.jZv.add(a6);
        this.jZv.add(a7);
        this.jZv.add(a8);
        this.jNU.addAll(this.jZv);
        AdvertAppInfo.eLs.set(true);
    }

    public void cx(List<com.baidu.adp.widget.ListView.n> list) {
        this.mDataList = list;
        this.jYR.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jYR != null) {
            this.jYR.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.jYX.iterator();
        while (it.hasNext()) {
            it.next().fGZ = bdUniqueId;
        }
        this.jYU.fGZ = bdUniqueId;
        this.jYV.fGZ = bdUniqueId;
        this.jYW.fGZ = bdUniqueId;
        this.jZs.fGZ = bdUniqueId;
        this.jZq.fGZ = bdUniqueId;
        this.jZr.fGZ = bdUniqueId;
        this.jZp.fGZ = bdUniqueId;
        this.jZh.fGZ = bdUniqueId;
        this.jZo.fGZ = bdUniqueId;
        this.jZu.fGZ = bdUniqueId;
    }

    private void Ey(String str) {
        if (this.jNU != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jNU) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ey(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        Iterator<r> it = this.jYX.iterator();
        while (it.hasNext()) {
            it.next().a(sVar);
        }
        this.jYY.a(sVar);
        this.jYZ.a(sVar);
        this.jZa.a(sVar);
        this.jZb.a(sVar);
        this.jZc.a(sVar);
        this.jZj.a(sVar);
        this.jZk.a(sVar);
        this.jZd.a(sVar);
        this.jZo.a(sVar);
        this.jZl.a(sVar);
        this.jZm.a(sVar);
        this.jZn.a(sVar);
        this.jZe.a(sVar);
        this.jZf.a(sVar);
        this.jZg.a(sVar);
        this.jZi.a(sVar);
        this.jZh.a(sVar);
        this.jZp.a(sVar);
        this.jZr.a(sVar);
        this.jZq.a(sVar);
        this.jZs.a(sVar);
        this.jZu.a(sVar);
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.mDataList;
    }

    public void onDestroy() {
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(this.mDataList)) {
            Iterator<com.baidu.adp.widget.ListView.a> it = this.jZv.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a next = it.next();
                if (next instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) next).onDestroy();
                }
            }
        }
    }
}
