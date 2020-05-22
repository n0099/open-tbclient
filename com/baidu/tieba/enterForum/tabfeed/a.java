package com.baidu.tieba.enterForum.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bk;
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
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private EnterForumTabFeedFragment gVc;
    private BdTypeRecyclerView gVd;
    private h gVe;
    private com.baidu.tieba.enterForum.tabfeed.a.b gVf;
    private d gVg;
    private c gVh;
    private e gVi;
    private i gVj;
    private f gVk;
    private g gVl;
    private com.baidu.tieba.enterForum.tabfeed.a.a gVm;
    private j gVn;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gVc = enterForumTabFeedFragment;
        this.gVd = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.gVe = new h(this.gVc.getPageContext(), bk.dEI, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVe.a(this.gVd);
        this.aSj.add(this.gVe);
        this.gVf = new com.baidu.tieba.enterForum.tabfeed.a.b(this.gVc.getPageContext(), bk.dEN, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVf.a(this.gVd);
        this.aSj.add(this.gVf);
        this.gVg = new d(this.gVc.getPageContext(), bk.dEL, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVg.a(this.gVd);
        this.aSj.add(this.gVg);
        this.gVh = new c(this.gVc.getPageContext(), bk.dEM, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVh.a(this.gVd);
        this.aSj.add(this.gVh);
        this.gVi = new e(this.gVc.getPageContext(), bk.dEJ, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVi.a(this.gVd);
        this.aSj.add(this.gVi);
        this.gVj = new i(this.gVc.getPageContext(), bk.dEV, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVj.a(this.gVd);
        this.aSj.add(this.gVj);
        this.gVk = new f(this.gVc.getPageContext(), bk.dES, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVk.a(this.gVd);
        this.aSj.add(this.gVk);
        this.gVl = new g(this.gVc.getPageContext(), bk.dEO, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVl.a(this.gVd);
        this.aSj.add(this.gVl);
        this.gVm = new com.baidu.tieba.enterForum.tabfeed.a.a(this.gVc.getPageContext(), bk.dER, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVm.a(this.gVd);
        this.aSj.add(this.gVm);
        this.gVn = new j(this.gVc.getPageContext(), com.baidu.tieba.enterForum.tabfeed.b.d.gVQ, this.gVc.getUniqueId(), this.gVc.getTabName());
        this.gVn.a(this.gVd);
        this.aSj.add(this.gVn);
        this.gVd.addAdapters(this.aSj);
    }

    public void notifyDataSetChanged() {
        this.gVd.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<o> arrayList) {
        this.gVd.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.gVf != null) {
            this.gVf.setFromCDN(z);
        }
        if (this.gVh != null) {
            this.gVh.setFromCDN(z);
        }
        if (this.gVg != null) {
            this.gVg.setFromCDN(z);
        }
    }
}
