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
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> irB = new ArrayList();
    private BdTypeRecyclerView irC;
    private t irD;
    private h irE;
    private com.baidu.tieba.homepage.concern.a.a irF;
    private u irG;
    private v irH;
    private s irI;
    private g irJ;
    private f irK;
    private e irL;
    private d irM;
    private w irN;
    private i irO;
    private j irP;
    private k irQ;
    private r irR;
    private l irS;
    private p irT;
    private com.baidu.tieba.homepage.concern.a.b irU;
    private m irV;
    private com.baidu.tieba.homepage.concern.a.c irW;
    private n irX;
    private o irY;
    private List<q> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.irC = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eP(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.irB);
    }

    private void eP(Context context) {
        this.irH = new v(this.mPageContext, com.baidu.tieba.card.data.k.haj);
        this.irO = new i(this.mPageContext, com.baidu.tieba.card.data.k.haq);
        this.irP = new j(this.mPageContext, com.baidu.tieba.card.data.k.har);
        this.irI = new s(this.mPageContext, com.baidu.tieba.card.data.k.hap);
        this.irJ = new g(this.mPageContext, com.baidu.tieba.card.data.k.hal);
        this.irK = new f(this.mPageContext, com.baidu.tieba.card.data.k.ham);
        this.irL = new e(this.mPageContext, com.baidu.tieba.card.data.k.han);
        this.irN = new w(this.mPageContext, com.baidu.tieba.card.data.l.dRS);
        this.irU = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.e.gZL);
        this.irM = new d(this.mPageContext, com.baidu.tieba.card.data.k.hao);
        this.irT = new p(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dOm);
        this.irQ = new k(this.mPageContext, com.baidu.tieba.card.data.k.dRM);
        this.irR = new r(this.mPageContext, com.baidu.tieba.card.data.k.dRO);
        this.irS = new l(this.mPageContext, com.baidu.tieba.card.data.k.dRP);
        this.irB.add(this.irH);
        this.irB.add(this.irO);
        this.irB.add(this.irP);
        this.irB.add(this.irI);
        this.irB.add(this.irJ);
        this.irB.add(this.irK);
        this.irB.add(this.irL);
        this.irB.add(this.irN);
        this.irB.add(this.irM);
        this.irB.add(this.irT);
        this.irB.add(this.irQ);
        this.irB.add(this.irR);
        this.irB.add(this.irS);
        this.irD = new t(this.mPageContext.getContext());
        this.irE = new h(this.mPageContext.getContext());
        this.irF = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.irG = new u(this.mPageContext, com.baidu.tieba.card.data.k.dRW);
        this.irV = new m(this.mPageContext, com.baidu.tieba.card.data.k.dRX);
        this.irW = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.dRY);
        this.irX = new n(this.mPageContext, com.baidu.tieba.card.data.k.dRZ);
        this.irY = new o(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.itr);
        this.irB.add(this.irD);
        this.irB.add(this.irE);
        this.irB.add(this.irF);
        this.irB.add(this.irG);
        this.irB.add(this.irV);
        this.irB.add(this.irW);
        this.irB.add(this.irX);
        this.irB.add(this.irU);
        this.irB.add(this.irY);
        AP("page_concern");
    }

    public void bR(List<q> list) {
        this.mDataList = list;
        this.irC.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.irC != null) {
            this.irC.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.irF.eEU = bdUniqueId;
        this.irF.eEU = bdUniqueId;
        this.irG.eEU = bdUniqueId;
        this.irX.eEU = bdUniqueId;
        this.irV.eEU = bdUniqueId;
        this.irW.eEU = bdUniqueId;
        this.irU.eEU = bdUniqueId;
        this.irM.eEU = bdUniqueId;
        this.irT.eEU = bdUniqueId;
    }

    private void AP(String str) {
        if (this.irB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.irB) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).AP(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.irH.a(vVar);
        this.irO.a(vVar);
        this.irP.a(vVar);
        this.irI.a(vVar);
        this.irT.a(vVar);
        this.irQ.a(vVar);
        this.irR.a(vVar);
        this.irS.a(vVar);
        this.irJ.a(vVar);
        this.irK.a(vVar);
        this.irL.a(vVar);
        this.irN.a(vVar);
        this.irM.a(vVar);
        this.irU.a(vVar);
        this.irW.a(vVar);
        this.irV.a(vVar);
        this.irX.a(vVar);
    }

    public List<q> getDataList() {
        return this.mDataList;
    }
}
