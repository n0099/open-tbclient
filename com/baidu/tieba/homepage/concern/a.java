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
    private List<com.baidu.adp.widget.ListView.a> dZJ = new ArrayList();
    private BdTypeListView dZK;
    private com.baidu.tieba.b.a dZL;
    private f dZM;
    private d dZN;
    private com.baidu.tieba.homepage.concern.a.b dZO;
    private com.baidu.tieba.homepage.concern.a.a dZP;
    private e dZQ;
    private h dZR;
    private h dZS;
    private c dZT;
    private g dZU;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.dZK = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        cg(context);
        bdTypeListView.addAdapters(this.dZJ);
    }

    private void cg(Context context) {
        this.dZL = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aNU);
        this.dZQ = new e(this.mPageContext, k.TYPE);
        this.dZR = new h(this.mPageContext, l.cIb);
        this.dZS = new h(this.mPageContext, l.cIc);
        this.dZM = new f(this.mPageContext.getContext());
        this.dZN = new d(this.mPageContext.getContext());
        this.dZO = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eaU);
        this.dZP = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eaV);
        this.dZT = new c(this.mPageContext, j.TYPE);
        this.dZU = new g(this.mPageContext, k.ake);
        this.dZJ.add(this.dZL);
        this.dZJ.add(this.dZQ);
        this.dZJ.add(this.dZR);
        this.dZJ.add(this.dZS);
        this.dZJ.add(this.dZM);
        this.dZJ.add(this.dZN);
        this.dZJ.add(this.dZO);
        this.dZJ.add(this.dZP);
        this.dZJ.add(this.dZT);
        this.dZJ.add(this.dZU);
        jd("page_concern");
    }

    public void aj(List<com.baidu.adp.widget.ListView.h> list) {
        this.dZK.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.dZK != null && (this.dZK.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dZK.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dZT.aUU = bdUniqueId;
        this.dZQ.aUU = bdUniqueId;
        this.dZR.aUU = bdUniqueId;
        this.dZS.aUU = bdUniqueId;
        this.dZO.aUU = bdUniqueId;
        this.dZP.aUU = bdUniqueId;
        this.dZT.aUU = bdUniqueId;
        this.dZU.aUU = bdUniqueId;
    }

    private void jd(String str) {
        if (this.dZJ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dZJ) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jd(str);
                }
            }
        }
    }
}
