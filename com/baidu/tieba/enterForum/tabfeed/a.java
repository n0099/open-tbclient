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
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private EnterForumTabFeedFragment iPR;
    private BdTypeRecyclerView iPS;
    private k iPT;
    private com.baidu.tieba.enterForum.tabfeed.a.b iPU;
    private d iPV;
    private c iPW;
    private e iPX;
    private l iPY;
    private g iPZ;
    private i iQa;
    private h iQb;
    private f iQc;
    private j iQd;
    private com.baidu.tieba.enterForum.tabfeed.a.a iQe;
    private m iQf;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iPR = enterForumTabFeedFragment;
        this.iPS = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.iPT = new k(this.iPR.getPageContext(), cb.eRT, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iPT.a(this.iPS);
        this.boS.add(this.iPT);
        this.iPU = new com.baidu.tieba.enterForum.tabfeed.a.b(this.iPR.getPageContext(), cb.eRY, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iPU.a(this.iPS);
        this.boS.add(this.iPU);
        this.iPV = new d(this.iPR.getPageContext(), cb.eRW, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iPV.a(this.iPS);
        this.boS.add(this.iPV);
        this.iPW = new c(this.iPR.getPageContext(), cb.eRX, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iPW.a(this.iPS);
        this.boS.add(this.iPW);
        this.iPX = new e(this.iPR.getPageContext(), cb.eRU, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iPX.a(this.iPS);
        this.boS.add(this.iPX);
        this.iPY = new l(this.iPR.getPageContext(), cb.eSl, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iPY.a(this.iPS);
        this.boS.add(this.iPY);
        this.iPZ = new g(this.iPR.getPageContext(), cb.eSe, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iPZ.a(this.iPS);
        this.boS.add(this.iPZ);
        this.iQa = new i(this.iPR.getPageContext(), cb.eSg, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iQa.a(this.iPS);
        this.boS.add(this.iQa);
        this.iQb = new h(this.iPR.getPageContext(), cb.eSh, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iQb.a(this.iPS);
        this.boS.add(this.iQb);
        this.iQc = new f(this.iPR.getPageContext(), cb.eSd, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iQc.a(this.iPS);
        this.boS.add(this.iQc);
        this.iQd = new j(this.iPR.getPageContext(), cb.eRZ, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iQd.a(this.iPS);
        this.boS.add(this.iQd);
        this.iQe = new com.baidu.tieba.enterForum.tabfeed.a.a(this.iPR.getPageContext(), cb.eSc, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iQe.a(this.iPS);
        this.boS.add(this.iQe);
        this.iQf = new m(this.iPR.getPageContext(), bv.eRd, this.iPR.getUniqueId(), this.iPR.getTabName());
        this.iQf.a(this.iPS);
        this.boS.add(this.iQf);
        this.iPS.addAdapters(this.boS);
    }

    public void notifyDataSetChanged() {
        this.iPS.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<n> arrayList) {
        this.iPS.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.iPU != null) {
            this.iPU.setFromCDN(z);
        }
        if (this.iPW != null) {
            this.iPW.setFromCDN(z);
        }
        if (this.iPV != null) {
            this.iPV.setFromCDN(z);
        }
    }
}
