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
    private com.baidu.tieba.homepage.concern.a.d efA;
    private com.baidu.tieba.homepage.concern.a.b efB;
    private com.baidu.tieba.homepage.concern.a.a efC;
    private e efD;
    private h efE;
    private h efF;
    private com.baidu.tieba.homepage.concern.a.c efG;
    private g efH;
    private List<com.baidu.adp.widget.ListView.a> efw = new ArrayList();
    private BdTypeListView efx;
    private com.baidu.tieba.a.a efy;
    private f efz;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.efx = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ak(context);
        bB(context);
        bdTypeListView.addAdapters(this.efw);
    }

    private void bB(Context context) {
        this.efy = new com.baidu.tieba.a.a(this.mPageContext, com.baidu.tbadk.data.b.bqT);
        this.efD = new e(this.mPageContext, k.TYPE);
        this.efE = new h(this.mPageContext, m.daq);
        this.efF = new h(this.mPageContext, m.dar);
        this.efz = new f(this.mPageContext.getContext());
        this.efA = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.efB = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.egH);
        this.efC = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.egI);
        this.efG = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, j.TYPE);
        this.efH = new g(this.mPageContext, k.aOB);
        this.efw.add(this.efy);
        this.efw.add(this.efD);
        this.efw.add(this.efE);
        this.efw.add(this.efF);
        this.efw.add(this.efz);
        this.efw.add(this.efA);
        this.efw.add(this.efB);
        this.efw.add(this.efC);
        this.efw.add(this.efG);
        this.efw.add(this.efH);
    }

    public void ao(List<com.baidu.adp.widget.ListView.i> list) {
        this.efx.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.efx != null && (this.efx.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efx.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.efG.bII = bdUniqueId;
        this.efD.bII = bdUniqueId;
        this.efE.bII = bdUniqueId;
        this.efF.bII = bdUniqueId;
        this.efB.bII = bdUniqueId;
        this.efC.bII = bdUniqueId;
        this.efG.bII = bdUniqueId;
        this.efH.bII = bdUniqueId;
    }

    public void setCardShowType(int i) {
        this.efB.cardShowType = i;
        this.efC.cardShowType = i;
        this.efD.cardShowType = i;
        this.efE.cardShowType = i;
        this.efF.cardShowType = i;
        this.efG.cardShowType = i;
        this.efH.cardShowType = i;
    }
}
