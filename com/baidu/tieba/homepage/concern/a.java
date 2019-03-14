package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.concern.a.c;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.a.f;
import com.baidu.tieba.homepage.concern.a.g;
import com.baidu.tieba.homepage.concern.a.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> fFM = new ArrayList();
    private BdTypeListView fFN;
    private com.baidu.tieba.b.a fFO;
    private f fFP;
    private d fFQ;
    private com.baidu.tieba.homepage.concern.a.b fFR;
    private com.baidu.tieba.homepage.concern.a.a fFS;
    private e fFT;
    private h fFU;
    private h fFV;
    private c fFW;
    private g fFX;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.fFN = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        dN(context);
        bdTypeListView.addAdapters(this.fFM);
    }

    private void dN(Context context) {
        this.fFO = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.cgP);
        this.fFT = new e(this.mPageContext, k.TYPE);
        this.fFU = new h(this.mPageContext, l.elJ);
        this.fFV = new h(this.mPageContext, l.elK);
        this.fFP = new f(this.mPageContext.getContext());
        this.fFQ = new d(this.mPageContext.getContext());
        this.fFR = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.fGY);
        this.fFS = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.fGZ);
        this.fFW = new c(this.mPageContext, j.TYPE);
        this.fFX = new g(this.mPageContext, k.bBh);
        this.fFM.add(this.fFO);
        this.fFM.add(this.fFT);
        this.fFM.add(this.fFU);
        this.fFM.add(this.fFV);
        this.fFM.add(this.fFP);
        this.fFM.add(this.fFQ);
        this.fFM.add(this.fFR);
        this.fFM.add(this.fFS);
        this.fFM.add(this.fFW);
        this.fFM.add(this.fFX);
        qL("page_concern");
    }

    public void ay(List<m> list) {
        this.fFN.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.fFN != null && (this.fFN.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fFN.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fFW.cnX = bdUniqueId;
        this.fFT.cnX = bdUniqueId;
        this.fFU.cnX = bdUniqueId;
        this.fFV.cnX = bdUniqueId;
        this.fFR.cnX = bdUniqueId;
        this.fFS.cnX = bdUniqueId;
        this.fFW.cnX = bdUniqueId;
        this.fFX.cnX = bdUniqueId;
    }

    private void qL(String str) {
        if (this.fFM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fFM) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qL(str);
                }
            }
        }
    }
}
