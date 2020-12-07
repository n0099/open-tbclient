package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.homepage.concern.adapter.aa;
import com.baidu.tieba.homepage.concern.adapter.ab;
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
import com.baidu.tieba.homepage.concern.adapter.u;
import com.baidu.tieba.homepage.concern.adapter.v;
import com.baidu.tieba.homepage.concern.adapter.w;
import com.baidu.tieba.homepage.concern.adapter.x;
import com.baidu.tieba.homepage.concern.adapter.y;
import com.baidu.tieba.homepage.concern.adapter.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView jIJ;
    private w jIK;
    private j jIL;
    private com.baidu.tieba.homepage.concern.adapter.b jIM;
    private com.baidu.tieba.homepage.concern.adapter.a jIN;
    private x jIO;
    private z jIQ;
    private z jIR;
    private y jIS;
    private l jIT;
    private v jIU;
    private i jIV;
    private h jIW;
    private g jIX;
    private f jIY;
    private aa jIZ;
    private k jJa;
    private m jJb;
    private n jJc;
    private u jJd;
    private o jJe;
    private s jJf;
    private com.baidu.tieba.homepage.concern.adapter.d jJg;
    private p jJh;
    private e jJi;
    private q jJj;
    private j jJk;
    private ab jJl;
    ArrayList<com.baidu.adp.widget.ListView.a> jJm;
    private List<com.baidu.adp.widget.ListView.q> mDataList;
    private TbPageContext<?> mPageContext;
    private ArrayList<r> jIP = new ArrayList<>();
    private List<com.baidu.adp.widget.ListView.a> jII = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jIJ = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.J(context);
        fU(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jII);
    }

    private void fU(Context context) {
        for (int i = 0; i < com.baidu.tieba.card.data.b.imA.size(); i++) {
            for (int i2 = 0; i2 < com.baidu.tieba.card.data.b.imB.size(); i2++) {
                this.jIP.add(new r(this.mPageContext, com.baidu.tieba.card.data.b.imC[i][i2], com.baidu.tieba.card.data.b.imA.get(i), com.baidu.tieba.card.data.b.imB.get(i2)));
            }
        }
        this.jIQ = new z(this.mPageContext, by.eJq, com.baidu.tieba.card.data.b.imr);
        this.jIR = new z(this.mPageContext, by.eIT, com.baidu.tieba.card.data.b.ims);
        this.jIS = new y(this.mPageContext, com.baidu.tieba.card.data.k.inn);
        this.jIT = new l(this.mPageContext, com.baidu.tieba.card.data.k.eIX);
        this.jJa = new k(this.mPageContext, com.baidu.tieba.card.data.k.inu);
        this.jJb = new m(this.mPageContext, com.baidu.tieba.card.data.k.inv);
        this.jIU = new v(this.mPageContext, com.baidu.tieba.card.data.k.f4int);
        this.jIV = new i(this.mPageContext, com.baidu.tieba.card.data.k.ino);
        this.jIW = new h(this.mPageContext, com.baidu.tieba.card.data.k.inp);
        this.jIX = new g(this.mPageContext, com.baidu.tieba.card.data.k.inq);
        this.jIZ = new aa(this.mPageContext, com.baidu.tieba.card.data.l.eJq);
        this.jJg = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.e.imO);
        this.jIY = new f(this.mPageContext, com.baidu.tieba.card.data.k.inr);
        this.jJf = new s(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.eFE);
        this.jJc = new n(this.mPageContext, com.baidu.tieba.card.data.k.eJj);
        this.jJd = new u(this.mPageContext, com.baidu.tieba.card.data.k.eJl);
        this.jJe = new o(this.mPageContext, com.baidu.tieba.card.data.k.eJm);
        this.jII.addAll(this.jIP);
        this.jII.add(this.jIQ);
        this.jII.add(this.jIR);
        this.jII.add(this.jIS);
        this.jII.add(this.jIT);
        this.jII.add(this.jJa);
        this.jII.add(this.jJb);
        this.jII.add(this.jIU);
        this.jII.add(this.jIV);
        this.jII.add(this.jIW);
        this.jII.add(this.jIX);
        this.jII.add(this.jIZ);
        this.jII.add(this.jIY);
        this.jII.add(this.jJf);
        this.jII.add(this.jJc);
        this.jII.add(this.jJd);
        this.jII.add(this.jJe);
        this.jIK = new w(this.mPageContext.getContext());
        this.jIL = new j(this.mPageContext.getContext());
        this.jIM = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jIN = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.j.imT);
        this.jIO = new x(this.mPageContext, com.baidu.tieba.card.data.k.eJv);
        this.jJh = new p(this.mPageContext, com.baidu.tieba.card.data.k.eJw);
        this.jJi = new e(this.mPageContext, com.baidu.tieba.card.data.k.eJx);
        this.jJj = new q(this.mPageContext, com.baidu.tieba.card.data.k.eJy);
        this.jJk = new j(this.mPageContext.getContext(), com.baidu.tieba.homepage.concern.a.b.jLl);
        this.jJl = new ab(this.mPageContext, com.baidu.tieba.card.data.k.inm, (byte) 4);
        this.jII.add(this.jIK);
        this.jII.add(this.jIL);
        this.jII.add(this.jIM);
        this.jII.add(this.jIN);
        this.jII.add(this.jIO);
        this.jII.add(this.jJh);
        this.jII.add(this.jJi);
        this.jII.add(this.jJj);
        this.jII.add(this.jJg);
        this.jII.add(this.jJk);
        this.jII.add(this.jJl);
        Fo("page_concern");
        cNr();
    }

    private void cNr() {
        if (!by.eJG.get()) {
            AdvertAppInfo.eEb.set(false);
            return;
        }
        this.jJm = new ArrayList<>();
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDS, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDV, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDW, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDX, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDY, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a7 = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eEa, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a8 = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDZ, "CONCERN");
        this.jJm.add(a2);
        this.jJm.add(a3);
        this.jJm.add(a4);
        this.jJm.add(a5);
        this.jJm.add(a6);
        this.jJm.add(a7);
        this.jJm.add(a8);
        this.jII.addAll(this.jJm);
        AdvertAppInfo.eEb.set(true);
    }

    public void cv(List<com.baidu.adp.widget.ListView.q> list) {
        this.mDataList = list;
        this.jIJ.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jIJ != null) {
            this.jIJ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.jIP.iterator();
        while (it.hasNext()) {
            it.next().fzO = bdUniqueId;
        }
        this.jIM.fzO = bdUniqueId;
        this.jIN.fzO = bdUniqueId;
        this.jIO.fzO = bdUniqueId;
        this.jJj.fzO = bdUniqueId;
        this.jJh.fzO = bdUniqueId;
        this.jJi.fzO = bdUniqueId;
        this.jJg.fzO = bdUniqueId;
        this.jIY.fzO = bdUniqueId;
        this.jJf.fzO = bdUniqueId;
        this.jJl.fzO = bdUniqueId;
    }

    private void Fo(String str) {
        if (this.jII != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jII) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fo(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        Iterator<r> it = this.jIP.iterator();
        while (it.hasNext()) {
            it.next().a(vVar);
        }
        this.jIQ.a(vVar);
        this.jIR.a(vVar);
        this.jIS.a(vVar);
        this.jIT.a(vVar);
        this.jJa.a(vVar);
        this.jJb.a(vVar);
        this.jIU.a(vVar);
        this.jJf.a(vVar);
        this.jJc.a(vVar);
        this.jJd.a(vVar);
        this.jJe.a(vVar);
        this.jIV.a(vVar);
        this.jIW.a(vVar);
        this.jIX.a(vVar);
        this.jIZ.a(vVar);
        this.jIY.a(vVar);
        this.jJg.a(vVar);
        this.jJi.a(vVar);
        this.jJh.a(vVar);
        this.jJj.a(vVar);
        this.jJl.a(vVar);
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.mDataList;
    }

    public void onDestroy() {
        if (!com.baidu.tieba.lego.card.d.a.isEmpty(this.mDataList)) {
            Iterator<com.baidu.adp.widget.ListView.a> it = this.jJm.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a next = it.next();
                if (next instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) next).onDestroy();
                }
            }
        }
    }
}
