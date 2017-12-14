package com.baidu.tieba.homepage.concern;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.homepage.concern.a.e;
import com.baidu.tieba.homepage.concern.a.h;
import com.baidu.tieba.story.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdTypeListView aXy;
    private g cMA;
    private h dnA;
    private com.baidu.tieba.homepage.concern.a.c dnB;
    private com.baidu.tieba.homepage.concern.a.g dnC;
    private boolean dnD;
    private List<com.baidu.adp.widget.ListView.a> dns = new ArrayList();
    private f dnt;
    private com.baidu.tieba.homepage.concern.a.f dnu;
    private com.baidu.tieba.homepage.concern.a.d dnv;
    private com.baidu.tieba.homepage.concern.a.b dnw;
    private com.baidu.tieba.homepage.concern.a.a dnx;
    private e dny;
    private h dnz;
    private BdUniqueId mId;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aXy = bdTypeListView;
        this.mPageContext = (TbPageContext) i.Y(context);
        bu(context);
        bdTypeListView.addAdapters(this.dns);
    }

    private void bu(Context context) {
        this.dnt = new f(this.mPageContext, com.baidu.tbadk.data.f.aAm);
        this.dny = new e(this.mPageContext, l.TYPE);
        this.dnz = new h(this.mPageContext, n.cdY);
        this.dnA = new h(this.mPageContext, n.cdZ);
        this.dnu = new com.baidu.tieba.homepage.concern.a.f(this.mPageContext.getContext());
        this.dnv = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.dnw = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.doE);
        this.dnx = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.doF);
        this.dnB = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, k.TYPE);
        this.dnC = new com.baidu.tieba.homepage.concern.a.g(this.mPageContext, l.YH);
        this.cMA = new g(this.mPageContext, 1, 0L, "");
        this.dnt.setClickListener(this.cMA);
        this.dns.add(this.dnt);
        this.dns.add(this.dny);
        this.dns.add(this.dnz);
        this.dns.add(this.dnA);
        this.dns.add(this.dnu);
        this.dns.add(this.dnv);
        this.dns.add(this.dnw);
        this.dns.add(this.dnx);
        this.dns.add(this.dnB);
        this.dns.add(this.dnC);
    }

    public void ae(List<com.baidu.adp.widget.ListView.f> list) {
        this.aXy.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aXy != null && (this.aXy.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aXy.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
        this.dnB.aSy = bdUniqueId;
        this.dny.aSy = bdUniqueId;
        this.dnz.aSy = bdUniqueId;
        this.dnA.aSy = bdUniqueId;
        this.dnw.aSy = bdUniqueId;
        this.dnx.aSy = bdUniqueId;
        this.dnB.aSy = bdUniqueId;
        this.dnC.aSy = bdUniqueId;
    }

    public void atx() {
        if (!this.dnD) {
            this.dnD = true;
            this.dnt.j(this.mId);
        }
    }
}
