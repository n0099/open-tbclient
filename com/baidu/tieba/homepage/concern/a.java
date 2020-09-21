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
import com.baidu.tieba.homepage.concern.adapter.s;
import com.baidu.tieba.homepage.concern.adapter.t;
import com.baidu.tieba.homepage.concern.adapter.u;
import com.baidu.tieba.homepage.concern.adapter.v;
import com.baidu.tieba.homepage.concern.adapter.w;
import com.baidu.tieba.homepage.concern.adapter.x;
import com.baidu.tieba.homepage.concern.adapter.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private g iNA;
    private f iNB;
    private e iNC;
    private com.baidu.tieba.homepage.concern.adapter.d iND;
    private x iNE;
    private i iNF;
    private k iNG;
    private l iNH;
    private s iNI;
    private m iNJ;
    private q iNK;
    private com.baidu.tieba.homepage.concern.adapter.b iNL;
    private n iNM;
    private com.baidu.tieba.homepage.concern.adapter.c iNN;
    private o iNO;
    private p iNP;
    private y iNQ;
    private List<com.baidu.adp.widget.ListView.a> iNr = new ArrayList();
    private BdTypeRecyclerView iNs;
    private u iNt;
    private h iNu;
    private com.baidu.tieba.homepage.concern.adapter.a iNv;
    private v iNw;
    private w iNx;
    private j iNy;
    private t iNz;
    private List<com.baidu.adp.widget.ListView.q> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iNs = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fh(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.iNr);
    }

    private void fh(Context context) {
        this.iNx = new w(this.mPageContext, com.baidu.tieba.card.data.l.huk);
        this.iNy = new j(this.mPageContext, com.baidu.tieba.card.data.l.edk);
        this.iNF = new i(this.mPageContext, com.baidu.tieba.card.data.l.huq);
        this.iNG = new k(this.mPageContext, com.baidu.tieba.card.data.l.hur);
        this.iNz = new t(this.mPageContext, com.baidu.tieba.card.data.l.hup);
        this.iNA = new g(this.mPageContext, com.baidu.tieba.card.data.l.hul);
        this.iNB = new f(this.mPageContext, com.baidu.tieba.card.data.l.hum);
        this.iNC = new e(this.mPageContext, com.baidu.tieba.card.data.l.hun);
        this.iNE = new x(this.mPageContext, com.baidu.tieba.card.data.m.edC);
        this.iNL = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.f.htL);
        this.iND = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.l.huo);
        this.iNK = new q(this.mPageContext, com.baidu.tieba.homepage.concern.a.b.dZT);
        this.iNH = new l(this.mPageContext, com.baidu.tieba.card.data.l.edw);
        this.iNI = new s(this.mPageContext, com.baidu.tieba.card.data.l.edy);
        this.iNJ = new m(this.mPageContext, com.baidu.tieba.card.data.l.edz);
        this.iNr.add(this.iNx);
        this.iNr.add(this.iNy);
        this.iNr.add(this.iNF);
        this.iNr.add(this.iNG);
        this.iNr.add(this.iNz);
        this.iNr.add(this.iNA);
        this.iNr.add(this.iNB);
        this.iNr.add(this.iNC);
        this.iNr.add(this.iNE);
        this.iNr.add(this.iND);
        this.iNr.add(this.iNK);
        this.iNr.add(this.iNH);
        this.iNr.add(this.iNI);
        this.iNr.add(this.iNJ);
        this.iNt = new u(this.mPageContext.getContext());
        this.iNu = new h(this.mPageContext.getContext());
        this.iNv = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.iNw = new v(this.mPageContext, com.baidu.tieba.card.data.l.edG);
        this.iNM = new n(this.mPageContext, com.baidu.tieba.card.data.l.edH);
        this.iNN = new com.baidu.tieba.homepage.concern.adapter.c(this.mPageContext, com.baidu.tieba.card.data.l.edI);
        this.iNO = new o(this.mPageContext, com.baidu.tieba.card.data.l.edJ);
        this.iNP = new p(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.iPC);
        this.iNQ = new y(this.mPageContext, com.baidu.tieba.card.data.l.huj, (byte) 4);
        this.iNr.add(this.iNt);
        this.iNr.add(this.iNu);
        this.iNr.add(this.iNv);
        this.iNr.add(this.iNw);
        this.iNr.add(this.iNM);
        this.iNr.add(this.iNN);
        this.iNr.add(this.iNO);
        this.iNr.add(this.iNL);
        this.iNr.add(this.iNP);
        this.iNr.add(this.iNQ);
        DH("page_concern");
    }

    public void bX(List<com.baidu.adp.widget.ListView.q> list) {
        this.mDataList = list;
        this.iNs.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.iNs != null) {
            this.iNs.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iNv.eSq = bdUniqueId;
        this.iNv.eSq = bdUniqueId;
        this.iNw.eSq = bdUniqueId;
        this.iNO.eSq = bdUniqueId;
        this.iNM.eSq = bdUniqueId;
        this.iNN.eSq = bdUniqueId;
        this.iNL.eSq = bdUniqueId;
        this.iND.eSq = bdUniqueId;
        this.iNK.eSq = bdUniqueId;
        this.iNQ.eSq = bdUniqueId;
    }

    private void DH(String str) {
        if (this.iNr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.iNr) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).DH(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.iNx.a(vVar);
        this.iNy.a(vVar);
        this.iNF.a(vVar);
        this.iNG.a(vVar);
        this.iNz.a(vVar);
        this.iNK.a(vVar);
        this.iNH.a(vVar);
        this.iNI.a(vVar);
        this.iNJ.a(vVar);
        this.iNA.a(vVar);
        this.iNB.a(vVar);
        this.iNC.a(vVar);
        this.iNE.a(vVar);
        this.iND.a(vVar);
        this.iNL.a(vVar);
        this.iNN.a(vVar);
        this.iNM.a(vVar);
        this.iNO.a(vVar);
        this.iNQ.a(vVar);
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.mDataList;
    }
}
