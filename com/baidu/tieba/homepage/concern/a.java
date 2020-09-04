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
    private List<com.baidu.adp.widget.ListView.a> iFW = new ArrayList();
    private BdTypeRecyclerView iFX;
    private t iFY;
    private h iFZ;
    private com.baidu.tieba.homepage.concern.a.a iGa;
    private u iGb;
    private v iGc;
    private s iGd;
    private g iGe;
    private f iGf;
    private e iGg;
    private d iGh;
    private w iGi;
    private i iGj;
    private j iGk;
    private k iGl;
    private r iGm;
    private l iGn;
    private p iGo;
    private com.baidu.tieba.homepage.concern.a.b iGp;
    private m iGq;
    private com.baidu.tieba.homepage.concern.a.c iGr;
    private n iGs;
    private o iGt;
    private List<q> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iFX = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fb(context);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.iFW);
    }

    private void fb(Context context) {
        this.iGc = new v(this.mPageContext, com.baidu.tieba.card.data.l.hng);
        this.iGj = new i(this.mPageContext, com.baidu.tieba.card.data.l.hnm);
        this.iGk = new j(this.mPageContext, com.baidu.tieba.card.data.l.hnn);
        this.iGd = new s(this.mPageContext, com.baidu.tieba.card.data.l.hnl);
        this.iGe = new g(this.mPageContext, com.baidu.tieba.card.data.l.hnh);
        this.iGf = new f(this.mPageContext, com.baidu.tieba.card.data.l.hni);
        this.iGg = new e(this.mPageContext, com.baidu.tieba.card.data.l.hnj);
        this.iGi = new w(this.mPageContext, com.baidu.tieba.card.data.m.ebs);
        this.iGp = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.f.hmI);
        this.iGh = new d(this.mPageContext, com.baidu.tieba.card.data.l.hnk);
        this.iGo = new p(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dXJ);
        this.iGl = new k(this.mPageContext, com.baidu.tieba.card.data.l.ebm);
        this.iGm = new r(this.mPageContext, com.baidu.tieba.card.data.l.ebo);
        this.iGn = new l(this.mPageContext, com.baidu.tieba.card.data.l.ebp);
        this.iFW.add(this.iGc);
        this.iFW.add(this.iGj);
        this.iFW.add(this.iGk);
        this.iFW.add(this.iGd);
        this.iFW.add(this.iGe);
        this.iFW.add(this.iGf);
        this.iFW.add(this.iGg);
        this.iFW.add(this.iGi);
        this.iFW.add(this.iGh);
        this.iFW.add(this.iGo);
        this.iFW.add(this.iGl);
        this.iFW.add(this.iGm);
        this.iFW.add(this.iGn);
        this.iFY = new t(this.mPageContext.getContext());
        this.iFZ = new h(this.mPageContext.getContext());
        this.iGa = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.iGb = new u(this.mPageContext, com.baidu.tieba.card.data.l.ebw);
        this.iGq = new m(this.mPageContext, com.baidu.tieba.card.data.l.ebx);
        this.iGr = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.l.eby);
        this.iGs = new n(this.mPageContext, com.baidu.tieba.card.data.l.ebz);
        this.iGt = new o(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.iHM);
        this.iFW.add(this.iFY);
        this.iFW.add(this.iFZ);
        this.iFW.add(this.iGa);
        this.iFW.add(this.iGb);
        this.iFW.add(this.iGq);
        this.iFW.add(this.iGr);
        this.iFW.add(this.iGs);
        this.iFW.add(this.iGp);
        this.iFW.add(this.iGt);
        Dk("page_concern");
    }

    public void bS(List<q> list) {
        this.mDataList = list;
        this.iFX.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.iFX != null) {
            this.iFX.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iGa.ePz = bdUniqueId;
        this.iGa.ePz = bdUniqueId;
        this.iGb.ePz = bdUniqueId;
        this.iGs.ePz = bdUniqueId;
        this.iGq.ePz = bdUniqueId;
        this.iGr.ePz = bdUniqueId;
        this.iGp.ePz = bdUniqueId;
        this.iGh.ePz = bdUniqueId;
        this.iGo.ePz = bdUniqueId;
    }

    private void Dk(String str) {
        if (this.iFW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.iFW) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Dk(str);
                }
            }
        }
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.iGc.a(vVar);
        this.iGj.a(vVar);
        this.iGk.a(vVar);
        this.iGd.a(vVar);
        this.iGo.a(vVar);
        this.iGl.a(vVar);
        this.iGm.a(vVar);
        this.iGn.a(vVar);
        this.iGe.a(vVar);
        this.iGf.a(vVar);
        this.iGg.a(vVar);
        this.iGi.a(vVar);
        this.iGh.a(vVar);
        this.iGp.a(vVar);
        this.iGr.a(vVar);
        this.iGq.a(vVar);
        this.iGs.a(vVar);
    }

    public List<q> getDataList() {
        return this.mDataList;
    }
}
