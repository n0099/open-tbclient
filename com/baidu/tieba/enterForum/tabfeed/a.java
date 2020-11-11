package com.baidu.tieba.enterForum.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bw;
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
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private EnterForumTabFeedFragment ioZ;
    private BdTypeRecyclerView ipa;
    private k ipb;
    private com.baidu.tieba.enterForum.tabfeed.a.b ipc;
    private d ipd;
    private c ipe;
    private e ipf;
    private l ipg;
    private g iph;
    private i ipi;
    private h ipj;
    private f ipk;
    private j ipl;
    private com.baidu.tieba.enterForum.tabfeed.a.a ipm;
    private m ipn;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ioZ = enterForumTabFeedFragment;
        this.ipa = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.ipb = new k(this.ioZ.getPageContext(), bw.eDF, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipb.a(this.ipa);
        this.bky.add(this.ipb);
        this.ipc = new com.baidu.tieba.enterForum.tabfeed.a.b(this.ioZ.getPageContext(), bw.eDK, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipc.a(this.ipa);
        this.bky.add(this.ipc);
        this.ipd = new d(this.ioZ.getPageContext(), bw.eDI, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipd.a(this.ipa);
        this.bky.add(this.ipd);
        this.ipe = new c(this.ioZ.getPageContext(), bw.eDJ, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipe.a(this.ipa);
        this.bky.add(this.ipe);
        this.ipf = new e(this.ioZ.getPageContext(), bw.eDG, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipf.a(this.ipa);
        this.bky.add(this.ipf);
        this.ipg = new l(this.ioZ.getPageContext(), bw.eDW, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipg.a(this.ipa);
        this.bky.add(this.ipg);
        this.iph = new g(this.ioZ.getPageContext(), bw.eDQ, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.iph.a(this.ipa);
        this.bky.add(this.iph);
        this.ipi = new i(this.ioZ.getPageContext(), bw.eDS, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipi.a(this.ipa);
        this.bky.add(this.ipi);
        this.ipj = new h(this.ioZ.getPageContext(), bw.eDT, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipj.a(this.ipa);
        this.bky.add(this.ipj);
        this.ipk = new f(this.ioZ.getPageContext(), bw.eDP, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipk.a(this.ipa);
        this.bky.add(this.ipk);
        this.ipl = new j(this.ioZ.getPageContext(), bw.eDL, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipl.a(this.ipa);
        this.bky.add(this.ipl);
        this.ipm = new com.baidu.tieba.enterForum.tabfeed.a.a(this.ioZ.getPageContext(), bw.eDO, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipm.a(this.ipa);
        this.bky.add(this.ipm);
        this.ipn = new m(this.ioZ.getPageContext(), bq.eCS, this.ioZ.getUniqueId(), this.ioZ.getTabName());
        this.ipn.a(this.ipa);
        this.bky.add(this.ipn);
        this.ipa.addAdapters(this.bky);
    }

    public void notifyDataSetChanged() {
        this.ipa.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.ipa.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.ipc != null) {
            this.ipc.setFromCDN(z);
        }
        if (this.ipe != null) {
            this.ipe.setFromCDN(z);
        }
        if (this.ipd != null) {
            this.ipd.setFromCDN(z);
        }
    }
}
