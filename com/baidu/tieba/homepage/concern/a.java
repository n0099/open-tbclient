package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bz;
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
    private BdTypeRecyclerView jVV;
    private ConcernTipAdapter jVW;
    private ConcernEmotionTipAdapter jVX;
    private com.baidu.tieba.homepage.concern.adapter.b jVY;
    private com.baidu.tieba.homepage.concern.adapter.a jVZ;
    private v jWa;
    private x jWc;
    private x jWd;
    private j jWe;
    private w jWf;
    private l jWg;
    private u jWh;
    private i jWi;
    private h jWj;
    private g jWk;
    private f jWl;
    private y jWm;
    private k jWn;
    private m jWo;
    private n jWp;
    private t jWq;
    private o jWr;
    private s jWs;
    private com.baidu.tieba.homepage.concern.adapter.d jWt;
    private p jWu;
    private e jWv;
    private q jWw;
    private ConcernEmotionTipAdapter jWx;
    private z jWy;
    ArrayList<com.baidu.adp.widget.ListView.a> jWz;
    private List<com.baidu.adp.widget.ListView.n> mDataList;
    private TbPageContext<?> mPageContext;
    private ArrayList<r> jWb = new ArrayList<>();
    private List<com.baidu.adp.widget.ListView.a> jVU = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jVV = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.K(context);
        gn(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jVU);
    }

    private void gn(Context context) {
        for (int i = 0; i < com.baidu.tieba.card.data.b.iyX.size(); i++) {
            for (int i2 = 0; i2 < com.baidu.tieba.card.data.b.iyY.size(); i2++) {
                this.jWb.add(new r(this.mPageContext, com.baidu.tieba.card.data.b.iyZ[i][i2], com.baidu.tieba.card.data.b.iyX.get(i), com.baidu.tieba.card.data.b.iyY.get(i2)));
            }
        }
        this.jWc = new x(this.mPageContext, bz.eTj, com.baidu.tieba.card.data.b.iyN);
        this.jWd = new x(this.mPageContext, bz.eSM, com.baidu.tieba.card.data.b.iyO);
        this.jWe = new j(this.mPageContext, bz.eTC, com.baidu.tieba.card.data.b.iyN);
        this.jWf = new w(this.mPageContext, com.baidu.tieba.card.data.k.izK);
        this.jWg = new l(this.mPageContext, com.baidu.tieba.card.data.k.eSQ);
        this.jWn = new k(this.mPageContext, com.baidu.tieba.card.data.k.izQ);
        this.jWo = new m(this.mPageContext, com.baidu.tieba.card.data.k.izR);
        this.jWh = new u(this.mPageContext, com.baidu.tieba.card.data.k.izP);
        this.jWi = new i(this.mPageContext, com.baidu.tieba.card.data.k.izL);
        this.jWj = new h(this.mPageContext, com.baidu.tieba.card.data.k.izM);
        this.jWk = new g(this.mPageContext, com.baidu.tieba.card.data.k.izN);
        this.jWm = new y(this.mPageContext, com.baidu.tieba.card.data.l.eTj);
        this.jWt = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.e.izl);
        this.jWl = new f(this.mPageContext, com.baidu.tieba.card.data.k.izO);
        this.jWs = new s(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.ePu);
        this.jWp = new n(this.mPageContext, com.baidu.tieba.card.data.k.eTc);
        this.jWq = new t(this.mPageContext, com.baidu.tieba.card.data.k.eTe);
        this.jWr = new o(this.mPageContext, com.baidu.tieba.card.data.k.eTf);
        this.jVU.addAll(this.jWb);
        this.jVU.add(this.jWc);
        this.jVU.add(this.jWd);
        this.jVU.add(this.jWe);
        this.jVU.add(this.jWf);
        this.jVU.add(this.jWg);
        this.jVU.add(this.jWn);
        this.jVU.add(this.jWo);
        this.jVU.add(this.jWh);
        this.jVU.add(this.jWi);
        this.jVU.add(this.jWj);
        this.jVU.add(this.jWk);
        this.jVU.add(this.jWm);
        this.jVU.add(this.jWl);
        this.jVU.add(this.jWs);
        this.jVU.add(this.jWp);
        this.jVU.add(this.jWq);
        this.jVU.add(this.jWr);
        this.jVW = new ConcernTipAdapter(this.mPageContext.getContext());
        this.jVX = new ConcernEmotionTipAdapter(this.mPageContext.getContext());
        this.jVY = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jVZ = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.j.izq);
        this.jWa = new v(this.mPageContext, com.baidu.tieba.card.data.k.eTo);
        this.jWu = new p(this.mPageContext, com.baidu.tieba.card.data.k.eTp);
        this.jWv = new e(this.mPageContext, com.baidu.tieba.card.data.k.eTq);
        this.jWw = new q(this.mPageContext, com.baidu.tieba.card.data.k.eTr);
        this.jWx = new ConcernEmotionTipAdapter(this.mPageContext.getContext(), com.baidu.tieba.homepage.concern.a.b.jYB);
        this.jWy = new z(this.mPageContext, com.baidu.tieba.card.data.k.izJ, (byte) 4);
        this.jVU.add(this.jVW);
        this.jVU.add(this.jVX);
        this.jVU.add(this.jVY);
        this.jVU.add(this.jVZ);
        this.jVU.add(this.jWa);
        this.jVU.add(this.jWu);
        this.jVU.add(this.jWv);
        this.jVU.add(this.jWw);
        this.jVU.add(this.jWt);
        this.jVU.add(this.jWx);
        this.jVU.add(this.jWy);
        Fl("page_concern");
        cQz();
    }

    private void cQz() {
        if (!bz.eTz.get()) {
            AdvertAppInfo.eNR.set(false);
            return;
        }
        this.jWz = new ArrayList<>();
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dEW().a(this.mPageContext, AdvertAppInfo.eNF, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dEW().a(this.mPageContext, AdvertAppInfo.eNI, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dEW().a(this.mPageContext, AdvertAppInfo.eNM, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.r.dEW().a(this.mPageContext, AdvertAppInfo.eNN, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.r.dEW().a(this.mPageContext, AdvertAppInfo.eNO, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a7 = com.baidu.tieba.recapp.r.dEW().a(this.mPageContext, AdvertAppInfo.eNQ, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a8 = com.baidu.tieba.recapp.r.dEW().a(this.mPageContext, AdvertAppInfo.eNP, "CONCERN");
        this.jWz.add(a2);
        this.jWz.add(a3);
        this.jWz.add(a4);
        this.jWz.add(a5);
        this.jWz.add(a6);
        this.jWz.add(a7);
        this.jWz.add(a8);
        this.jVU.addAll(this.jWz);
        AdvertAppInfo.eNR.set(true);
    }

    public void cC(List<com.baidu.adp.widget.ListView.n> list) {
        this.mDataList = list;
        this.jVV.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jVV != null) {
            this.jVV.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.jWb.iterator();
        while (it.hasNext()) {
            it.next().fJu = bdUniqueId;
        }
        this.jVY.fJu = bdUniqueId;
        this.jVZ.fJu = bdUniqueId;
        this.jWa.fJu = bdUniqueId;
        this.jWw.fJu = bdUniqueId;
        this.jWu.fJu = bdUniqueId;
        this.jWv.fJu = bdUniqueId;
        this.jWt.fJu = bdUniqueId;
        this.jWl.fJu = bdUniqueId;
        this.jWs.fJu = bdUniqueId;
        this.jWy.fJu = bdUniqueId;
    }

    private void Fl(String str) {
        if (this.jVU != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jVU) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fl(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        Iterator<r> it = this.jWb.iterator();
        while (it.hasNext()) {
            it.next().a(sVar);
        }
        this.jWc.a(sVar);
        this.jWd.a(sVar);
        this.jWe.a(sVar);
        this.jWf.a(sVar);
        this.jWg.a(sVar);
        this.jWn.a(sVar);
        this.jWo.a(sVar);
        this.jWh.a(sVar);
        this.jWs.a(sVar);
        this.jWp.a(sVar);
        this.jWq.a(sVar);
        this.jWr.a(sVar);
        this.jWi.a(sVar);
        this.jWj.a(sVar);
        this.jWk.a(sVar);
        this.jWm.a(sVar);
        this.jWl.a(sVar);
        this.jWt.a(sVar);
        this.jWv.a(sVar);
        this.jWu.a(sVar);
        this.jWw.a(sVar);
        this.jWy.a(sVar);
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.mDataList;
    }

    public void onDestroy() {
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(this.mDataList)) {
            Iterator<com.baidu.adp.widget.ListView.a> it = this.jWz.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a next = it.next();
                if (next instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) next).onDestroy();
                }
            }
        }
    }
}
