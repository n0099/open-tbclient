package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.r;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> gcK = new ArrayList();
    private BdTypeRecyclerView gcL;
    private com.baidu.tieba.b.a gcM;
    private j gcN;
    private e gcO;
    private h gcP;
    private n gcQ;
    private n gcR;
    private com.baidu.tieba.homepage.concern.a.a gcS;
    private k gcT;
    private l gcU;
    private f gcV;
    private g gcW;
    private i gcX;
    private d gcY;
    private com.baidu.tieba.homepage.concern.a.c gcZ;
    private com.baidu.tieba.homepage.concern.a.b gda;
    private m gdb;
    private List<com.baidu.adp.widget.ListView.m> mDataList;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gcL = bdTypeRecyclerView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dt(context);
        b(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.gcK);
    }

    private void dt(Context context) {
        this.gcU = new l(this.mPageContext, com.baidu.tieba.card.data.k.ePy);
        this.gcV = new f(this.mPageContext, com.baidu.tieba.card.data.k.ePD);
        this.gcW = new g(this.mPageContext, com.baidu.tieba.card.data.k.ePE);
        this.gcX = new i(this.mPageContext, com.baidu.tieba.card.data.k.ePF);
        this.gcY = new d(this.mPageContext, com.baidu.tieba.card.data.k.ePz);
        this.gcZ = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, com.baidu.tieba.card.data.k.ePB);
        this.gda = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.card.data.k.ePC);
        this.gdb = new m(this.mPageContext, com.baidu.tieba.card.data.l.caR);
        this.gcK.add(this.gcU);
        this.gcK.add(this.gcV);
        this.gcK.add(this.gcW);
        this.gcK.add(this.gcX);
        this.gcK.add(this.gcY);
        this.gcK.add(this.gcZ);
        this.gcK.add(this.gda);
        this.gcK.add(this.gdb);
        this.gcM = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.cCW);
        this.gcP = new h(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gcQ = new n(this.mPageContext, com.baidu.tieba.card.data.l.ePL);
        this.gcR = new n(this.mPageContext, com.baidu.tieba.card.data.l.ePM);
        this.gcN = new j(this.mPageContext.getContext());
        this.gcO = new e(this.mPageContext.getContext());
        this.gcS = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gcT = new k(this.mPageContext, com.baidu.tieba.card.data.k.caV);
        this.gcK.add(this.gcM);
        this.gcK.add(this.gcP);
        this.gcK.add(this.gcQ);
        this.gcK.add(this.gcR);
        this.gcK.add(this.gcN);
        this.gcK.add(this.gcO);
        this.gcK.add(this.gcS);
        this.gcK.add(this.gcT);
        rh("page_concern");
    }

    public void aY(List<com.baidu.adp.widget.ListView.m> list) {
        this.mDataList = list;
        this.gcL.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.gcL != null) {
            this.gcL.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gcS.cJo = bdUniqueId;
        this.gcP.cJo = bdUniqueId;
        this.gcQ.cJo = bdUniqueId;
        this.gcR.cJo = bdUniqueId;
        this.gcS.cJo = bdUniqueId;
        this.gcT.cJo = bdUniqueId;
    }

    private void rh(String str) {
        if (this.gcK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gcK) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rh(str);
                }
            }
        }
    }

    private void b(r rVar) {
        this.gcU.b(rVar);
        this.gcV.b(rVar);
        this.gcW.b(rVar);
        this.gcX.b(rVar);
        this.gcY.b(rVar);
        this.gcZ.b(rVar);
        this.gda.b(rVar);
        this.gdb.b(rVar);
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.mDataList;
    }
}
