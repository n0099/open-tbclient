package com.baidu.tieba.enterForum.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.enterForum.tabfeed.a.c;
import com.baidu.tieba.enterForum.tabfeed.a.d;
import com.baidu.tieba.enterForum.tabfeed.a.e;
import com.baidu.tieba.enterForum.tabfeed.a.f;
import com.baidu.tieba.enterForum.tabfeed.a.g;
import com.baidu.tieba.enterForum.tabfeed.a.h;
import com.baidu.tieba.enterForum.tabfeed.a.i;
import com.baidu.tieba.enterForum.tabfeed.a.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMd = new LinkedList();
    private j gGA;
    private EnterForumTabFeedFragment gGp;
    private BdTypeRecyclerView gGq;
    private h gGr;
    private com.baidu.tieba.enterForum.tabfeed.a.b gGs;
    private d gGt;
    private c gGu;
    private e gGv;
    private i gGw;
    private f gGx;
    private g gGy;
    private com.baidu.tieba.enterForum.tabfeed.a.a gGz;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gGp = enterForumTabFeedFragment;
        this.gGq = bdTypeRecyclerView;
        BC();
    }

    private void BC() {
        this.gGr = new h(this.gGp.getPageContext(), bj.dqI, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGr.a(this.gGq);
        this.aMd.add(this.gGr);
        this.gGs = new com.baidu.tieba.enterForum.tabfeed.a.b(this.gGp.getPageContext(), bj.dqN, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGs.a(this.gGq);
        this.aMd.add(this.gGs);
        this.gGt = new d(this.gGp.getPageContext(), bj.dqL, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGt.a(this.gGq);
        this.aMd.add(this.gGt);
        this.gGu = new c(this.gGp.getPageContext(), bj.dqM, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGu.a(this.gGq);
        this.aMd.add(this.gGu);
        this.gGv = new e(this.gGp.getPageContext(), bj.dqJ, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGv.a(this.gGq);
        this.aMd.add(this.gGv);
        this.gGw = new i(this.gGp.getPageContext(), bj.dqV, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGw.a(this.gGq);
        this.aMd.add(this.gGw);
        this.gGx = new f(this.gGp.getPageContext(), bj.dqS, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGx.a(this.gGq);
        this.aMd.add(this.gGx);
        this.gGy = new g(this.gGp.getPageContext(), bj.dqO, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGy.a(this.gGq);
        this.aMd.add(this.gGy);
        this.gGz = new com.baidu.tieba.enterForum.tabfeed.a.a(this.gGp.getPageContext(), bj.dqR, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGz.a(this.gGq);
        this.aMd.add(this.gGz);
        this.gGA = new j(this.gGp.getPageContext(), com.baidu.tieba.enterForum.tabfeed.b.d.gHd, this.gGp.getUniqueId(), this.gGp.getTabName());
        this.gGA.a(this.gGq);
        this.aMd.add(this.gGA);
        this.gGq.addAdapters(this.aMd);
    }

    public void notifyDataSetChanged() {
        this.gGq.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<m> arrayList) {
        this.gGq.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.gGs != null) {
            this.gGs.setFromCDN(z);
        }
        if (this.gGu != null) {
            this.gGu.setFromCDN(z);
        }
        if (this.gGt != null) {
            this.gGt.setFromCDN(z);
        }
    }
}
