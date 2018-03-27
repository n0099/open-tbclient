package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.a.f;
import com.baidu.tieba.homepage.concern.a.g;
import com.baidu.tieba.homepage.concern.a.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> efA = new ArrayList();
    private BdTypeListView efB;
    private com.baidu.tieba.a.a efC;
    private f efD;
    private com.baidu.tieba.homepage.concern.a.d efE;
    private com.baidu.tieba.homepage.concern.a.b efF;
    private com.baidu.tieba.homepage.concern.a.a efG;
    private e efH;
    private h efI;
    private h efJ;
    private com.baidu.tieba.homepage.concern.a.c efK;
    private g efL;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.efB = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ak(context);
        bB(context);
        bdTypeListView.addAdapters(this.efA);
    }

    private void bB(Context context) {
        this.efC = new com.baidu.tieba.a.a(this.mPageContext, com.baidu.tbadk.data.b.bqJ);
        this.efH = new e(this.mPageContext, k.TYPE);
        this.efI = new h(this.mPageContext, m.dah);
        this.efJ = new h(this.mPageContext, m.dai);
        this.efD = new f(this.mPageContext.getContext());
        this.efE = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.efF = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.egL);
        this.efG = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.egM);
        this.efK = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, j.TYPE);
        this.efL = new g(this.mPageContext, k.aOr);
        this.efA.add(this.efC);
        this.efA.add(this.efH);
        this.efA.add(this.efI);
        this.efA.add(this.efJ);
        this.efA.add(this.efD);
        this.efA.add(this.efE);
        this.efA.add(this.efF);
        this.efA.add(this.efG);
        this.efA.add(this.efK);
        this.efA.add(this.efL);
    }

    public void ao(List<com.baidu.adp.widget.ListView.i> list) {
        this.efB.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.efB != null && (this.efB.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efB.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.efK.bIy = bdUniqueId;
        this.efH.bIy = bdUniqueId;
        this.efI.bIy = bdUniqueId;
        this.efJ.bIy = bdUniqueId;
        this.efF.bIy = bdUniqueId;
        this.efG.bIy = bdUniqueId;
        this.efK.bIy = bdUniqueId;
        this.efL.bIy = bdUniqueId;
    }

    public void setCardShowType(int i) {
        this.efF.cardShowType = i;
        this.efG.cardShowType = i;
        this.efH.cardShowType = i;
        this.efI.cardShowType = i;
        this.efJ.cardShowType = i;
        this.efK.cardShowType = i;
        this.efL.cardShowType = i;
    }
}
