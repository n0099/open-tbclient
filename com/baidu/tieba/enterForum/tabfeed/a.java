package com.baidu.tieba.enterForum.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.enterForum.tabfeed.a.c;
import com.baidu.tieba.enterForum.tabfeed.a.d;
import com.baidu.tieba.enterForum.tabfeed.a.e;
import com.baidu.tieba.enterForum.tabfeed.a.f;
import com.baidu.tieba.enterForum.tabfeed.a.g;
import com.baidu.tieba.enterForum.tabfeed.a.h;
import com.baidu.tieba.enterForum.tabfeed.a.i;
import com.baidu.tieba.enterForum.tabfeed.a.j;
import com.baidu.tieba.enterForum.tabfeed.a.k;
import com.baidu.tieba.enterForum.tabfeed.a.l;
import com.baidu.tieba.enterForum.tabfeed.a.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private EnterForumTabFeedFragment iNU;
    private BdTypeRecyclerView iNV;
    private k iNW;
    private com.baidu.tieba.enterForum.tabfeed.a.b iNX;
    private d iNY;
    private c iNZ;
    private e iOa;
    private l iOb;
    private g iOc;
    private i iOd;
    private h iOe;
    private f iOf;
    private j iOg;
    private com.baidu.tieba.enterForum.tabfeed.a.a iOh;
    private m iOi;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iNU = enterForumTabFeedFragment;
        this.iNV = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.iNW = new k(this.iNU.getPageContext(), cb.eQs, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iNW.a(this.iNV);
        this.bns.add(this.iNW);
        this.iNX = new com.baidu.tieba.enterForum.tabfeed.a.b(this.iNU.getPageContext(), cb.eQx, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iNX.a(this.iNV);
        this.bns.add(this.iNX);
        this.iNY = new d(this.iNU.getPageContext(), cb.eQv, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iNY.a(this.iNV);
        this.bns.add(this.iNY);
        this.iNZ = new c(this.iNU.getPageContext(), cb.eQw, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iNZ.a(this.iNV);
        this.bns.add(this.iNZ);
        this.iOa = new e(this.iNU.getPageContext(), cb.eQt, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iOa.a(this.iNV);
        this.bns.add(this.iOa);
        this.iOb = new l(this.iNU.getPageContext(), cb.eQK, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iOb.a(this.iNV);
        this.bns.add(this.iOb);
        this.iOc = new g(this.iNU.getPageContext(), cb.eQD, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iOc.a(this.iNV);
        this.bns.add(this.iOc);
        this.iOd = new i(this.iNU.getPageContext(), cb.eQF, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iOd.a(this.iNV);
        this.bns.add(this.iOd);
        this.iOe = new h(this.iNU.getPageContext(), cb.eQG, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iOe.a(this.iNV);
        this.bns.add(this.iOe);
        this.iOf = new f(this.iNU.getPageContext(), cb.eQC, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iOf.a(this.iNV);
        this.bns.add(this.iOf);
        this.iOg = new j(this.iNU.getPageContext(), cb.eQy, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iOg.a(this.iNV);
        this.bns.add(this.iOg);
        this.iOh = new com.baidu.tieba.enterForum.tabfeed.a.a(this.iNU.getPageContext(), cb.eQB, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iOh.a(this.iNV);
        this.bns.add(this.iOh);
        this.iOi = new m(this.iNU.getPageContext(), bv.ePC, this.iNU.getUniqueId(), this.iNU.getTabName());
        this.iOi.a(this.iNV);
        this.bns.add(this.iOi);
        this.iNV.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        this.iNV.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<n> arrayList) {
        this.iNV.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.iNX != null) {
            this.iNX.setFromCDN(z);
        }
        if (this.iNZ != null) {
            this.iNZ.setFromCDN(z);
        }
        if (this.iNY != null) {
            this.iNY.setFromCDN(z);
        }
    }
}
