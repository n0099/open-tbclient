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
    private com.baidu.tieba.homepage.concern.a.a dMA;
    private e dMB;
    private h dMC;
    private h dMD;
    private c dME;
    private g dMF;
    private List<com.baidu.adp.widget.ListView.a> dMu = new ArrayList();
    private BdTypeListView dMv;
    private com.baidu.tieba.b.a dMw;
    private f dMx;
    private d dMy;
    private com.baidu.tieba.homepage.concern.a.b dMz;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.dMv = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ad(context);
        bz(context);
        bdTypeListView.addAdapters(this.dMu);
    }

    private void bz(Context context) {
        this.dMw = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aJE);
        this.dMB = new e(this.mPageContext, k.TYPE);
        this.dMC = new h(this.mPageContext, l.cBN);
        this.dMD = new h(this.mPageContext, l.cBO);
        this.dMx = new f(this.mPageContext.getContext());
        this.dMy = new d(this.mPageContext.getContext());
        this.dMz = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dNB);
        this.dMA = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dNC);
        this.dME = new c(this.mPageContext, j.TYPE);
        this.dMF = new g(this.mPageContext, k.ahQ);
        this.dMu.add(this.dMw);
        this.dMu.add(this.dMB);
        this.dMu.add(this.dMC);
        this.dMu.add(this.dMD);
        this.dMu.add(this.dMx);
        this.dMu.add(this.dMy);
        this.dMu.add(this.dMz);
        this.dMu.add(this.dMA);
        this.dMu.add(this.dME);
        this.dMu.add(this.dMF);
        iy("page_concern");
    }

    public void ai(List<com.baidu.adp.widget.ListView.h> list) {
        this.dMv.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.dMv != null && (this.dMv.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dMv.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dME.aQJ = bdUniqueId;
        this.dMB.aQJ = bdUniqueId;
        this.dMC.aQJ = bdUniqueId;
        this.dMD.aQJ = bdUniqueId;
        this.dMz.aQJ = bdUniqueId;
        this.dMA.aQJ = bdUniqueId;
        this.dME.aQJ = bdUniqueId;
        this.dMF.aQJ = bdUniqueId;
    }

    private void iy(String str) {
        if (this.dMu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dMu) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iy(str);
                }
            }
        }
    }
}
