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
    private BdTypeRecyclerView jIL;
    private w jIM;
    private j jIN;
    private com.baidu.tieba.homepage.concern.adapter.b jIO;
    private com.baidu.tieba.homepage.concern.adapter.a jIP;
    private x jIQ;
    private z jIS;
    private z jIT;
    private y jIU;
    private l jIV;
    private v jIW;
    private i jIX;
    private h jIY;
    private g jIZ;
    private f jJa;
    private aa jJb;
    private k jJc;
    private m jJd;
    private n jJe;
    private u jJf;
    private o jJg;
    private s jJh;
    private com.baidu.tieba.homepage.concern.adapter.d jJi;
    private p jJj;
    private e jJk;
    private q jJl;
    private j jJm;
    private ab jJn;
    ArrayList<com.baidu.adp.widget.ListView.a> jJo;
    private List<com.baidu.adp.widget.ListView.q> mDataList;
    private TbPageContext<?> mPageContext;
    private ArrayList<r> jIR = new ArrayList<>();
    private List<com.baidu.adp.widget.ListView.a> jIK = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jIL = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.J(context);
        fU(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jIK);
    }

    private void fU(Context context) {
        for (int i = 0; i < com.baidu.tieba.card.data.b.imC.size(); i++) {
            for (int i2 = 0; i2 < com.baidu.tieba.card.data.b.imD.size(); i2++) {
                this.jIR.add(new r(this.mPageContext, com.baidu.tieba.card.data.b.imE[i][i2], com.baidu.tieba.card.data.b.imC.get(i), com.baidu.tieba.card.data.b.imD.get(i2)));
            }
        }
        this.jIS = new z(this.mPageContext, by.eJq, com.baidu.tieba.card.data.b.imt);
        this.jIT = new z(this.mPageContext, by.eIT, com.baidu.tieba.card.data.b.imu);
        this.jIU = new y(this.mPageContext, com.baidu.tieba.card.data.k.inp);
        this.jIV = new l(this.mPageContext, com.baidu.tieba.card.data.k.eIX);
        this.jJc = new k(this.mPageContext, com.baidu.tieba.card.data.k.inw);
        this.jJd = new m(this.mPageContext, com.baidu.tieba.card.data.k.inx);
        this.jIW = new v(this.mPageContext, com.baidu.tieba.card.data.k.inv);
        this.jIX = new i(this.mPageContext, com.baidu.tieba.card.data.k.inq);
        this.jIY = new h(this.mPageContext, com.baidu.tieba.card.data.k.inr);
        this.jIZ = new g(this.mPageContext, com.baidu.tieba.card.data.k.f4int);
        this.jJb = new aa(this.mPageContext, com.baidu.tieba.card.data.l.eJq);
        this.jJi = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.e.imQ);
        this.jJa = new f(this.mPageContext, com.baidu.tieba.card.data.k.inu);
        this.jJh = new s(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.eFE);
        this.jJe = new n(this.mPageContext, com.baidu.tieba.card.data.k.eJj);
        this.jJf = new u(this.mPageContext, com.baidu.tieba.card.data.k.eJl);
        this.jJg = new o(this.mPageContext, com.baidu.tieba.card.data.k.eJm);
        this.jIK.addAll(this.jIR);
        this.jIK.add(this.jIS);
        this.jIK.add(this.jIT);
        this.jIK.add(this.jIU);
        this.jIK.add(this.jIV);
        this.jIK.add(this.jJc);
        this.jIK.add(this.jJd);
        this.jIK.add(this.jIW);
        this.jIK.add(this.jIX);
        this.jIK.add(this.jIY);
        this.jIK.add(this.jIZ);
        this.jIK.add(this.jJb);
        this.jIK.add(this.jJa);
        this.jIK.add(this.jJh);
        this.jIK.add(this.jJe);
        this.jIK.add(this.jJf);
        this.jIK.add(this.jJg);
        this.jIM = new w(this.mPageContext.getContext());
        this.jIN = new j(this.mPageContext.getContext());
        this.jIO = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jIP = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.j.imV);
        this.jIQ = new x(this.mPageContext, com.baidu.tieba.card.data.k.eJv);
        this.jJj = new p(this.mPageContext, com.baidu.tieba.card.data.k.eJw);
        this.jJk = new e(this.mPageContext, com.baidu.tieba.card.data.k.eJx);
        this.jJl = new q(this.mPageContext, com.baidu.tieba.card.data.k.eJy);
        this.jJm = new j(this.mPageContext.getContext(), com.baidu.tieba.homepage.concern.a.b.jLn);
        this.jJn = new ab(this.mPageContext, com.baidu.tieba.card.data.k.ino, (byte) 4);
        this.jIK.add(this.jIM);
        this.jIK.add(this.jIN);
        this.jIK.add(this.jIO);
        this.jIK.add(this.jIP);
        this.jIK.add(this.jIQ);
        this.jIK.add(this.jJj);
        this.jIK.add(this.jJk);
        this.jIK.add(this.jJl);
        this.jIK.add(this.jJi);
        this.jIK.add(this.jJm);
        this.jIK.add(this.jJn);
        Fo("page_concern");
        cNs();
    }

    private void cNs() {
        if (!by.eJG.get()) {
            AdvertAppInfo.eEb.set(false);
            return;
        }
        this.jJo = new ArrayList<>();
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDS, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDV, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDW, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDX, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDY, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a7 = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eEa, "CONCERN");
        com.baidu.adp.widget.ListView.a<?, ?> a8 = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDZ, "CONCERN");
        this.jJo.add(a2);
        this.jJo.add(a3);
        this.jJo.add(a4);
        this.jJo.add(a5);
        this.jJo.add(a6);
        this.jJo.add(a7);
        this.jJo.add(a8);
        this.jIK.addAll(this.jJo);
        AdvertAppInfo.eEb.set(true);
    }

    public void cv(List<com.baidu.adp.widget.ListView.q> list) {
        this.mDataList = list;
        this.jIL.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jIL != null) {
            this.jIL.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.jIR.iterator();
        while (it.hasNext()) {
            it.next().fzO = bdUniqueId;
        }
        this.jIO.fzO = bdUniqueId;
        this.jIP.fzO = bdUniqueId;
        this.jIQ.fzO = bdUniqueId;
        this.jJl.fzO = bdUniqueId;
        this.jJj.fzO = bdUniqueId;
        this.jJk.fzO = bdUniqueId;
        this.jJi.fzO = bdUniqueId;
        this.jJa.fzO = bdUniqueId;
        this.jJh.fzO = bdUniqueId;
        this.jJn.fzO = bdUniqueId;
    }

    private void Fo(String str) {
        if (this.jIK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jIK) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fo(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        Iterator<r> it = this.jIR.iterator();
        while (it.hasNext()) {
            it.next().a(vVar);
        }
        this.jIS.a(vVar);
        this.jIT.a(vVar);
        this.jIU.a(vVar);
        this.jIV.a(vVar);
        this.jJc.a(vVar);
        this.jJd.a(vVar);
        this.jIW.a(vVar);
        this.jJh.a(vVar);
        this.jJe.a(vVar);
        this.jJf.a(vVar);
        this.jJg.a(vVar);
        this.jIX.a(vVar);
        this.jIY.a(vVar);
        this.jIZ.a(vVar);
        this.jJb.a(vVar);
        this.jJa.a(vVar);
        this.jJi.a(vVar);
        this.jJk.a(vVar);
        this.jJj.a(vVar);
        this.jJl.a(vVar);
        this.jJn.a(vVar);
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.mDataList;
    }

    public void onDestroy() {
        if (!com.baidu.tieba.lego.card.d.a.isEmpty(this.mDataList)) {
            Iterator<com.baidu.adp.widget.ListView.a> it = this.jJo.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a next = it.next();
                if (next instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) next).onDestroy();
                }
            }
        }
    }
}
