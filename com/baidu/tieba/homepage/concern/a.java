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
    private BdTypeRecyclerView irA;
    private t irB;
    private h irC;
    private com.baidu.tieba.homepage.concern.a.a irD;
    private u irE;
    private v irF;
    private s irG;
    private g irH;
    private f irI;
    private e irJ;
    private d irK;
    private w irL;
    private i irM;
    private j irN;
    private k irO;
    private r irP;
    private l irQ;
    private p irR;
    private com.baidu.tieba.homepage.concern.a.b irS;
    private m irT;
    private com.baidu.tieba.homepage.concern.a.c irU;
    private n irV;
    private o irW;
    private List<com.baidu.adp.widget.ListView.a> irz = new ArrayList();
    private List<q> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.irA = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eP(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.irz);
    }

    private void eP(Context context) {
        this.irF = new v(this.mPageContext, com.baidu.tieba.card.data.k.haj);
        this.irM = new i(this.mPageContext, com.baidu.tieba.card.data.k.haq);
        this.irN = new j(this.mPageContext, com.baidu.tieba.card.data.k.har);
        this.irG = new s(this.mPageContext, com.baidu.tieba.card.data.k.hap);
        this.irH = new g(this.mPageContext, com.baidu.tieba.card.data.k.hal);
        this.irI = new f(this.mPageContext, com.baidu.tieba.card.data.k.ham);
        this.irJ = new e(this.mPageContext, com.baidu.tieba.card.data.k.han);
        this.irL = new w(this.mPageContext, com.baidu.tieba.card.data.l.dRS);
        this.irS = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.e.gZL);
        this.irK = new d(this.mPageContext, com.baidu.tieba.card.data.k.hao);
        this.irR = new p(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dOm);
        this.irO = new k(this.mPageContext, com.baidu.tieba.card.data.k.dRM);
        this.irP = new r(this.mPageContext, com.baidu.tieba.card.data.k.dRO);
        this.irQ = new l(this.mPageContext, com.baidu.tieba.card.data.k.dRP);
        this.irz.add(this.irF);
        this.irz.add(this.irM);
        this.irz.add(this.irN);
        this.irz.add(this.irG);
        this.irz.add(this.irH);
        this.irz.add(this.irI);
        this.irz.add(this.irJ);
        this.irz.add(this.irL);
        this.irz.add(this.irK);
        this.irz.add(this.irR);
        this.irz.add(this.irO);
        this.irz.add(this.irP);
        this.irz.add(this.irQ);
        this.irB = new t(this.mPageContext.getContext());
        this.irC = new h(this.mPageContext.getContext());
        this.irD = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.irE = new u(this.mPageContext, com.baidu.tieba.card.data.k.dRW);
        this.irT = new m(this.mPageContext, com.baidu.tieba.card.data.k.dRX);
        this.irU = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.dRY);
        this.irV = new n(this.mPageContext, com.baidu.tieba.card.data.k.dRZ);
        this.irW = new o(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.itp);
        this.irz.add(this.irB);
        this.irz.add(this.irC);
        this.irz.add(this.irD);
        this.irz.add(this.irE);
        this.irz.add(this.irT);
        this.irz.add(this.irU);
        this.irz.add(this.irV);
        this.irz.add(this.irS);
        this.irz.add(this.irW);
        AP("page_concern");
    }

    public void bR(List<q> list) {
        this.mDataList = list;
        this.irA.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.irA != null) {
            this.irA.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.irD.eEU = bdUniqueId;
        this.irD.eEU = bdUniqueId;
        this.irE.eEU = bdUniqueId;
        this.irV.eEU = bdUniqueId;
        this.irT.eEU = bdUniqueId;
        this.irU.eEU = bdUniqueId;
        this.irS.eEU = bdUniqueId;
        this.irK.eEU = bdUniqueId;
        this.irR.eEU = bdUniqueId;
    }

    private void AP(String str) {
        if (this.irz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.irz) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).AP(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.irF.a(vVar);
        this.irM.a(vVar);
        this.irN.a(vVar);
        this.irG.a(vVar);
        this.irR.a(vVar);
        this.irO.a(vVar);
        this.irP.a(vVar);
        this.irQ.a(vVar);
        this.irH.a(vVar);
        this.irI.a(vVar);
        this.irJ.a(vVar);
        this.irL.a(vVar);
        this.irK.a(vVar);
        this.irS.a(vVar);
        this.irU.a(vVar);
        this.irT.a(vVar);
        this.irV.a(vVar);
    }

    public List<q> getDataList() {
        return this.mDataList;
    }
}
