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
    private List<com.baidu.adp.widget.ListView.a> eiX = new ArrayList();
    private BdTypeListView eiY;
    private com.baidu.tieba.b.a eiZ;
    private f eja;
    private d ejb;
    private com.baidu.tieba.homepage.concern.a.b ejc;
    private com.baidu.tieba.homepage.concern.a.a ejd;
    private e eje;
    private h ejf;
    private h ejg;
    private c ejh;
    private g eji;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.eiY = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        co(context);
        bdTypeListView.addAdapters(this.eiX);
    }

    private void co(Context context) {
        this.eiZ = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aTm);
        this.eje = new e(this.mPageContext, k.TYPE);
        this.ejf = new h(this.mPageContext, l.cRA);
        this.ejg = new h(this.mPageContext, l.cRB);
        this.eja = new f(this.mPageContext.getContext());
        this.ejb = new d(this.mPageContext.getContext());
        this.ejc = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.eki);
        this.ejd = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.ekj);
        this.ejh = new c(this.mPageContext, j.TYPE);
        this.eji = new g(this.mPageContext, k.apN);
        this.eiX.add(this.eiZ);
        this.eiX.add(this.eje);
        this.eiX.add(this.ejf);
        this.eiX.add(this.ejg);
        this.eiX.add(this.eja);
        this.eiX.add(this.ejb);
        this.eiX.add(this.ejc);
        this.eiX.add(this.ejd);
        this.eiX.add(this.ejh);
        this.eiX.add(this.eji);
        js("page_concern");
    }

    public void ak(List<com.baidu.adp.widget.ListView.h> list) {
        this.eiY.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.eiY != null && (this.eiY.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eiY.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ejh.bag = bdUniqueId;
        this.eje.bag = bdUniqueId;
        this.ejf.bag = bdUniqueId;
        this.ejg.bag = bdUniqueId;
        this.ejc.bag = bdUniqueId;
        this.ejd.bag = bdUniqueId;
        this.ejh.bag = bdUniqueId;
        this.eji.bag = bdUniqueId;
    }

    private void js(String str) {
        if (this.eiX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.eiX) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).js(str);
                }
            }
        }
    }
}
