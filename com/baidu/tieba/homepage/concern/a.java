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
    private List<com.baidu.adp.widget.ListView.a> dAd = new ArrayList();
    private BdTypeListView dAe;
    private com.baidu.tieba.b.a dAf;
    private f dAg;
    private d dAh;
    private com.baidu.tieba.homepage.concern.a.b dAi;
    private com.baidu.tieba.homepage.concern.a.a dAj;
    private e dAk;
    private h dAl;
    private h dAm;
    private c dAn;
    private g dAo;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.dAe = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ab(context);
        bp(context);
        bdTypeListView.addAdapters(this.dAd);
    }

    private void bp(Context context) {
        this.dAf = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aBi);
        this.dAk = new e(this.mPageContext, k.TYPE);
        this.dAl = new h(this.mPageContext, l.crZ);
        this.dAm = new h(this.mPageContext, l.csa);
        this.dAg = new f(this.mPageContext.getContext());
        this.dAh = new d(this.mPageContext.getContext());
        this.dAi = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dBo);
        this.dAj = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dBp);
        this.dAn = new c(this.mPageContext, j.TYPE);
        this.dAo = new g(this.mPageContext, k.ZO);
        this.dAd.add(this.dAf);
        this.dAd.add(this.dAk);
        this.dAd.add(this.dAl);
        this.dAd.add(this.dAm);
        this.dAd.add(this.dAg);
        this.dAd.add(this.dAh);
        this.dAd.add(this.dAi);
        this.dAd.add(this.dAj);
        this.dAd.add(this.dAn);
        this.dAd.add(this.dAo);
        hY("page_concern");
    }

    public void af(List<com.baidu.adp.widget.ListView.h> list) {
        this.dAe.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.dAe != null && (this.dAe.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dAe.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dAn.aTr = bdUniqueId;
        this.dAk.aTr = bdUniqueId;
        this.dAl.aTr = bdUniqueId;
        this.dAm.aTr = bdUniqueId;
        this.dAi.aTr = bdUniqueId;
        this.dAj.aTr = bdUniqueId;
        this.dAn.aTr = bdUniqueId;
        this.dAo.aTr = bdUniqueId;
    }

    private void hY(String str) {
        if (this.dAd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dAd) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hY(str);
                }
            }
        }
    }
}
