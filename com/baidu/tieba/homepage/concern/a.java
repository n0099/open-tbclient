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
    private List<com.baidu.adp.widget.ListView.a> dBk = new ArrayList();
    private BdTypeListView dBl;
    private com.baidu.tieba.b.a dBm;
    private f dBn;
    private d dBo;
    private com.baidu.tieba.homepage.concern.a.b dBp;
    private com.baidu.tieba.homepage.concern.a.a dBq;
    private e dBr;
    private h dBs;
    private h dBt;
    private c dBu;
    private g dBv;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.dBl = bdTypeListView;
        this.mPageContext = (TbPageContext) i.ab(context);
        bp(context);
        bdTypeListView.addAdapters(this.dBk);
    }

    private void bp(Context context) {
        this.dBm = new com.baidu.tieba.b.a(this.mPageContext, com.baidu.tbadk.data.b.aBj);
        this.dBr = new e(this.mPageContext, k.TYPE);
        this.dBs = new h(this.mPageContext, l.cti);
        this.dBt = new h(this.mPageContext, l.ctj);
        this.dBn = new f(this.mPageContext.getContext());
        this.dBo = new d(this.mPageContext.getContext());
        this.dBp = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dCv);
        this.dBq = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dCw);
        this.dBu = new c(this.mPageContext, j.TYPE);
        this.dBv = new g(this.mPageContext, k.ZO);
        this.dBk.add(this.dBm);
        this.dBk.add(this.dBr);
        this.dBk.add(this.dBs);
        this.dBk.add(this.dBt);
        this.dBk.add(this.dBn);
        this.dBk.add(this.dBo);
        this.dBk.add(this.dBp);
        this.dBk.add(this.dBq);
        this.dBk.add(this.dBu);
        this.dBk.add(this.dBv);
        hZ("page_concern");
    }

    public void af(List<com.baidu.adp.widget.ListView.h> list) {
        this.dBl.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.dBl != null && (this.dBl.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dBl.getAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dBu.aTs = bdUniqueId;
        this.dBr.aTs = bdUniqueId;
        this.dBs.aTs = bdUniqueId;
        this.dBt.aTs = bdUniqueId;
        this.dBp.aTs = bdUniqueId;
        this.dBq.aTs = bdUniqueId;
        this.dBu.aTs = bdUniqueId;
        this.dBv.aTs = bdUniqueId;
    }

    private void hZ(String str) {
        if (this.dBk != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dBk) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hZ(str);
                }
            }
        }
    }
}
