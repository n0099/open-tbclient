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
    private List<com.baidu.adp.widget.ListView.a> ebk = new ArrayList();
    private BdTypeListView ebl;
    private com.baidu.tieba.a.a ebm;
    private f ebn;
    private com.baidu.tieba.homepage.concern.a.d ebo;
    private com.baidu.tieba.homepage.concern.a.b ebp;
    private com.baidu.tieba.homepage.concern.a.a ebq;
    private e ebr;
    private h ebs;
    private h ebt;
    private com.baidu.tieba.homepage.concern.a.c ebu;
    private g ebv;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.ebl = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ak(context);
        bC(context);
        bdTypeListView.addAdapters(this.ebk);
    }

    private void bC(Context context) {
        this.ebm = new com.baidu.tieba.a.a(this.mPageContext, com.baidu.tbadk.data.b.boF);
        this.ebr = new e(this.mPageContext, l.TYPE);
        this.ebs = new h(this.mPageContext, n.cXD);
        this.ebt = new h(this.mPageContext, n.cXE);
        this.ebn = new f(this.mPageContext.getContext());
        this.ebo = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.ebp = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.ecv);
        this.ebq = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.ecw);
        this.ebu = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, k.TYPE);
        this.ebv = new g(this.mPageContext, l.aNi);
        this.ebk.add(this.ebm);
        this.ebk.add(this.ebr);
        this.ebk.add(this.ebs);
        this.ebk.add(this.ebt);
        this.ebk.add(this.ebn);
        this.ebk.add(this.ebo);
        this.ebk.add(this.ebp);
        this.ebk.add(this.ebq);
        this.ebk.add(this.ebu);
        this.ebk.add(this.ebv);
    }

    public void am(List<com.baidu.adp.widget.ListView.i> list) {
        this.ebl.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.ebl != null && (this.ebl.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ebl.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ebu.bGE = bdUniqueId;
        this.ebr.bGE = bdUniqueId;
        this.ebs.bGE = bdUniqueId;
        this.ebt.bGE = bdUniqueId;
        this.ebp.bGE = bdUniqueId;
        this.ebq.bGE = bdUniqueId;
        this.ebu.bGE = bdUniqueId;
        this.ebv.bGE = bdUniqueId;
    }
}
