package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class a {
    private k jvA;
    private m jvB;
    private n jvC;
    private u jvD;
    private o jvE;
    private s jvF;
    private com.baidu.tieba.homepage.concern.adapter.d jvG;
    private p jvH;
    private e jvI;
    private q jvJ;
    private j jvK;
    private ab jvL;
    private BdTypeRecyclerView jvj;
    private w jvk;
    private j jvl;
    private com.baidu.tieba.homepage.concern.adapter.b jvm;
    private com.baidu.tieba.homepage.concern.adapter.a jvn;
    private x jvo;
    private z jvq;
    private z jvr;
    private y jvs;
    private l jvt;
    private v jvu;
    private i jvv;
    private h jvw;
    private g jvx;
    private f jvy;
    private aa jvz;
    private List<com.baidu.adp.widget.ListView.q> mDataList;
    private TbPageContext<?> mPageContext;
    private ArrayList<r> jvp = new ArrayList<>();
    private List<com.baidu.adp.widget.ListView.a> jvi = new ArrayList();

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jvj = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fo(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.jvi);
    }

    private void fo(Context context) {
        for (int i = 0; i < com.baidu.tieba.card.data.b.ibD.size(); i++) {
            for (int i2 = 0; i2 < com.baidu.tieba.card.data.b.ibE.size(); i2++) {
                this.jvp.add(new r(this.mPageContext, com.baidu.tieba.card.data.b.ibF[i][i2], com.baidu.tieba.card.data.b.ibD.get(i), com.baidu.tieba.card.data.b.ibE.get(i2)));
            }
        }
        this.jvq = new z(this.mPageContext, bx.eCo, com.baidu.tieba.card.data.b.ibu);
        this.jvr = new z(this.mPageContext, bx.eBS, com.baidu.tieba.card.data.b.ibv);
        this.jvs = new y(this.mPageContext, com.baidu.tieba.card.data.k.icq);
        this.jvt = new l(this.mPageContext, com.baidu.tieba.card.data.k.eBW);
        this.jvA = new k(this.mPageContext, com.baidu.tieba.card.data.k.icw);
        this.jvB = new m(this.mPageContext, com.baidu.tieba.card.data.k.icx);
        this.jvu = new v(this.mPageContext, com.baidu.tieba.card.data.k.icv);
        this.jvv = new i(this.mPageContext, com.baidu.tieba.card.data.k.icr);
        this.jvw = new h(this.mPageContext, com.baidu.tieba.card.data.k.ics);
        this.jvx = new g(this.mPageContext, com.baidu.tieba.card.data.k.ict);
        this.jvz = new aa(this.mPageContext, com.baidu.tieba.card.data.l.eCo);
        this.jvG = new com.baidu.tieba.homepage.concern.adapter.d(this.mPageContext, com.baidu.tieba.card.data.e.ibR);
        this.jvy = new f(this.mPageContext, com.baidu.tieba.card.data.k.icu);
        this.jvF = new s(this.mPageContext, com.baidu.tieba.homepage.concern.a.a.eyF);
        this.jvC = new n(this.mPageContext, com.baidu.tieba.card.data.k.eCi);
        this.jvD = new u(this.mPageContext, com.baidu.tieba.card.data.k.eCk);
        this.jvE = new o(this.mPageContext, com.baidu.tieba.card.data.k.eCl);
        this.jvi.addAll(this.jvp);
        this.jvi.add(this.jvq);
        this.jvi.add(this.jvr);
        this.jvi.add(this.jvs);
        this.jvi.add(this.jvt);
        this.jvi.add(this.jvA);
        this.jvi.add(this.jvB);
        this.jvi.add(this.jvu);
        this.jvi.add(this.jvv);
        this.jvi.add(this.jvw);
        this.jvi.add(this.jvx);
        this.jvi.add(this.jvz);
        this.jvi.add(this.jvy);
        this.jvi.add(this.jvF);
        this.jvi.add(this.jvC);
        this.jvi.add(this.jvD);
        this.jvi.add(this.jvE);
        this.jvk = new w(this.mPageContext.getContext());
        this.jvl = new j(this.mPageContext.getContext());
        this.jvm = new com.baidu.tieba.homepage.concern.adapter.b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jvn = new com.baidu.tieba.homepage.concern.adapter.a(this.mPageContext, com.baidu.tieba.card.data.j.ibW);
        this.jvo = new x(this.mPageContext, com.baidu.tieba.card.data.k.eCt);
        this.jvH = new p(this.mPageContext, com.baidu.tieba.card.data.k.eCu);
        this.jvI = new e(this.mPageContext, com.baidu.tieba.card.data.k.eCv);
        this.jvJ = new q(this.mPageContext, com.baidu.tieba.card.data.k.eCw);
        this.jvK = new j(this.mPageContext.getContext(), com.baidu.tieba.homepage.concern.a.b.jxJ);
        this.jvL = new ab(this.mPageContext, com.baidu.tieba.card.data.k.icp, (byte) 4);
        this.jvi.add(this.jvk);
        this.jvi.add(this.jvl);
        this.jvi.add(this.jvm);
        this.jvi.add(this.jvn);
        this.jvi.add(this.jvo);
        this.jvi.add(this.jvH);
        this.jvi.add(this.jvI);
        this.jvi.add(this.jvJ);
        this.jvi.add(this.jvG);
        this.jvi.add(this.jvK);
        this.jvi.add(this.jvL);
        EA("page_concern");
    }

    public void cr(List<com.baidu.adp.widget.ListView.q> list) {
        this.mDataList = list;
        this.jvj.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.jvj != null) {
            this.jvj.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Iterator<r> it = this.jvp.iterator();
        while (it.hasNext()) {
            it.next().fsa = bdUniqueId;
        }
        this.jvm.fsa = bdUniqueId;
        this.jvn.fsa = bdUniqueId;
        this.jvo.fsa = bdUniqueId;
        this.jvJ.fsa = bdUniqueId;
        this.jvH.fsa = bdUniqueId;
        this.jvI.fsa = bdUniqueId;
        this.jvG.fsa = bdUniqueId;
        this.jvy.fsa = bdUniqueId;
        this.jvF.fsa = bdUniqueId;
        this.jvL.fsa = bdUniqueId;
    }

    private void EA(String str) {
        if (this.jvi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jvi) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EA(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        Iterator<r> it = this.jvp.iterator();
        while (it.hasNext()) {
            it.next().a(vVar);
        }
        this.jvq.a(vVar);
        this.jvr.a(vVar);
        this.jvs.a(vVar);
        this.jvt.a(vVar);
        this.jvA.a(vVar);
        this.jvB.a(vVar);
        this.jvu.a(vVar);
        this.jvF.a(vVar);
        this.jvC.a(vVar);
        this.jvD.a(vVar);
        this.jvE.a(vVar);
        this.jvv.a(vVar);
        this.jvw.a(vVar);
        this.jvx.a(vVar);
        this.jvz.a(vVar);
        this.jvy.a(vVar);
        this.jvG.a(vVar);
        this.jvI.a(vVar);
        this.jvH.a(vVar);
        this.jvJ.a(vVar);
        this.jvL.a(vVar);
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.mDataList;
    }
}
