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
    private List<com.baidu.adp.widget.ListView.a> efk = new ArrayList();
    private BdTypeListView efl;
    private com.baidu.tieba.a.a efm;
    private f efn;
    private com.baidu.tieba.homepage.concern.a.d efo;
    private com.baidu.tieba.homepage.concern.a.b efp;
    private com.baidu.tieba.homepage.concern.a.a efq;
    private e efr;
    private h efs;
    private h eft;
    private com.baidu.tieba.homepage.concern.a.c efu;
    private g efv;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.efl = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ak(context);
        bB(context);
        bdTypeListView.addAdapters(this.efk);
    }

    private void bB(Context context) {
        this.efm = new com.baidu.tieba.a.a(this.mPageContext, com.baidu.tbadk.data.b.bqG);
        this.efr = new e(this.mPageContext, k.TYPE);
        this.efs = new h(this.mPageContext, m.dae);
        this.eft = new h(this.mPageContext, m.daf);
        this.efn = new f(this.mPageContext.getContext());
        this.efo = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.efp = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.egv);
        this.efq = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.egw);
        this.efu = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, j.TYPE);
        this.efv = new g(this.mPageContext, k.aOq);
        this.efk.add(this.efm);
        this.efk.add(this.efr);
        this.efk.add(this.efs);
        this.efk.add(this.eft);
        this.efk.add(this.efn);
        this.efk.add(this.efo);
        this.efk.add(this.efp);
        this.efk.add(this.efq);
        this.efk.add(this.efu);
        this.efk.add(this.efv);
    }

    public void ao(List<com.baidu.adp.widget.ListView.i> list) {
        this.efl.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.efl != null && (this.efl.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efl.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.efu.bIv = bdUniqueId;
        this.efr.bIv = bdUniqueId;
        this.efs.bIv = bdUniqueId;
        this.eft.bIv = bdUniqueId;
        this.efp.bIv = bdUniqueId;
        this.efq.bIv = bdUniqueId;
        this.efu.bIv = bdUniqueId;
        this.efv.bIv = bdUniqueId;
    }

    public void setCardShowType(int i) {
        this.efp.cardShowType = i;
        this.efq.cardShowType = i;
        this.efr.cardShowType = i;
        this.efs.cardShowType = i;
        this.eft.cardShowType = i;
        this.efu.cardShowType = i;
        this.efv.cardShowType = i;
    }
}
