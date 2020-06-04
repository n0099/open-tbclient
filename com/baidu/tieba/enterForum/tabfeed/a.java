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
    private EnterForumTabFeedFragment gVn;
    private BdTypeRecyclerView gVo;
    private h gVp;
    private com.baidu.tieba.enterForum.tabfeed.a.b gVq;
    private d gVr;
    private c gVs;
    private e gVt;
    private i gVu;
    private f gVv;
    private g gVw;
    private com.baidu.tieba.enterForum.tabfeed.a.a gVx;
    private j gVy;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gVn = enterForumTabFeedFragment;
        this.gVo = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.gVp = new h(this.gVn.getPageContext(), bk.dEI, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVp.a(this.gVo);
        this.aSj.add(this.gVp);
        this.gVq = new com.baidu.tieba.enterForum.tabfeed.a.b(this.gVn.getPageContext(), bk.dEN, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVq.a(this.gVo);
        this.aSj.add(this.gVq);
        this.gVr = new d(this.gVn.getPageContext(), bk.dEL, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVr.a(this.gVo);
        this.aSj.add(this.gVr);
        this.gVs = new c(this.gVn.getPageContext(), bk.dEM, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVs.a(this.gVo);
        this.aSj.add(this.gVs);
        this.gVt = new e(this.gVn.getPageContext(), bk.dEJ, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVt.a(this.gVo);
        this.aSj.add(this.gVt);
        this.gVu = new i(this.gVn.getPageContext(), bk.dEV, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVu.a(this.gVo);
        this.aSj.add(this.gVu);
        this.gVv = new f(this.gVn.getPageContext(), bk.dES, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVv.a(this.gVo);
        this.aSj.add(this.gVv);
        this.gVw = new g(this.gVn.getPageContext(), bk.dEO, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVw.a(this.gVo);
        this.aSj.add(this.gVw);
        this.gVx = new com.baidu.tieba.enterForum.tabfeed.a.a(this.gVn.getPageContext(), bk.dER, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVx.a(this.gVo);
        this.aSj.add(this.gVx);
        this.gVy = new j(this.gVn.getPageContext(), com.baidu.tieba.enterForum.tabfeed.b.d.gWb, this.gVn.getUniqueId(), this.gVn.getTabName());
        this.gVy.a(this.gVo);
        this.aSj.add(this.gVy);
        this.gVo.addAdapters(this.aSj);
    }

    public void notifyDataSetChanged() {
        this.gVo.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<o> arrayList) {
        this.gVo.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.gVq != null) {
            this.gVq.setFromCDN(z);
        }
        if (this.gVs != null) {
            this.gVs.setFromCDN(z);
        }
        if (this.gVr != null) {
            this.gVr.setFromCDN(z);
        }
    }
}
