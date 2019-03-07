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
    private List<com.baidu.adp.widget.ListView.a> fFN = new ArrayList();
    private BdTypeListView fFO;
    private com.baidu.tieba.b.a fFP;
    private f fFQ;
    private d fFR;
    private com.baidu.tieba.homepage.concern.a.b fFS;
    private com.baidu.tieba.homepage.concern.a.a fFT;
    private e fFU;
    private h fFV;
    private h fFW;
    private c fFX;
    private g fFY;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.fFO = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        dO(context);
        bdTypeListView.addAdapters(this.fFN);
    }

    private void dO(Context context) {
        this.fFP = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.cgP);
        this.fFU = new e(this.mPageContext, k.TYPE);
        this.fFV = new h(this.mPageContext, l.elN);
        this.fFW = new h(this.mPageContext, l.elO);
        this.fFQ = new f(this.mPageContext.getContext());
        this.fFR = new d(this.mPageContext.getContext());
        this.fFS = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.fGZ);
        this.fFT = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.fHa);
        this.fFX = new c(this.mPageContext, j.TYPE);
        this.fFY = new g(this.mPageContext, k.bBf);
        this.fFN.add(this.fFP);
        this.fFN.add(this.fFU);
        this.fFN.add(this.fFV);
        this.fFN.add(this.fFW);
        this.fFN.add(this.fFQ);
        this.fFN.add(this.fFR);
        this.fFN.add(this.fFS);
        this.fFN.add(this.fFT);
        this.fFN.add(this.fFX);
        this.fFN.add(this.fFY);
        qM("page_concern");
    }

    public void ay(List<m> list) {
        this.fFO.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.fFO != null && (this.fFO.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fFO.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fFX.cnX = bdUniqueId;
        this.fFU.cnX = bdUniqueId;
        this.fFV.cnX = bdUniqueId;
        this.fFW.cnX = bdUniqueId;
        this.fFS.cnX = bdUniqueId;
        this.fFT.cnX = bdUniqueId;
        this.fFX.cnX = bdUniqueId;
        this.fFY.cnX = bdUniqueId;
    }

    private void qM(String str) {
        if (this.fFN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fFN) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qM(str);
                }
            }
        }
    }
}
