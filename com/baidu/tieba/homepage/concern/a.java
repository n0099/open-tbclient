package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tieba.homepage.concern.a.o;
import com.baidu.tieba.homepage.concern.a.p;
import com.baidu.tieba.homepage.concern.a.r;
import com.baidu.tieba.homepage.concern.a.s;
import com.baidu.tieba.homepage.concern.a.t;
import com.baidu.tieba.homepage.concern.a.u;
import com.baidu.tieba.homepage.concern.a.v;
import com.baidu.tieba.homepage.concern.a.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.tieba.homepage.concern.a.a ilA;
    private u ilB;
    private v ilC;
    private s ilD;
    private g ilE;
    private f ilF;
    private e ilG;
    private d ilH;
    private w ilI;
    private i ilJ;
    private j ilK;
    private k ilL;
    private r ilM;
    private l ilN;
    private p ilO;
    private com.baidu.tieba.homepage.concern.a.b ilP;
    private m ilQ;
    private com.baidu.tieba.homepage.concern.a.c ilR;
    private n ilS;
    private o ilT;
    private List<com.baidu.adp.widget.ListView.a> ilw = new ArrayList();
    private BdTypeRecyclerView ilx;
    private t ily;
    private h ilz;
    private List<q> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ilx = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eL(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.ilw);
    }

    private void eL(Context context) {
        this.ilC = new v(this.mPageContext, com.baidu.tieba.card.data.k.gUF);
        this.ilJ = new i(this.mPageContext, com.baidu.tieba.card.data.k.gUM);
        this.ilK = new j(this.mPageContext, com.baidu.tieba.card.data.k.gUN);
        this.ilD = new s(this.mPageContext, com.baidu.tieba.card.data.k.gUL);
        this.ilE = new g(this.mPageContext, com.baidu.tieba.card.data.k.gUH);
        this.ilF = new f(this.mPageContext, com.baidu.tieba.card.data.k.gUI);
        this.ilG = new e(this.mPageContext, com.baidu.tieba.card.data.k.gUJ);
        this.ilI = new w(this.mPageContext, com.baidu.tieba.card.data.l.dLH);
        this.ilP = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.e.gUh);
        this.ilH = new d(this.mPageContext, com.baidu.tieba.card.data.k.gUK);
        this.ilO = new p(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dIb);
        this.ilL = new k(this.mPageContext, com.baidu.tieba.card.data.k.dLB);
        this.ilM = new r(this.mPageContext, com.baidu.tieba.card.data.k.dLD);
        this.ilN = new l(this.mPageContext, com.baidu.tieba.card.data.k.dLE);
        this.ilw.add(this.ilC);
        this.ilw.add(this.ilJ);
        this.ilw.add(this.ilK);
        this.ilw.add(this.ilD);
        this.ilw.add(this.ilE);
        this.ilw.add(this.ilF);
        this.ilw.add(this.ilG);
        this.ilw.add(this.ilI);
        this.ilw.add(this.ilH);
        this.ilw.add(this.ilO);
        this.ilw.add(this.ilL);
        this.ilw.add(this.ilM);
        this.ilw.add(this.ilN);
        this.ily = new t(this.mPageContext.getContext());
        this.ilz = new h(this.mPageContext.getContext());
        this.ilA = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ilB = new u(this.mPageContext, com.baidu.tieba.card.data.k.dLL);
        this.ilQ = new m(this.mPageContext, com.baidu.tieba.card.data.k.dLM);
        this.ilR = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.dLN);
        this.ilS = new n(this.mPageContext, com.baidu.tieba.card.data.k.dLO);
        this.ilT = new o(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.inm);
        this.ilw.add(this.ily);
        this.ilw.add(this.ilz);
        this.ilw.add(this.ilA);
        this.ilw.add(this.ilB);
        this.ilw.add(this.ilQ);
        this.ilw.add(this.ilR);
        this.ilw.add(this.ilS);
        this.ilw.add(this.ilP);
        this.ilw.add(this.ilT);
        Ae("page_concern");
    }

    public void bN(List<q> list) {
        this.mDataList = list;
        this.ilx.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.ilx != null) {
            this.ilx.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ilA.eyE = bdUniqueId;
        this.ilA.eyE = bdUniqueId;
        this.ilB.eyE = bdUniqueId;
        this.ilS.eyE = bdUniqueId;
        this.ilQ.eyE = bdUniqueId;
        this.ilR.eyE = bdUniqueId;
        this.ilP.eyE = bdUniqueId;
        this.ilH.eyE = bdUniqueId;
        this.ilO.eyE = bdUniqueId;
    }

    private void Ae(String str) {
        if (this.ilw != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.ilw) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ae(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ilC.a(vVar);
        this.ilJ.a(vVar);
        this.ilK.a(vVar);
        this.ilD.a(vVar);
        this.ilO.a(vVar);
        this.ilL.a(vVar);
        this.ilM.a(vVar);
        this.ilN.a(vVar);
        this.ilE.a(vVar);
        this.ilF.a(vVar);
        this.ilG.a(vVar);
        this.ilI.a(vVar);
        this.ilH.a(vVar);
        this.ilP.a(vVar);
        this.ilR.a(vVar);
        this.ilQ.a(vVar);
        this.ilS.a(vVar);
    }

    public List<q> getDataList() {
        return this.mDataList;
    }
}
