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
    private BdTypeListView aXw;
    private g cMp;
    private List<com.baidu.adp.widget.ListView.a> dmn = new ArrayList();
    private f dmo;
    private com.baidu.tieba.homepage.concern.a.f dmp;
    private com.baidu.tieba.homepage.concern.a.d dmq;
    private com.baidu.tieba.homepage.concern.a.b dmr;
    private com.baidu.tieba.homepage.concern.a.a dms;
    private e dmt;
    private h dmu;
    private h dmv;
    private com.baidu.tieba.homepage.concern.a.c dmw;
    private com.baidu.tieba.homepage.concern.a.g dmx;
    private boolean dmy;
    private BdUniqueId mId;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aXw = bdTypeListView;
        this.mPageContext = (TbPageContext) i.Y(context);
        bx(context);
        bdTypeListView.addAdapters(this.dmn);
    }

    private void bx(Context context) {
        this.dmo = new f(this.mPageContext, com.baidu.tbadk.data.f.aAh);
        this.dmt = new e(this.mPageContext, l.TYPE);
        this.dmu = new h(this.mPageContext, n.cdK);
        this.dmv = new h(this.mPageContext, n.cdL);
        this.dmp = new com.baidu.tieba.homepage.concern.a.f(this.mPageContext.getContext());
        this.dmq = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.dmr = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dny);
        this.dms = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dnz);
        this.dmw = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, k.TYPE);
        this.dmx = new com.baidu.tieba.homepage.concern.a.g(this.mPageContext, l.YN);
        this.cMp = new g(this.mPageContext, 1, 0L, "");
        this.dmo.setClickListener(this.cMp);
        this.dmn.add(this.dmo);
        this.dmn.add(this.dmt);
        this.dmn.add(this.dmu);
        this.dmn.add(this.dmv);
        this.dmn.add(this.dmp);
        this.dmn.add(this.dmq);
        this.dmn.add(this.dmr);
        this.dmn.add(this.dms);
        this.dmn.add(this.dmw);
        this.dmn.add(this.dmx);
    }

    public void ae(List<com.baidu.adp.widget.ListView.f> list) {
        this.aXw.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aXw != null && (this.aXw.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aXw.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
        this.dmw.aSv = bdUniqueId;
        this.dmt.aSv = bdUniqueId;
        this.dmu.aSv = bdUniqueId;
        this.dmv.aSv = bdUniqueId;
        this.dmr.aSv = bdUniqueId;
        this.dms.aSv = bdUniqueId;
        this.dmw.aSv = bdUniqueId;
        this.dmx.aSv = bdUniqueId;
    }

    public void ato() {
        if (!this.dmy) {
            this.dmy = true;
            this.dmo.j(this.mId);
        }
    }
}
