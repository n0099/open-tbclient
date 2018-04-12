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
    private List<com.baidu.adp.widget.ListView.a> dAg = new ArrayList();
    private BdTypeListView dAh;
    private com.baidu.tieba.b.a dAi;
    private f dAj;
    private d dAk;
    private com.baidu.tieba.homepage.concern.a.b dAl;
    private com.baidu.tieba.homepage.concern.a.a dAm;
    private e dAn;
    private h dAo;
    private h dAp;
    private c dAq;
    private g dAr;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.dAh = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ab(context);
        bp(context);
        bdTypeListView.addAdapters(this.dAg);
    }

    private void bp(Context context) {
        this.dAi = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aBi);
        this.dAn = new e(this.mPageContext, k.TYPE);
        this.dAo = new h(this.mPageContext, l.csc);
        this.dAp = new h(this.mPageContext, l.csd);
        this.dAj = new f(this.mPageContext.getContext());
        this.dAk = new d(this.mPageContext.getContext());
        this.dAl = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dBr);
        this.dAm = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dBs);
        this.dAq = new c(this.mPageContext, j.TYPE);
        this.dAr = new g(this.mPageContext, k.ZO);
        this.dAg.add(this.dAi);
        this.dAg.add(this.dAn);
        this.dAg.add(this.dAo);
        this.dAg.add(this.dAp);
        this.dAg.add(this.dAj);
        this.dAg.add(this.dAk);
        this.dAg.add(this.dAl);
        this.dAg.add(this.dAm);
        this.dAg.add(this.dAq);
        this.dAg.add(this.dAr);
        hY("page_concern");
    }

    public void af(List<com.baidu.adp.widget.ListView.h> list) {
        this.dAh.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.dAh != null && (this.dAh.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dAh.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dAq.aTr = bdUniqueId;
        this.dAn.aTr = bdUniqueId;
        this.dAo.aTr = bdUniqueId;
        this.dAp.aTr = bdUniqueId;
        this.dAl.aTr = bdUniqueId;
        this.dAm.aTr = bdUniqueId;
        this.dAq.aTr = bdUniqueId;
        this.dAr.aTr = bdUniqueId;
    }

    private void hY(String str) {
        if (this.dAg != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dAg) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hY(str);
                }
            }
        }
    }
}
