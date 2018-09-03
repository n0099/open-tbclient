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
    private h dSA;
    private h dSB;
    private c dSC;
    private g dSD;
    private List<com.baidu.adp.widget.ListView.a> dSs = new ArrayList();
    private BdTypeListView dSt;
    private com.baidu.tieba.b.a dSu;
    private f dSv;
    private d dSw;
    private com.baidu.tieba.homepage.concern.a.b dSx;
    private com.baidu.tieba.homepage.concern.a.a dSy;
    private e dSz;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.dSt = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ad(context);
        bz(context);
        bdTypeListView.addAdapters(this.dSs);
    }

    private void bz(Context context) {
        this.dSu = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aKE);
        this.dSz = new e(this.mPageContext, k.TYPE);
        this.dSA = new h(this.mPageContext, l.cCk);
        this.dSB = new h(this.mPageContext, l.cCl);
        this.dSv = new f(this.mPageContext.getContext());
        this.dSw = new d(this.mPageContext.getContext());
        this.dSx = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dTB);
        this.dSy = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dTC);
        this.dSC = new c(this.mPageContext, j.TYPE);
        this.dSD = new g(this.mPageContext, k.ahE);
        this.dSs.add(this.dSu);
        this.dSs.add(this.dSz);
        this.dSs.add(this.dSA);
        this.dSs.add(this.dSB);
        this.dSs.add(this.dSv);
        this.dSs.add(this.dSw);
        this.dSs.add(this.dSx);
        this.dSs.add(this.dSy);
        this.dSs.add(this.dSC);
        this.dSs.add(this.dSD);
        iB("page_concern");
    }

    public void ai(List<com.baidu.adp.widget.ListView.h> list) {
        this.dSt.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.dSt != null && (this.dSt.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dSt.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dSC.aRC = bdUniqueId;
        this.dSz.aRC = bdUniqueId;
        this.dSA.aRC = bdUniqueId;
        this.dSB.aRC = bdUniqueId;
        this.dSx.aRC = bdUniqueId;
        this.dSy.aRC = bdUniqueId;
        this.dSC.aRC = bdUniqueId;
        this.dSD.aRC = bdUniqueId;
    }

    private void iB(String str) {
        if (this.dSs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dSs) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iB(str);
                }
            }
        }
    }
}
