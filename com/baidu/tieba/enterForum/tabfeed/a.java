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
    private List<com.baidu.adp.widget.ListView.a> aMj = new LinkedList();
    private c gGA;
    private e gGB;
    private i gGC;
    private f gGD;
    private g gGE;
    private com.baidu.tieba.enterForum.tabfeed.a.a gGF;
    private j gGG;
    private EnterForumTabFeedFragment gGv;
    private BdTypeRecyclerView gGw;
    private h gGx;
    private com.baidu.tieba.enterForum.tabfeed.a.b gGy;
    private d gGz;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gGv = enterForumTabFeedFragment;
        this.gGw = bdTypeRecyclerView;
        BB();
    }

    private void BB() {
        this.gGx = new h(this.gGv.getPageContext(), bj.dqM, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGx.a(this.gGw);
        this.aMj.add(this.gGx);
        this.gGy = new com.baidu.tieba.enterForum.tabfeed.a.b(this.gGv.getPageContext(), bj.dqR, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGy.a(this.gGw);
        this.aMj.add(this.gGy);
        this.gGz = new d(this.gGv.getPageContext(), bj.dqP, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGz.a(this.gGw);
        this.aMj.add(this.gGz);
        this.gGA = new c(this.gGv.getPageContext(), bj.dqQ, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGA.a(this.gGw);
        this.aMj.add(this.gGA);
        this.gGB = new e(this.gGv.getPageContext(), bj.dqN, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGB.a(this.gGw);
        this.aMj.add(this.gGB);
        this.gGC = new i(this.gGv.getPageContext(), bj.dqZ, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGC.a(this.gGw);
        this.aMj.add(this.gGC);
        this.gGD = new f(this.gGv.getPageContext(), bj.dqW, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGD.a(this.gGw);
        this.aMj.add(this.gGD);
        this.gGE = new g(this.gGv.getPageContext(), bj.dqS, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGE.a(this.gGw);
        this.aMj.add(this.gGE);
        this.gGF = new com.baidu.tieba.enterForum.tabfeed.a.a(this.gGv.getPageContext(), bj.dqV, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGF.a(this.gGw);
        this.aMj.add(this.gGF);
        this.gGG = new j(this.gGv.getPageContext(), com.baidu.tieba.enterForum.tabfeed.b.d.gHj, this.gGv.getUniqueId(), this.gGv.getTabName());
        this.gGG.a(this.gGw);
        this.aMj.add(this.gGG);
        this.gGw.addAdapters(this.aMj);
    }

    public void notifyDataSetChanged() {
        this.gGw.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<m> arrayList) {
        this.gGw.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.gGy != null) {
            this.gGy.setFromCDN(z);
        }
        if (this.gGA != null) {
            this.gGA.setFromCDN(z);
        }
        if (this.gGz != null) {
            this.gGz.setFromCDN(z);
        }
    }
}
