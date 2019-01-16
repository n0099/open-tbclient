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
    private g etA;
    private List<com.baidu.adp.widget.ListView.a> etp = new ArrayList();
    private BdTypeListView etq;
    private com.baidu.tieba.b.a etr;
    private f ets;
    private d ett;
    private com.baidu.tieba.homepage.concern.a.b etu;
    private com.baidu.tieba.homepage.concern.a.a etv;
    private e etw;
    private h etx;
    private h ety;
    private c etz;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.etq = bdTypeListView;
        this.mPageContext = (TbPageContext) i.aK(context);
        cs(context);
        bdTypeListView.addAdapters(this.etp);
    }

    private void cs(Context context) {
        this.etr = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aXu);
        this.etw = new e(this.mPageContext, k.TYPE);
        this.etx = new h(this.mPageContext, l.dbK);
        this.ety = new h(this.mPageContext, l.dbL);
        this.ets = new f(this.mPageContext.getContext());
        this.ett = new d(this.mPageContext.getContext());
        this.etu = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.euA);
        this.etv = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.euB);
        this.etz = new c(this.mPageContext, j.TYPE);
        this.etA = new g(this.mPageContext, k.atP);
        this.etp.add(this.etr);
        this.etp.add(this.etw);
        this.etp.add(this.etx);
        this.etp.add(this.ety);
        this.etp.add(this.ets);
        this.etp.add(this.ett);
        this.etp.add(this.etu);
        this.etp.add(this.etv);
        this.etp.add(this.etz);
        this.etp.add(this.etA);
        kb("page_concern");
    }

    public void al(List<com.baidu.adp.widget.ListView.h> list) {
        this.etq.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.etq != null && (this.etq.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.etq.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.etz.bes = bdUniqueId;
        this.etw.bes = bdUniqueId;
        this.etx.bes = bdUniqueId;
        this.ety.bes = bdUniqueId;
        this.etu.bes = bdUniqueId;
        this.etv.bes = bdUniqueId;
        this.etz.bes = bdUniqueId;
        this.etA.bes = bdUniqueId;
    }

    private void kb(String str) {
        if (this.etp != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.etp) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).kb(str);
                }
            }
        }
    }
}
