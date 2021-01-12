package com.baidu.tieba.enterForum.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bz;
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
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private m iIA;
    private EnterForumTabFeedFragment iIm;
    private BdTypeRecyclerView iIn;
    private k iIo;
    private com.baidu.tieba.enterForum.tabfeed.a.b iIp;
    private d iIq;
    private c iIr;
    private e iIs;
    private l iIt;
    private g iIu;
    private i iIv;
    private h iIw;
    private f iIx;
    private j iIy;
    private com.baidu.tieba.enterForum.tabfeed.a.a iIz;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iIm = enterForumTabFeedFragment;
        this.iIn = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.iIo = new k(this.iIm.getPageContext(), bz.eOg, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIo.a(this.iIn);
        this.bjZ.add(this.iIo);
        this.iIp = new com.baidu.tieba.enterForum.tabfeed.a.b(this.iIm.getPageContext(), bz.eOl, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIp.a(this.iIn);
        this.bjZ.add(this.iIp);
        this.iIq = new d(this.iIm.getPageContext(), bz.eOj, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIq.a(this.iIn);
        this.bjZ.add(this.iIq);
        this.iIr = new c(this.iIm.getPageContext(), bz.eOk, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIr.a(this.iIn);
        this.bjZ.add(this.iIr);
        this.iIs = new e(this.iIm.getPageContext(), bz.eOh, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIs.a(this.iIn);
        this.bjZ.add(this.iIs);
        this.iIt = new l(this.iIm.getPageContext(), bz.eOy, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIt.a(this.iIn);
        this.bjZ.add(this.iIt);
        this.iIu = new g(this.iIm.getPageContext(), bz.eOr, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIu.a(this.iIn);
        this.bjZ.add(this.iIu);
        this.iIv = new i(this.iIm.getPageContext(), bz.eOt, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIv.a(this.iIn);
        this.bjZ.add(this.iIv);
        this.iIw = new h(this.iIm.getPageContext(), bz.eOu, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIw.a(this.iIn);
        this.bjZ.add(this.iIw);
        this.iIx = new f(this.iIm.getPageContext(), bz.eOq, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIx.a(this.iIn);
        this.bjZ.add(this.iIx);
        this.iIy = new j(this.iIm.getPageContext(), bz.eOm, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIy.a(this.iIn);
        this.bjZ.add(this.iIy);
        this.iIz = new com.baidu.tieba.enterForum.tabfeed.a.a(this.iIm.getPageContext(), bz.eOp, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIz.a(this.iIn);
        this.bjZ.add(this.iIz);
        this.iIA = new m(this.iIm.getPageContext(), bt.eNq, this.iIm.getUniqueId(), this.iIm.getTabName());
        this.iIA.a(this.iIn);
        this.bjZ.add(this.iIA);
        this.iIn.addAdapters(this.bjZ);
    }

    public void notifyDataSetChanged() {
        this.iIn.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<n> arrayList) {
        this.iIn.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.iIp != null) {
            this.iIp.setFromCDN(z);
        }
        if (this.iIr != null) {
            this.iIr.setFromCDN(z);
        }
        if (this.iIq != null) {
            this.iIq.setFromCDN(z);
        }
    }
}
