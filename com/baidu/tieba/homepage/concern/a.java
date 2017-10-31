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
import com.baidu.tieba.story.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdTypeListView aUn;
    private g cCT;
    private List<com.baidu.adp.widget.ListView.a> ddn = new ArrayList();
    private f ddo;
    private com.baidu.tieba.homepage.concern.a.f ddp;
    private com.baidu.tieba.homepage.concern.a.d ddq;
    private com.baidu.tieba.homepage.concern.a.b ddr;
    private com.baidu.tieba.homepage.concern.a.a dds;
    private e ddt;
    private com.baidu.tieba.homepage.concern.a.g ddv;
    private com.baidu.tieba.homepage.concern.a.g ddw;
    private com.baidu.tieba.homepage.concern.a.c ddx;
    private boolean ddy;
    private BdUniqueId mId;
    private TbPageContext<?> mPageContext;

    public a(Context context, BdTypeListView bdTypeListView) {
        this.aUn = bdTypeListView;
        this.mPageContext = (TbPageContext) i.Y(context);
        bs(context);
        bdTypeListView.addAdapters(this.ddn);
    }

    private void bs(Context context) {
        this.ddo = new f(this.mPageContext, com.baidu.tbadk.data.f.azy);
        this.ddt = new e(this.mPageContext, l.TYPE);
        this.ddv = new com.baidu.tieba.homepage.concern.a.g(this.mPageContext, n.bVd);
        this.ddw = new com.baidu.tieba.homepage.concern.a.g(this.mPageContext, n.bVe);
        this.ddp = new com.baidu.tieba.homepage.concern.a.f(this.mPageContext.getContext());
        this.ddq = new com.baidu.tieba.homepage.concern.a.d(this.mPageContext.getContext());
        this.ddr = new com.baidu.tieba.homepage.concern.a.b(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dex);
        this.dds = new com.baidu.tieba.homepage.concern.a.a(this.mPageContext, com.baidu.tieba.homepage.concern.b.b.dey);
        this.ddx = new com.baidu.tieba.homepage.concern.a.c(this.mPageContext, k.TYPE);
        this.cCT = new g(this.mPageContext, 1, 0L, "");
        this.ddo.setClickListener(this.cCT);
        this.ddn.add(this.ddo);
        this.ddn.add(this.ddt);
        this.ddn.add(this.ddv);
        this.ddn.add(this.ddw);
        this.ddn.add(this.ddp);
        this.ddn.add(this.ddq);
        this.ddn.add(this.ddr);
        this.ddn.add(this.dds);
        this.ddn.add(this.ddx);
    }

    public void br(List<com.baidu.adp.widget.ListView.f> list) {
        this.aUn.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (this.aUn != null && (this.aUn.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aUn.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
        this.ddx.aPq = bdUniqueId;
        this.ddt.aPq = bdUniqueId;
        this.ddv.aPq = bdUniqueId;
        this.ddw.aPq = bdUniqueId;
        this.ddr.aPq = bdUniqueId;
        this.dds.aPq = bdUniqueId;
        this.ddx.aPq = bdUniqueId;
    }

    public void arf() {
        if (!this.ddy) {
            this.ddy = true;
            this.ddo.j(this.mId);
        }
    }
}
