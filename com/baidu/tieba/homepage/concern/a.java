package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tieba.homepage.concern.adapter.t;
import com.baidu.tieba.homepage.concern.adapter.u;
import com.baidu.tieba.homepage.concern.adapter.v;
import com.baidu.tieba.homepage.concern.adapter.w;
import com.baidu.tieba.homepage.concern.adapter.x;
import com.baidu.tieba.homepage.concern.adapter.y;
import com.baidu.tieba.homepage.concern.adapter.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> joE = new ArrayList();
    private BdTypeRecyclerView joF;
    private v joG;
    private i joH;
    private com.baidu.tieba.homepage.concern.adapter.b joI;
    private com.baidu.tieba.homepage.concern.adapter.a joJ;
    private w joK;
    private x joL;
    private k joM;
    private u joN;
    private h joO;
    private g joP;
    private f joQ;
    private e joR;
    private y joS;
    private j joT;
    private l joU;
    private m joV;
    private t joW;
    private n joX;
    private r joY;
    private com.baidu.tieba.homepage.concern.adapter.c joZ;
    private o jpa;
    private com.baidu.tieba.homepage.concern.adapter.d jpb;
    private p jpc;
    private q jpd;
    private z jpe;
    private List<com.baidu.adp.widget.ListView.q> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.joF = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fp(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.joE);
    }

    private void fp(Context context) {
        this.joL = new x(this.mPageContext, com.baidu.tieba.card.data.l.hVC);
        this.joM = new k(this.mPageContext, com.baidu.tieba.card.data.l.exN);
        this.joT = new j(this.mPageContext, com.baidu.tieba.card.data.l.hVI);
        this.joU = new l(this.mPageContext, com.baidu.tieba.card.data.l.hVJ);
        this.joN = new u(this.mPageContext, com.baidu.tieba.card.data.l.hVH);
        this.joO = new h(this.mPageContext, com.baidu.tieba.card.data.l.hVD);
        this.joP = new g(this.mPageContext, com.baidu.tieba.card.data.l.hVE);
        this.joQ = new f(this.mPageContext, com.baidu.tieba.card.data.l.hVF);
        this.joS = new y(this.mPageContext, com.baidu.tieba.card.data.m.eyg);
        this.joZ = new com.baidu.tieba.homepage.concern.adapter.c(this.mPageContext, com.baidu.tieba.card.data.f.hVc);
        this.joR = new e(this.mPageContext, com.baidu.tieba.card.data.l.hVG);
        this.joY = new r(this.mPageContext, com.baidu.tieba.homepage.concern.a.b.euv);
        this.joV = new m(this.mPageContext, com.baidu.tieba.card.data.l.exZ);
        this.joW = new t(this.mPageContext, com.baidu.tieba.card.data.l.eyb);
        this.joX = new n(this.mPageContext, com.baidu.tieba.card.data.l.eyc);
        this.joE.add(this.joL);
        this.joE.add(this.joM);
        this.joE.add(this.joT);
        this.joE.add(this.joU);
        this.joE.add(this.joN);
        this.joE.add(this.joO);
        this.joE.add(this.joP);
        this.joE.add(this.joQ);
        this.joE.add(this.joS);
        this.joE.add(this.joR);
        this.joE.add(this.joY);
        this.joE.add(this.joV);
        this.joE.add(this.joW);
        this.joE.add(this.joX);
        this.joG = new v(this.mPageContext.getContext());
        this.joH = new i(this.mPageContext.getContext());
        this.joI = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.joJ = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.k.hVh);
        this.joK = new w(this.mPageContext, com.baidu.tieba.card.data.l.eyl);
        this.jpa = new o(this.mPageContext, com.baidu.tieba.card.data.l.eyn);
        this.jpb = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.l.eyo);
        this.jpc = new p(this.mPageContext, com.baidu.tieba.card.data.l.eyp);
        this.jpd = new q(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.jqU);
        this.jpe = new z(this.mPageContext, com.baidu.tieba.card.data.l.hVB, (byte) 4);
        this.joE.add(this.joG);
        this.joE.add(this.joH);
        this.joE.add(this.joI);
        this.joE.add(this.joJ);
        this.joE.add(this.joK);
        this.joE.add(this.jpa);
        this.joE.add(this.jpb);
        this.joE.add(this.jpc);
        this.joE.add(this.joZ);
        this.joE.add(this.jpd);
        this.joE.add(this.jpe);
        EL("page_concern");
    }

    public void ck(List<com.baidu.adp.widget.ListView.q> list) {
        this.mDataList = list;
        this.joF.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.joF != null) {
            this.joF.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.joI.fmX = bdUniqueId;
        this.joJ.fmX = bdUniqueId;
        this.joK.fmX = bdUniqueId;
        this.jpc.fmX = bdUniqueId;
        this.jpa.fmX = bdUniqueId;
        this.jpb.fmX = bdUniqueId;
        this.joZ.fmX = bdUniqueId;
        this.joR.fmX = bdUniqueId;
        this.joY.fmX = bdUniqueId;
        this.jpe.fmX = bdUniqueId;
    }

    private void EL(String str) {
        if (this.joE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.joE) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EL(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.joL.a(vVar);
        this.joM.a(vVar);
        this.joT.a(vVar);
        this.joU.a(vVar);
        this.joN.a(vVar);
        this.joY.a(vVar);
        this.joV.a(vVar);
        this.joW.a(vVar);
        this.joX.a(vVar);
        this.joO.a(vVar);
        this.joP.a(vVar);
        this.joQ.a(vVar);
        this.joS.a(vVar);
        this.joR.a(vVar);
        this.joZ.a(vVar);
        this.jpb.a(vVar);
        this.jpa.a(vVar);
        this.jpc.a(vVar);
        this.jpe.a(vVar);
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.mDataList;
    }
}
