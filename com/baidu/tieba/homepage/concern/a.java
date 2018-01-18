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
    private List<com.baidu.adp.widget.ListView.a> eaP = new ArrayList();
    private BdTypeListView eaQ;
    private com.baidu.tieba.a.a eaR;
    private f eaS;
    private com.baidu.tieba.homepage.concern.a.d eaT;
    private com.baidu.tieba.homepage.concern.a.b eaU;
    private com.baidu.tieba.homepage.concern.a.a eaV;
    private e eaW;
    private h eaX;
    private h eaY;
    private com.baidu.tieba.homepage.concern.a.c eaZ;
    private g eba;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.eaQ = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ak(context);
        bF(context);
        bdTypeListView.addAdapters(this.eaP);
    }

    private void bF(Context context) {
        this.eaR = new com.baidu.tieba.a.a(this.mPageContext, com.baidu.tbadk.data.b.bow);
        this.eaW = new e(this.mPageContext, l.TYPE);
        this.eaX = new h(this.mPageContext, n.cXi);
        this.eaY = new h(this.mPageContext, n.cXj);
        this.eaS = new f(this.mPageContext.getContext());
        this.eaT = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.eaU = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eca);
        this.eaV = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.ecb);
        this.eaZ = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, k.TYPE);
        this.eba = new g(this.mPageContext, l.aNf);
        this.eaP.add(this.eaR);
        this.eaP.add(this.eaW);
        this.eaP.add(this.eaX);
        this.eaP.add(this.eaY);
        this.eaP.add(this.eaS);
        this.eaP.add(this.eaT);
        this.eaP.add(this.eaU);
        this.eaP.add(this.eaV);
        this.eaP.add(this.eaZ);
        this.eaP.add(this.eba);
    }

    public void am(List<com.baidu.adp.widget.ListView.i> list) {
        this.eaQ.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.eaQ != null && (this.eaQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eaQ.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eaZ.bGw = bdUniqueId;
        this.eaW.bGw = bdUniqueId;
        this.eaX.bGw = bdUniqueId;
        this.eaY.bGw = bdUniqueId;
        this.eaU.bGw = bdUniqueId;
        this.eaV.bGw = bdUniqueId;
        this.eaZ.bGw = bdUniqueId;
        this.eba.bGw = bdUniqueId;
    }
}
