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
    private m kbA;
    private n kbB;
    private t kbC;
    private o kbD;
    private s kbE;
    private com.baidu.tieba.homepage.concern.adapter.d kbF;
    private p kbG;
    private e kbH;
    private q kbI;
    private ConcernEmotionTipAdapter kbJ;
    private z kbK;
    ArrayList<com.baidu.adp.widget.ListView.a> kbL;
    private BdTypeRecyclerView kbh;
    private ConcernTipAdapter kbi;
    private ConcernEmotionTipAdapter kbj;
    private com.baidu.tieba.homepage.concern.adapter.b kbk;
    private com.baidu.tieba.homepage.concern.adapter.a kbl;
    private v kbm;
    private x kbo;
    private x kbp;
    private j kbq;
    private w kbr;
    private l kbs;
    private u kbt;
    private i kbu;
    private h kbv;
    private g kbw;
    private f kbx;
    private y kby;
    private k kbz;
    private List<com.baidu.adp.widget.ListView.n> mDataList;
    private TbPageContext<?> mPageContext;
    private ArrayList<r> kbn = new ArrayList<>();
    private List<com.baidu.adp.widget.ListView.a> jPR = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kbh = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.J(context);
        gl(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jPR);
    }

    private void gl(Context context) {
        for (int i = 0; i < com.baidu.tieba.card.data.b.iBX.size(); i++) {
            for (int i2 = 0; i2 < com.baidu.tieba.card.data.b.iBY.size(); i2++) {
                this.kbn.add(new r(this.mPageContext, com.baidu.tieba.card.data.b.iBZ[i][i2], com.baidu.tieba.card.data.b.iBX.get(i), com.baidu.tieba.card.data.b.iBY.get(i2)));
            }
        }
        this.kbo = new x(this.mPageContext, cb.eSl, com.baidu.tieba.card.data.b.iBN);
        this.kbp = new x(this.mPageContext, cb.eRO, com.baidu.tieba.card.data.b.iBO);
        this.kbq = new j(this.mPageContext, cb.eSE, com.baidu.tieba.card.data.b.iBN);
        this.kbr = new w(this.mPageContext, com.baidu.tieba.card.data.k.iCK);
        this.kbs = new l(this.mPageContext, com.baidu.tieba.card.data.k.eRS);
        this.kbz = new k(this.mPageContext, com.baidu.tieba.card.data.k.iCQ);
        this.kbA = new m(this.mPageContext, com.baidu.tieba.card.data.k.iCR);
        this.kbt = new u(this.mPageContext, com.baidu.tieba.card.data.k.iCP);
        this.kbu = new i(this.mPageContext, com.baidu.tieba.card.data.k.iCL);
        this.kbv = new h(this.mPageContext, com.baidu.tieba.card.data.k.iCM);
        this.kbw = new g(this.mPageContext, com.baidu.tieba.card.data.k.iCN);
        this.kby = new y(this.mPageContext, com.baidu.tieba.card.data.l.eSl);
        this.kbF = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.e.iCl);
        this.kbx = new f(this.mPageContext, com.baidu.tieba.card.data.k.iCO);
        this.kbE = new s(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.eOw);
        this.kbB = new n(this.mPageContext, com.baidu.tieba.card.data.k.eSe);
        this.kbC = new t(this.mPageContext, com.baidu.tieba.card.data.k.eSg);
        this.kbD = new o(this.mPageContext, com.baidu.tieba.card.data.k.eSh);
        this.jPR.addAll(this.kbn);
        this.jPR.add(this.kbo);
        this.jPR.add(this.kbp);
        this.jPR.add(this.kbq);
        this.jPR.add(this.kbr);
        this.jPR.add(this.kbs);
        this.jPR.add(this.kbz);
        this.jPR.add(this.kbA);
        this.jPR.add(this.kbt);
        this.jPR.add(this.kbu);
        this.jPR.add(this.kbv);
        this.jPR.add(this.kbw);
        this.jPR.add(this.kby);
        this.jPR.add(this.kbx);
        this.jPR.add(this.kbE);
        this.jPR.add(this.kbB);
        this.jPR.add(this.kbC);
        this.jPR.add(this.kbD);
        this.kbi = new ConcernTipAdapter(this.mPageContext.getContext());
        this.kbj = new ConcernEmotionTipAdapter(this.mPageContext.getContext());
        this.kbk = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.kbl = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.j.iCq);
        this.kbm = new v(this.mPageContext, com.baidu.tieba.card.data.k.eSq);
        this.kbG = new p(this.mPageContext, com.baidu.tieba.card.data.k.eSr);
        this.kbH = new e(this.mPageContext, com.baidu.tieba.card.data.k.eSs);
        this.kbI = new q(this.mPageContext, com.baidu.tieba.card.data.k.eSt);
        this.kbJ = new ConcernEmotionTipAdapter(this.mPageContext.getContext(), com.baidu.tieba.homepage.concern.a.b.kdN);
        this.kbK = new z(this.mPageContext, com.baidu.tieba.card.data.k.iCJ, (byte) 4);
        this.jPR.add(this.kbi);
        this.jPR.add(this.kbj);
        this.jPR.add(this.kbk);
        this.jPR.add(this.kbl);
        this.jPR.add(this.kbm);
        this.jPR.add(this.kbG);
        this.jPR.add(this.kbH);
        this.jPR.add(this.kbI);
        this.jPR.add(this.kbF);
        this.jPR.add(this.kbJ);
        this.jPR.add(this.kbK);
        ED("page_concern");
        cOS();
    }

    private void cOS() {
        if (!cb.eSB.get()) {
            AdvertAppInfo.eMT.set(false);
            return;
        }
        this.kbL = new ArrayList<>();
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMH, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMK, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMO, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMP, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMQ, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a7 = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMS, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a8 = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMR, "CONCERN");
        this.kbL.add(a2);
        this.kbL.add(a3);
        this.kbL.add(a4);
        this.kbL.add(a5);
        this.kbL.add(a6);
        this.kbL.add(a7);
        this.kbL.add(a8);
        this.jPR.addAll(this.kbL);
        AdvertAppInfo.eMT.set(true);
    }

    public void cx(List<com.baidu.adp.widget.ListView.n> list) {
        this.mDataList = list;
        this.kbh.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.kbh != null) {
            this.kbh.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.kbn.iterator();
        while (it.hasNext()) {
            it.next().fIy = bdUniqueId;
        }
        this.kbk.fIy = bdUniqueId;
        this.kbl.fIy = bdUniqueId;
        this.kbm.fIy = bdUniqueId;
        this.kbI.fIy = bdUniqueId;
        this.kbG.fIy = bdUniqueId;
        this.kbH.fIy = bdUniqueId;
        this.kbF.fIy = bdUniqueId;
        this.kbx.fIy = bdUniqueId;
        this.kbE.fIy = bdUniqueId;
        this.kbK.fIy = bdUniqueId;
    }

    private void ED(String str) {
        if (this.jPR != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jPR) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).ED(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        Iterator<r> it = this.kbn.iterator();
        while (it.hasNext()) {
            it.next().a(sVar);
        }
        this.kbo.a(sVar);
        this.kbp.a(sVar);
        this.kbq.a(sVar);
        this.kbr.a(sVar);
        this.kbs.a(sVar);
        this.kbz.a(sVar);
        this.kbA.a(sVar);
        this.kbt.a(sVar);
        this.kbE.a(sVar);
        this.kbB.a(sVar);
        this.kbC.a(sVar);
        this.kbD.a(sVar);
        this.kbu.a(sVar);
        this.kbv.a(sVar);
        this.kbw.a(sVar);
        this.kby.a(sVar);
        this.kbx.a(sVar);
        this.kbF.a(sVar);
        this.kbH.a(sVar);
        this.kbG.a(sVar);
        this.kbI.a(sVar);
        this.kbK.a(sVar);
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.mDataList;
    }

    public void onDestroy() {
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(this.mDataList)) {
            Iterator<com.baidu.adp.widget.ListView.a> it = this.kbL.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a next = it.next();
                if (next instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) next).onDestroy();
                }
            }
        }
    }
}
