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
    private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
    private EnterForumTabFeedFragment iMT;
    private BdTypeRecyclerView iMU;
    private k iMV;
    private com.baidu.tieba.enterForum.tabfeed.a.b iMW;
    private d iMX;
    private c iMY;
    private e iMZ;
    private l iNa;
    private g iNb;
    private i iNc;
    private h iNd;
    private f iNe;
    private j iNf;
    private com.baidu.tieba.enterForum.tabfeed.a.a iNg;
    private m iNh;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iMT = enterForumTabFeedFragment;
        this.iMU = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.iMV = new k(this.iMT.getPageContext(), bz.eSR, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iMV.a(this.iMU);
        this.boM.add(this.iMV);
        this.iMW = new com.baidu.tieba.enterForum.tabfeed.a.b(this.iMT.getPageContext(), bz.eSW, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iMW.a(this.iMU);
        this.boM.add(this.iMW);
        this.iMX = new d(this.iMT.getPageContext(), bz.eSU, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iMX.a(this.iMU);
        this.boM.add(this.iMX);
        this.iMY = new c(this.iMT.getPageContext(), bz.eSV, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iMY.a(this.iMU);
        this.boM.add(this.iMY);
        this.iMZ = new e(this.iMT.getPageContext(), bz.eSS, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iMZ.a(this.iMU);
        this.boM.add(this.iMZ);
        this.iNa = new l(this.iMT.getPageContext(), bz.eTj, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iNa.a(this.iMU);
        this.boM.add(this.iNa);
        this.iNb = new g(this.iMT.getPageContext(), bz.eTc, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iNb.a(this.iMU);
        this.boM.add(this.iNb);
        this.iNc = new i(this.iMT.getPageContext(), bz.eTe, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iNc.a(this.iMU);
        this.boM.add(this.iNc);
        this.iNd = new h(this.iMT.getPageContext(), bz.eTf, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iNd.a(this.iMU);
        this.boM.add(this.iNd);
        this.iNe = new f(this.iMT.getPageContext(), bz.eTb, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iNe.a(this.iMU);
        this.boM.add(this.iNe);
        this.iNf = new j(this.iMT.getPageContext(), bz.eSX, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iNf.a(this.iMU);
        this.boM.add(this.iNf);
        this.iNg = new com.baidu.tieba.enterForum.tabfeed.a.a(this.iMT.getPageContext(), bz.eTa, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iNg.a(this.iMU);
        this.boM.add(this.iNg);
        this.iNh = new m(this.iMT.getPageContext(), bt.eSb, this.iMT.getUniqueId(), this.iMT.getTabName());
        this.iNh.a(this.iMU);
        this.boM.add(this.iNh);
        this.iMU.addAdapters(this.boM);
    }

    public void notifyDataSetChanged() {
        this.iMU.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<n> arrayList) {
        this.iMU.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.iMW != null) {
            this.iMW.setFromCDN(z);
        }
        if (this.iMY != null) {
            this.iMY.setFromCDN(z);
        }
        if (this.iMX != null) {
            this.iMX.setFromCDN(z);
        }
    }
}
