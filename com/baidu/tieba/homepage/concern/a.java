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
    private List<com.baidu.adp.widget.ListView.a> juB = new ArrayList();
    private BdTypeRecyclerView juC;
    private v juD;
    private i juE;
    private com.baidu.tieba.homepage.concern.adapter.b juF;
    private com.baidu.tieba.homepage.concern.adapter.a juG;
    private w juH;
    private x juI;
    private k juJ;
    private u juK;
    private h juL;
    private g juM;
    private f juN;
    private e juO;
    private y juP;
    private j juQ;
    private l juR;
    private m juS;
    private t juT;
    private n juU;
    private r juV;
    private com.baidu.tieba.homepage.concern.adapter.c juW;
    private o juX;
    private com.baidu.tieba.homepage.concern.adapter.d juY;
    private p juZ;
    private q jva;
    private z jvb;
    private List<com.baidu.adp.widget.ListView.q> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.juC = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fp(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.juB);
    }

    private void fp(Context context) {
        this.juI = new x(this.mPageContext, com.baidu.tieba.card.data.l.ibz);
        this.juJ = new k(this.mPageContext, com.baidu.tieba.card.data.l.eDE);
        this.juQ = new j(this.mPageContext, com.baidu.tieba.card.data.l.ibF);
        this.juR = new l(this.mPageContext, com.baidu.tieba.card.data.l.ibG);
        this.juK = new u(this.mPageContext, com.baidu.tieba.card.data.l.ibE);
        this.juL = new h(this.mPageContext, com.baidu.tieba.card.data.l.ibA);
        this.juM = new g(this.mPageContext, com.baidu.tieba.card.data.l.ibB);
        this.juN = new f(this.mPageContext, com.baidu.tieba.card.data.l.ibC);
        this.juP = new y(this.mPageContext, com.baidu.tieba.card.data.m.eDW);
        this.juW = new com.baidu.tieba.homepage.concern.adapter.c(this.mPageContext, com.baidu.tieba.card.data.f.iaZ);
        this.juO = new e(this.mPageContext, com.baidu.tieba.card.data.l.ibD);
        this.juV = new r(this.mPageContext, com.baidu.tieba.homepage.concern.a.b.eAo);
        this.juS = new m(this.mPageContext, com.baidu.tieba.card.data.l.eDQ);
        this.juT = new t(this.mPageContext, com.baidu.tieba.card.data.l.eDS);
        this.juU = new n(this.mPageContext, com.baidu.tieba.card.data.l.eDT);
        this.juB.add(this.juI);
        this.juB.add(this.juJ);
        this.juB.add(this.juQ);
        this.juB.add(this.juR);
        this.juB.add(this.juK);
        this.juB.add(this.juL);
        this.juB.add(this.juM);
        this.juB.add(this.juN);
        this.juB.add(this.juP);
        this.juB.add(this.juO);
        this.juB.add(this.juV);
        this.juB.add(this.juS);
        this.juB.add(this.juT);
        this.juB.add(this.juU);
        this.juD = new v(this.mPageContext.getContext());
        this.juE = new i(this.mPageContext.getContext());
        this.juF = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.juG = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.k.ibe);
        this.juH = new w(this.mPageContext, com.baidu.tieba.card.data.l.eEb);
        this.juX = new o(this.mPageContext, com.baidu.tieba.card.data.l.eEc);
        this.juY = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.l.eEd);
        this.juZ = new p(this.mPageContext, com.baidu.tieba.card.data.l.eEe);
        this.jva = new q(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.jwR);
        this.jvb = new z(this.mPageContext, com.baidu.tieba.card.data.l.iby, (byte) 4);
        this.juB.add(this.juD);
        this.juB.add(this.juE);
        this.juB.add(this.juF);
        this.juB.add(this.juG);
        this.juB.add(this.juH);
        this.juB.add(this.juX);
        this.juB.add(this.juY);
        this.juB.add(this.juZ);
        this.juB.add(this.juW);
        this.juB.add(this.jva);
        this.juB.add(this.jvb);
        EZ("page_concern");
    }

    public void cr(List<com.baidu.adp.widget.ListView.q> list) {
        this.mDataList = list;
        this.juC.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.juC != null) {
            this.juC.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.juF.fsQ = bdUniqueId;
        this.juG.fsQ = bdUniqueId;
        this.juH.fsQ = bdUniqueId;
        this.juZ.fsQ = bdUniqueId;
        this.juX.fsQ = bdUniqueId;
        this.juY.fsQ = bdUniqueId;
        this.juW.fsQ = bdUniqueId;
        this.juO.fsQ = bdUniqueId;
        this.juV.fsQ = bdUniqueId;
        this.jvb.fsQ = bdUniqueId;
    }

    private void EZ(String str) {
        if (this.juB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.juB) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EZ(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.juI.a(vVar);
        this.juJ.a(vVar);
        this.juQ.a(vVar);
        this.juR.a(vVar);
        this.juK.a(vVar);
        this.juV.a(vVar);
        this.juS.a(vVar);
        this.juT.a(vVar);
        this.juU.a(vVar);
        this.juL.a(vVar);
        this.juM.a(vVar);
        this.juN.a(vVar);
        this.juP.a(vVar);
        this.juO.a(vVar);
        this.juW.a(vVar);
        this.juY.a(vVar);
        this.juX.a(vVar);
        this.juZ.a(vVar);
        this.jvb.a(vVar);
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.mDataList;
    }
}
