package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> dPK = new ArrayList();
    private BdTypeListView dPL;
    private com.baidu.tieba.b.a dPM;
    private f dPN;
    private d dPO;
    private com.baidu.tieba.homepage.concern.a.b dPP;
    private com.baidu.tieba.homepage.concern.a.a dPQ;
    private e dPR;
    private h dPS;
    private h dPT;
    private c dPU;
    private g dPV;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.dPL = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ad(context);
        by(context);
        bdTypeListView.addAdapters(this.dPK);
    }

    private void by(Context context) {
        this.dPM = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aKB);
        this.dPR = new e(this.mPageContext, k.TYPE);
        this.dPS = new h(this.mPageContext, l.czH);
        this.dPT = new h(this.mPageContext, l.czI);
        this.dPN = new f(this.mPageContext.getContext());
        this.dPO = new d(this.mPageContext.getContext());
        this.dPP = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dQT);
        this.dPQ = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dQU);
        this.dPU = new c(this.mPageContext, j.TYPE);
        this.dPV = new g(this.mPageContext, k.aii);
        this.dPK.add(this.dPM);
        this.dPK.add(this.dPR);
        this.dPK.add(this.dPS);
        this.dPK.add(this.dPT);
        this.dPK.add(this.dPN);
        this.dPK.add(this.dPO);
        this.dPK.add(this.dPP);
        this.dPK.add(this.dPQ);
        this.dPK.add(this.dPU);
        this.dPK.add(this.dPV);
        iD("page_concern");
    }

    public void aj(List<com.baidu.adp.widget.ListView.h> list) {
        this.dPL.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.dPL != null && (this.dPL.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dPL.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dPU.aRF = bdUniqueId;
        this.dPR.aRF = bdUniqueId;
        this.dPS.aRF = bdUniqueId;
        this.dPT.aRF = bdUniqueId;
        this.dPP.aRF = bdUniqueId;
        this.dPQ.aRF = bdUniqueId;
        this.dPU.aRF = bdUniqueId;
        this.dPV.aRF = bdUniqueId;
    }

    private void iD(String str) {
        if (this.dPK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dPK) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iD(str);
                }
            }
        }
    }
}
