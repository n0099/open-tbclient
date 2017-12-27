package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.a.f;
import com.baidu.tieba.homepage.concern.a.g;
import com.baidu.tieba.homepage.concern.a.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> dZE = new ArrayList();
    private BdTypeListView dZF;
    private com.baidu.tieba.a.a dZG;
    private f dZH;
    private com.baidu.tieba.homepage.concern.a.d dZI;
    private com.baidu.tieba.homepage.concern.a.b dZJ;
    private com.baidu.tieba.homepage.concern.a.a dZK;
    private e dZL;
    private h dZM;
    private h dZN;
    private com.baidu.tieba.homepage.concern.a.c dZO;
    private g dZP;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.dZF = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ak(context);
        bF(context);
        bdTypeListView.addAdapters(this.dZE);
    }

    private void bF(Context context) {
        this.dZG = new com.baidu.tieba.a.a(this.mPageContext, com.baidu.tbadk.data.b.bon);
        this.dZL = new e(this.mPageContext, l.TYPE);
        this.dZM = new h(this.mPageContext, n.cSG);
        this.dZN = new h(this.mPageContext, n.cSH);
        this.dZH = new f(this.mPageContext.getContext());
        this.dZI = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.dZJ = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eaQ);
        this.dZK = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eaR);
        this.dZO = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, k.TYPE);
        this.dZP = new g(this.mPageContext, l.aNj);
        this.dZE.add(this.dZG);
        this.dZE.add(this.dZL);
        this.dZE.add(this.dZM);
        this.dZE.add(this.dZN);
        this.dZE.add(this.dZH);
        this.dZE.add(this.dZI);
        this.dZE.add(this.dZJ);
        this.dZE.add(this.dZK);
        this.dZE.add(this.dZO);
        this.dZE.add(this.dZP);
    }

    public void ao(List<com.baidu.adp.widget.ListView.i> list) {
        this.dZF.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.dZF != null && (this.dZF.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dZF.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dZO.bGo = bdUniqueId;
        this.dZL.bGo = bdUniqueId;
        this.dZM.bGo = bdUniqueId;
        this.dZN.bGo = bdUniqueId;
        this.dZJ.bGo = bdUniqueId;
        this.dZK.bGo = bdUniqueId;
        this.dZO.bGo = bdUniqueId;
        this.dZP.bGo = bdUniqueId;
    }
}
