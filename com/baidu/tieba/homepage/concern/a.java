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
    private List<com.baidu.adp.widget.ListView.a> iFQ = new ArrayList();
    private BdTypeRecyclerView iFR;
    private t iFS;
    private h iFT;
    private com.baidu.tieba.homepage.concern.a.a iFU;
    private u iFV;
    private v iFW;
    private s iFX;
    private g iFY;
    private f iFZ;
    private e iGa;
    private d iGb;
    private w iGc;
    private i iGd;
    private j iGe;
    private k iGf;
    private r iGg;
    private l iGh;
    private p iGi;
    private com.baidu.tieba.homepage.concern.a.b iGj;
    private m iGk;
    private com.baidu.tieba.homepage.concern.a.c iGl;
    private n iGm;
    private o iGn;
    private List<q> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iFR = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fb(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.iFQ);
    }

    private void fb(Context context) {
        this.iFW = new v(this.mPageContext, com.baidu.tieba.card.data.l.hnc);
        this.iGd = new i(this.mPageContext, com.baidu.tieba.card.data.l.hni);
        this.iGe = new j(this.mPageContext, com.baidu.tieba.card.data.l.hnj);
        this.iFX = new s(this.mPageContext, com.baidu.tieba.card.data.l.hnh);
        this.iFY = new g(this.mPageContext, com.baidu.tieba.card.data.l.hnd);
        this.iFZ = new f(this.mPageContext, com.baidu.tieba.card.data.l.hne);
        this.iGa = new e(this.mPageContext, com.baidu.tieba.card.data.l.hnf);
        this.iGc = new w(this.mPageContext, com.baidu.tieba.card.data.m.ebo);
        this.iGj = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.f.hmE);
        this.iGb = new d(this.mPageContext, com.baidu.tieba.card.data.l.hng);
        this.iGi = new p(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dXF);
        this.iGf = new k(this.mPageContext, com.baidu.tieba.card.data.l.ebi);
        this.iGg = new r(this.mPageContext, com.baidu.tieba.card.data.l.ebk);
        this.iGh = new l(this.mPageContext, com.baidu.tieba.card.data.l.ebl);
        this.iFQ.add(this.iFW);
        this.iFQ.add(this.iGd);
        this.iFQ.add(this.iGe);
        this.iFQ.add(this.iFX);
        this.iFQ.add(this.iFY);
        this.iFQ.add(this.iFZ);
        this.iFQ.add(this.iGa);
        this.iFQ.add(this.iGc);
        this.iFQ.add(this.iGb);
        this.iFQ.add(this.iGi);
        this.iFQ.add(this.iGf);
        this.iFQ.add(this.iGg);
        this.iFQ.add(this.iGh);
        this.iFS = new t(this.mPageContext.getContext());
        this.iFT = new h(this.mPageContext.getContext());
        this.iFU = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.iFV = new u(this.mPageContext, com.baidu.tieba.card.data.l.ebs);
        this.iGk = new m(this.mPageContext, com.baidu.tieba.card.data.l.ebt);
        this.iGl = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.l.ebu);
        this.iGm = new n(this.mPageContext, com.baidu.tieba.card.data.l.ebv);
        this.iGn = new o(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.iHG);
        this.iFQ.add(this.iFS);
        this.iFQ.add(this.iFT);
        this.iFQ.add(this.iFU);
        this.iFQ.add(this.iFV);
        this.iFQ.add(this.iGk);
        this.iFQ.add(this.iGl);
        this.iFQ.add(this.iGm);
        this.iFQ.add(this.iGj);
        this.iFQ.add(this.iGn);
        Dj("page_concern");
    }

    public void bS(List<q> list) {
        this.mDataList = list;
        this.iFR.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.iFR != null) {
            this.iFR.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iFU.ePv = bdUniqueId;
        this.iFU.ePv = bdUniqueId;
        this.iFV.ePv = bdUniqueId;
        this.iGm.ePv = bdUniqueId;
        this.iGk.ePv = bdUniqueId;
        this.iGl.ePv = bdUniqueId;
        this.iGj.ePv = bdUniqueId;
        this.iGb.ePv = bdUniqueId;
        this.iGi.ePv = bdUniqueId;
    }

    private void Dj(String str) {
        if (this.iFQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.iFQ) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Dj(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.iFW.a(vVar);
        this.iGd.a(vVar);
        this.iGe.a(vVar);
        this.iFX.a(vVar);
        this.iGi.a(vVar);
        this.iGf.a(vVar);
        this.iGg.a(vVar);
        this.iGh.a(vVar);
        this.iFY.a(vVar);
        this.iFZ.a(vVar);
        this.iGa.a(vVar);
        this.iGc.a(vVar);
        this.iGb.a(vVar);
        this.iGj.a(vVar);
        this.iGl.a(vVar);
        this.iGk.a(vVar);
        this.iGm.a(vVar);
    }

    public List<q> getDataList() {
        return this.mDataList;
    }
}
