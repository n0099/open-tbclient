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
    private w jRA;
    private l jRB;
    private u jRC;
    private i jRD;
    private h jRE;
    private g jRF;
    private f jRG;
    private y jRH;
    private k jRI;
    private m jRJ;
    private n jRK;
    private t jRL;
    private o jRM;
    private s jRN;
    private com.baidu.tieba.homepage.concern.adapter.d jRO;
    private p jRP;
    private e jRQ;
    private q jRR;
    private ConcernEmotionTipAdapter jRS;
    private z jRT;
    ArrayList<com.baidu.adp.widget.ListView.a> jRU;
    private BdTypeRecyclerView jRq;
    private ConcernTipAdapter jRr;
    private ConcernEmotionTipAdapter jRs;
    private com.baidu.tieba.homepage.concern.adapter.b jRt;
    private com.baidu.tieba.homepage.concern.adapter.a jRu;
    private v jRv;
    private x jRx;
    private x jRy;
    private j jRz;
    private List<com.baidu.adp.widget.ListView.n> mDataList;
    private TbPageContext<?> mPageContext;
    private ArrayList<r> jRw = new ArrayList<>();
    private List<com.baidu.adp.widget.ListView.a> jRp = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jRq = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.K(context);
        gl(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jRp);
    }

    private void gl(Context context) {
        for (int i = 0; i < com.baidu.tieba.card.data.b.iuq.size(); i++) {
            for (int i2 = 0; i2 < com.baidu.tieba.card.data.b.iur.size(); i2++) {
                this.jRw.add(new r(this.mPageContext, com.baidu.tieba.card.data.b.ius[i][i2], com.baidu.tieba.card.data.b.iuq.get(i), com.baidu.tieba.card.data.b.iur.get(i2)));
            }
        }
        this.jRx = new x(this.mPageContext, bz.eOy, com.baidu.tieba.card.data.b.iug);
        this.jRy = new x(this.mPageContext, bz.eOb, com.baidu.tieba.card.data.b.iuh);
        this.jRz = new j(this.mPageContext, bz.eOR, com.baidu.tieba.card.data.b.iug);
        this.jRA = new w(this.mPageContext, com.baidu.tieba.card.data.k.ivd);
        this.jRB = new l(this.mPageContext, com.baidu.tieba.card.data.k.eOf);
        this.jRI = new k(this.mPageContext, com.baidu.tieba.card.data.k.ivj);
        this.jRJ = new m(this.mPageContext, com.baidu.tieba.card.data.k.ivk);
        this.jRC = new u(this.mPageContext, com.baidu.tieba.card.data.k.ivi);
        this.jRD = new i(this.mPageContext, com.baidu.tieba.card.data.k.ive);
        this.jRE = new h(this.mPageContext, com.baidu.tieba.card.data.k.ivf);
        this.jRF = new g(this.mPageContext, com.baidu.tieba.card.data.k.ivg);
        this.jRH = new y(this.mPageContext, com.baidu.tieba.card.data.l.eOy);
        this.jRO = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.e.iuE);
        this.jRG = new f(this.mPageContext, com.baidu.tieba.card.data.k.ivh);
        this.jRN = new s(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.eKJ);
        this.jRK = new n(this.mPageContext, com.baidu.tieba.card.data.k.eOr);
        this.jRL = new t(this.mPageContext, com.baidu.tieba.card.data.k.eOt);
        this.jRM = new o(this.mPageContext, com.baidu.tieba.card.data.k.eOu);
        this.jRp.addAll(this.jRw);
        this.jRp.add(this.jRx);
        this.jRp.add(this.jRy);
        this.jRp.add(this.jRz);
        this.jRp.add(this.jRA);
        this.jRp.add(this.jRB);
        this.jRp.add(this.jRI);
        this.jRp.add(this.jRJ);
        this.jRp.add(this.jRC);
        this.jRp.add(this.jRD);
        this.jRp.add(this.jRE);
        this.jRp.add(this.jRF);
        this.jRp.add(this.jRH);
        this.jRp.add(this.jRG);
        this.jRp.add(this.jRN);
        this.jRp.add(this.jRK);
        this.jRp.add(this.jRL);
        this.jRp.add(this.jRM);
        this.jRr = new ConcernTipAdapter(this.mPageContext.getContext());
        this.jRs = new ConcernEmotionTipAdapter(this.mPageContext.getContext());
        this.jRt = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jRu = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.j.iuJ);
        this.jRv = new v(this.mPageContext, com.baidu.tieba.card.data.k.eOD);
        this.jRP = new p(this.mPageContext, com.baidu.tieba.card.data.k.eOE);
        this.jRQ = new e(this.mPageContext, com.baidu.tieba.card.data.k.eOF);
        this.jRR = new q(this.mPageContext, com.baidu.tieba.card.data.k.eOG);
        this.jRS = new ConcernEmotionTipAdapter(this.mPageContext.getContext(), com.baidu.tieba.homepage.concern.a.b.jTW);
        this.jRT = new z(this.mPageContext, com.baidu.tieba.card.data.k.ivc, (byte) 4);
        this.jRp.add(this.jRr);
        this.jRp.add(this.jRs);
        this.jRp.add(this.jRt);
        this.jRp.add(this.jRu);
        this.jRp.add(this.jRv);
        this.jRp.add(this.jRP);
        this.jRp.add(this.jRQ);
        this.jRp.add(this.jRR);
        this.jRp.add(this.jRO);
        this.jRp.add(this.jRS);
        this.jRp.add(this.jRT);
        Ea("page_concern");
        cMH();
    }

    private void cMH() {
        if (!bz.eOO.get()) {
            AdvertAppInfo.eJg.set(false);
            return;
        }
        this.jRU = new ArrayList<>();
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eIU, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eIX, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJb, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJc, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJd, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a7 = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJf, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a8 = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJe, "CONCERN");
        this.jRU.add(a2);
        this.jRU.add(a3);
        this.jRU.add(a4);
        this.jRU.add(a5);
        this.jRU.add(a6);
        this.jRU.add(a7);
        this.jRU.add(a8);
        this.jRp.addAll(this.jRU);
        AdvertAppInfo.eJg.set(true);
    }

    public void cC(List<com.baidu.adp.widget.ListView.n> list) {
        this.mDataList = list;
        this.jRq.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jRq != null) {
            this.jRq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.jRw.iterator();
        while (it.hasNext()) {
            it.next().fEN = bdUniqueId;
        }
        this.jRt.fEN = bdUniqueId;
        this.jRu.fEN = bdUniqueId;
        this.jRv.fEN = bdUniqueId;
        this.jRR.fEN = bdUniqueId;
        this.jRP.fEN = bdUniqueId;
        this.jRQ.fEN = bdUniqueId;
        this.jRO.fEN = bdUniqueId;
        this.jRG.fEN = bdUniqueId;
        this.jRN.fEN = bdUniqueId;
        this.jRT.fEN = bdUniqueId;
    }

    private void Ea(String str) {
        if (this.jRp != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jRp) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ea(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        Iterator<r> it = this.jRw.iterator();
        while (it.hasNext()) {
            it.next().a(sVar);
        }
        this.jRx.a(sVar);
        this.jRy.a(sVar);
        this.jRz.a(sVar);
        this.jRA.a(sVar);
        this.jRB.a(sVar);
        this.jRI.a(sVar);
        this.jRJ.a(sVar);
        this.jRC.a(sVar);
        this.jRN.a(sVar);
        this.jRK.a(sVar);
        this.jRL.a(sVar);
        this.jRM.a(sVar);
        this.jRD.a(sVar);
        this.jRE.a(sVar);
        this.jRF.a(sVar);
        this.jRH.a(sVar);
        this.jRG.a(sVar);
        this.jRO.a(sVar);
        this.jRQ.a(sVar);
        this.jRP.a(sVar);
        this.jRR.a(sVar);
        this.jRT.a(sVar);
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.mDataList;
    }

    public void onDestroy() {
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(this.mDataList)) {
            Iterator<com.baidu.adp.widget.ListView.a> it = this.jRU.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a next = it.next();
                if (next instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) next).onDestroy();
                }
            }
        }
    }
}
