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
    private EnterForumTabFeedFragment iOi;
    private BdTypeRecyclerView iOj;
    private k iOk;
    private com.baidu.tieba.enterForum.tabfeed.a.b iOl;
    private d iOm;
    private c iOn;
    private e iOo;
    private l iOp;
    private g iOq;
    private i iOr;
    private h iOs;
    private f iOt;
    private j iOu;
    private com.baidu.tieba.enterForum.tabfeed.a.a iOv;
    private m iOw;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iOi = enterForumTabFeedFragment;
        this.iOj = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.iOk = new k(this.iOi.getPageContext(), cb.eQs, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOk.a(this.iOj);
        this.bns.add(this.iOk);
        this.iOl = new com.baidu.tieba.enterForum.tabfeed.a.b(this.iOi.getPageContext(), cb.eQx, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOl.a(this.iOj);
        this.bns.add(this.iOl);
        this.iOm = new d(this.iOi.getPageContext(), cb.eQv, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOm.a(this.iOj);
        this.bns.add(this.iOm);
        this.iOn = new c(this.iOi.getPageContext(), cb.eQw, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOn.a(this.iOj);
        this.bns.add(this.iOn);
        this.iOo = new e(this.iOi.getPageContext(), cb.eQt, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOo.a(this.iOj);
        this.bns.add(this.iOo);
        this.iOp = new l(this.iOi.getPageContext(), cb.eQK, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOp.a(this.iOj);
        this.bns.add(this.iOp);
        this.iOq = new g(this.iOi.getPageContext(), cb.eQD, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOq.a(this.iOj);
        this.bns.add(this.iOq);
        this.iOr = new i(this.iOi.getPageContext(), cb.eQF, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOr.a(this.iOj);
        this.bns.add(this.iOr);
        this.iOs = new h(this.iOi.getPageContext(), cb.eQG, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOs.a(this.iOj);
        this.bns.add(this.iOs);
        this.iOt = new f(this.iOi.getPageContext(), cb.eQC, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOt.a(this.iOj);
        this.bns.add(this.iOt);
        this.iOu = new j(this.iOi.getPageContext(), cb.eQy, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOu.a(this.iOj);
        this.bns.add(this.iOu);
        this.iOv = new com.baidu.tieba.enterForum.tabfeed.a.a(this.iOi.getPageContext(), cb.eQB, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOv.a(this.iOj);
        this.bns.add(this.iOv);
        this.iOw = new m(this.iOi.getPageContext(), bv.ePC, this.iOi.getUniqueId(), this.iOi.getTabName());
        this.iOw.a(this.iOj);
        this.bns.add(this.iOw);
        this.iOj.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        this.iOj.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<n> arrayList) {
        this.iOj.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.iOl != null) {
            this.iOl.setFromCDN(z);
        }
        if (this.iOn != null) {
            this.iOn.setFromCDN(z);
        }
        if (this.iOm != null) {
            this.iOm.setFromCDN(z);
        }
    }
}
