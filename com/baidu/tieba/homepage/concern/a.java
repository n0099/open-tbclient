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
/* loaded from: classes22.dex */
public class a {
    private s jcA;
    private m jcB;
    private q jcC;
    private com.baidu.tieba.homepage.concern.adapter.b jcD;
    private n jcE;
    private com.baidu.tieba.homepage.concern.adapter.c jcF;
    private o jcG;
    private p jcH;
    private y jcI;
    private List<com.baidu.adp.widget.ListView.a> jcj = new ArrayList();
    private BdTypeRecyclerView jck;
    private u jcl;
    private h jcm;
    private com.baidu.tieba.homepage.concern.adapter.a jcn;
    private v jco;
    private w jcp;
    private j jcq;
    private t jcr;
    private g jcs;
    private f jct;
    private e jcu;
    private com.baidu.tieba.homepage.concern.adapter.d jcv;
    private x jcw;
    private i jcx;
    private k jcy;
    private l jcz;
    private List<com.baidu.adp.widget.ListView.q> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jck = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fo(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jcj);
    }

    private void fo(Context context) {
        this.jcp = new w(this.mPageContext, com.baidu.tieba.card.data.l.hJf);
        this.jcq = new j(this.mPageContext, com.baidu.tieba.card.data.l.epp);
        this.jcx = new i(this.mPageContext, com.baidu.tieba.card.data.l.hJl);
        this.jcy = new k(this.mPageContext, com.baidu.tieba.card.data.l.hJm);
        this.jcr = new t(this.mPageContext, com.baidu.tieba.card.data.l.hJk);
        this.jcs = new g(this.mPageContext, com.baidu.tieba.card.data.l.hJg);
        this.jct = new f(this.mPageContext, com.baidu.tieba.card.data.l.hJh);
        this.jcu = new e(this.mPageContext, com.baidu.tieba.card.data.l.hJi);
        this.jcw = new x(this.mPageContext, com.baidu.tieba.card.data.m.epH);
        this.jcD = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.f.hIF);
        this.jcv = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.l.hJj);
        this.jcC = new q(this.mPageContext, com.baidu.tieba.homepage.concern.a.b.elV);
        this.jcz = new l(this.mPageContext, com.baidu.tieba.card.data.l.epB);
        this.jcA = new s(this.mPageContext, com.baidu.tieba.card.data.l.epD);
        this.jcB = new m(this.mPageContext, com.baidu.tieba.card.data.l.epE);
        this.jcj.add(this.jcp);
        this.jcj.add(this.jcq);
        this.jcj.add(this.jcx);
        this.jcj.add(this.jcy);
        this.jcj.add(this.jcr);
        this.jcj.add(this.jcs);
        this.jcj.add(this.jct);
        this.jcj.add(this.jcu);
        this.jcj.add(this.jcw);
        this.jcj.add(this.jcv);
        this.jcj.add(this.jcC);
        this.jcj.add(this.jcz);
        this.jcj.add(this.jcA);
        this.jcj.add(this.jcB);
        this.jcl = new u(this.mPageContext.getContext());
        this.jcm = new h(this.mPageContext.getContext());
        this.jcn = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jco = new v(this.mPageContext, com.baidu.tieba.card.data.l.epL);
        this.jcE = new n(this.mPageContext, com.baidu.tieba.card.data.l.epM);
        this.jcF = new com.baidu.tieba.homepage.concern.adapter.c(this.mPageContext, com.baidu.tieba.card.data.l.epN);
        this.jcG = new o(this.mPageContext, com.baidu.tieba.card.data.l.epO);
        this.jcH = new p(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.jew);
        this.jcI = new y(this.mPageContext, com.baidu.tieba.card.data.l.hJe, (byte) 4);
        this.jcj.add(this.jcl);
        this.jcj.add(this.jcm);
        this.jcj.add(this.jcn);
        this.jcj.add(this.jco);
        this.jcj.add(this.jcE);
        this.jcj.add(this.jcF);
        this.jcj.add(this.jcG);
        this.jcj.add(this.jcD);
        this.jcj.add(this.jcH);
        this.jcj.add(this.jcI);
        Es("page_concern");
    }

    public void ca(List<com.baidu.adp.widget.ListView.q> list) {
        this.mDataList = list;
        this.jck.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jck != null) {
            this.jck.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jcn.fey = bdUniqueId;
        this.jco.fey = bdUniqueId;
        this.jcG.fey = bdUniqueId;
        this.jcE.fey = bdUniqueId;
        this.jcF.fey = bdUniqueId;
        this.jcD.fey = bdUniqueId;
        this.jcv.fey = bdUniqueId;
        this.jcC.fey = bdUniqueId;
        this.jcI.fey = bdUniqueId;
    }

    private void Es(String str) {
        if (this.jcj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jcj) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Es(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.jcp.a(vVar);
        this.jcq.a(vVar);
        this.jcx.a(vVar);
        this.jcy.a(vVar);
        this.jcr.a(vVar);
        this.jcC.a(vVar);
        this.jcz.a(vVar);
        this.jcA.a(vVar);
        this.jcB.a(vVar);
        this.jcs.a(vVar);
        this.jct.a(vVar);
        this.jcu.a(vVar);
        this.jcw.a(vVar);
        this.jcv.a(vVar);
        this.jcD.a(vVar);
        this.jcF.a(vVar);
        this.jcE.a(vVar);
        this.jcG.a(vVar);
        this.jcI.a(vVar);
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.mDataList;
    }
}
