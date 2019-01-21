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
/* loaded from: classes6.dex */
public class a {
    private c etA;
    private g etB;
    private List<com.baidu.adp.widget.ListView.a> etq = new ArrayList();
    private BdTypeListView etr;
    private com.baidu.tieba.b.a ets;
    private f ett;
    private d etu;
    private com.baidu.tieba.homepage.concern.a.b etv;
    private com.baidu.tieba.homepage.concern.a.a etw;
    private e etx;
    private h ety;
    private h etz;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.etr = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        cs(context);
        bdTypeListView.addAdapters(this.etq);
    }

    private void cs(Context context) {
        this.ets = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aXv);
        this.etx = new e(this.mPageContext, k.TYPE);
        this.ety = new h(this.mPageContext, l.dbL);
        this.etz = new h(this.mPageContext, l.dbM);
        this.ett = new f(this.mPageContext.getContext());
        this.etu = new d(this.mPageContext.getContext());
        this.etv = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.euB);
        this.etw = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.euC);
        this.etA = new c(this.mPageContext, j.TYPE);
        this.etB = new g(this.mPageContext, k.atQ);
        this.etq.add(this.ets);
        this.etq.add(this.etx);
        this.etq.add(this.ety);
        this.etq.add(this.etz);
        this.etq.add(this.ett);
        this.etq.add(this.etu);
        this.etq.add(this.etv);
        this.etq.add(this.etw);
        this.etq.add(this.etA);
        this.etq.add(this.etB);
        kb("page_concern");
    }

    public void al(List<com.baidu.adp.widget.ListView.h> list) {
        this.etr.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.etr != null && (this.etr.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.etr.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.etA.beu = bdUniqueId;
        this.etx.beu = bdUniqueId;
        this.ety.beu = bdUniqueId;
        this.etz.beu = bdUniqueId;
        this.etv.beu = bdUniqueId;
        this.etw.beu = bdUniqueId;
        this.etA.beu = bdUniqueId;
        this.etB.beu = bdUniqueId;
    }

    private void kb(String str) {
        if (this.etq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.etq) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).kb(str);
                }
            }
        }
    }
}
