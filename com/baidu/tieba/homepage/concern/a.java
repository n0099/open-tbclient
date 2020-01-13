package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
import com.baidu.tieba.homepage.concern.a.p;
import com.baidu.tieba.homepage.concern.a.q;
import com.baidu.tieba.homepage.concern.a.r;
import com.baidu.tieba.homepage.concern.a.s;
import com.baidu.tieba.homepage.concern.a.t;
import com.baidu.tieba.homepage.concern.a.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private n gUA;
    private com.baidu.tieba.homepage.personalize.a.c gUB;
    private j gUC;
    private com.baidu.tieba.homepage.concern.a.b gUD;
    private k gUE;
    private l gUF;
    private List<com.baidu.adp.widget.ListView.a> gUi = new ArrayList();
    private BdTypeRecyclerView gUj;
    private q gUk;
    private g gUl;
    private m gUm;
    private u gUn;
    private u gUo;
    private com.baidu.tieba.homepage.concern.a.a gUp;
    private r gUq;
    private s gUr;
    private p gUs;
    private f gUt;
    private e gUu;
    private d gUv;
    private com.baidu.tieba.homepage.concern.a.c gUw;
    private t gUx;
    private h gUy;
    private i gUz;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gUj = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eM(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gUi);
    }

    private void eM(Context context) {
        this.gUr = new s(this.mPageContext, com.baidu.tieba.card.data.k.fKA);
        this.gUy = new h(this.mPageContext, com.baidu.tieba.card.data.k.fKG);
        this.gUz = new i(this.mPageContext, com.baidu.tieba.card.data.k.fKI);
        this.gUs = new p(this.mPageContext, com.baidu.tieba.card.data.k.fKJ);
        this.gUt = new f(this.mPageContext, com.baidu.tieba.card.data.k.fKB);
        this.gUu = new e(this.mPageContext, com.baidu.tieba.card.data.k.fKD);
        this.gUv = new d(this.mPageContext, com.baidu.tieba.card.data.k.fKE);
        this.gUx = new t(this.mPageContext, com.baidu.tieba.card.data.l.cNv);
        this.gUB = new com.baidu.tieba.homepage.personalize.a.c(this.mPageContext, com.baidu.tieba.card.data.e.fKb);
        this.gUw = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.fKF);
        this.gUA = new n(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.gWa);
        this.gUB.setFrom(1);
        this.gUi.add(this.gUr);
        this.gUi.add(this.gUy);
        this.gUi.add(this.gUz);
        this.gUi.add(this.gUs);
        this.gUi.add(this.gUt);
        this.gUi.add(this.gUu);
        this.gUi.add(this.gUv);
        this.gUi.add(this.gUx);
        this.gUi.add(this.gUw);
        this.gUi.add(this.gUA);
        this.gUm = new m(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gUn = new u(this.mPageContext, com.baidu.tieba.card.data.l.fKQ);
        this.gUo = new u(this.mPageContext, com.baidu.tieba.card.data.l.fKR);
        this.gUk = new q(this.mPageContext.getContext());
        this.gUl = new g(this.mPageContext.getContext());
        this.gUp = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gUq = new r(this.mPageContext, com.baidu.tieba.card.data.k.cNz);
        this.gUC = new j(this.mPageContext, com.baidu.tieba.card.data.k.cNA);
        this.gUD = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.cNB);
        this.gUE = new k(this.mPageContext, com.baidu.tieba.card.data.k.cNC);
        this.gUF = new l(this.mPageContext, com.baidu.tieba.homepage.concern.b.a.gVZ);
        this.gUi.add(this.gUm);
        this.gUi.add(this.gUn);
        this.gUi.add(this.gUo);
        this.gUi.add(this.gUk);
        this.gUi.add(this.gUl);
        this.gUi.add(this.gUp);
        this.gUi.add(this.gUq);
        this.gUi.add(this.gUC);
        this.gUi.add(this.gUD);
        this.gUi.add(this.gUE);
        this.gUi.add(this.gUB);
        this.gUi.add(this.gUF);
        wu("page_concern");
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gUj.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gUj != null) {
            this.gUj.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gUp.dxg = bdUniqueId;
        this.gUm.dxg = bdUniqueId;
        this.gUn.dxg = bdUniqueId;
        this.gUo.dxg = bdUniqueId;
        this.gUp.dxg = bdUniqueId;
        this.gUq.dxg = bdUniqueId;
        this.gUE.dxg = bdUniqueId;
        this.gUC.dxg = bdUniqueId;
        this.gUD.dxg = bdUniqueId;
        this.gUB.dxg = bdUniqueId;
        this.gUw.dxg = bdUniqueId;
        this.gUA.dxg = bdUniqueId;
    }

    private void wu(String str) {
        if (this.gUi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gUi) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wu(str);
                }
            }
        }
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gUr.b(rVar);
        this.gUy.b(rVar);
        this.gUz.b(rVar);
        this.gUs.b(rVar);
        this.gUA.b(rVar);
        this.gUt.b(rVar);
        this.gUu.b(rVar);
        this.gUv.b(rVar);
        this.gUx.b(rVar);
        this.gUw.b(rVar);
        this.gUB.b(rVar);
        this.gUD.b(rVar);
        this.gUC.b(rVar);
        this.gUE.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
