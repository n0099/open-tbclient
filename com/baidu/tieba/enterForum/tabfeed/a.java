package com.baidu.tieba.enterForum.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bu;
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
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private EnterForumTabFeedFragment hhW;
    private BdTypeRecyclerView hhX;
    private k hhY;
    private com.baidu.tieba.enterForum.tabfeed.a.b hhZ;
    private d hia;
    private c hib;
    private e hic;
    private l hie;
    private g hif;
    private i hig;
    private h hih;
    private f hii;
    private j hij;
    private com.baidu.tieba.enterForum.tabfeed.a.a hik;
    private m hil;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hhW = enterForumTabFeedFragment;
        this.hhX = bdTypeRecyclerView;
        Dz();
    }

    private void Dz() {
        this.hhY = new k(this.hhW.getPageContext(), bu.dLq, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hhY.a(this.hhX);
        this.aUP.add(this.hhY);
        this.hhZ = new com.baidu.tieba.enterForum.tabfeed.a.b(this.hhW.getPageContext(), bu.dLv, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hhZ.a(this.hhX);
        this.aUP.add(this.hhZ);
        this.hia = new d(this.hhW.getPageContext(), bu.dLt, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hia.a(this.hhX);
        this.aUP.add(this.hia);
        this.hib = new c(this.hhW.getPageContext(), bu.dLu, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hib.a(this.hhX);
        this.aUP.add(this.hib);
        this.hic = new e(this.hhW.getPageContext(), bu.dLr, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hic.a(this.hhX);
        this.aUP.add(this.hic);
        this.hie = new l(this.hhW.getPageContext(), bu.dLH, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hie.a(this.hhX);
        this.aUP.add(this.hie);
        this.hif = new g(this.hhW.getPageContext(), bu.dLB, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hif.a(this.hhX);
        this.aUP.add(this.hif);
        this.hig = new i(this.hhW.getPageContext(), bu.dLD, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hig.a(this.hhX);
        this.aUP.add(this.hig);
        this.hih = new h(this.hhW.getPageContext(), bu.dLE, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hih.a(this.hhX);
        this.aUP.add(this.hih);
        this.hii = new f(this.hhW.getPageContext(), bu.dLA, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hii.a(this.hhX);
        this.aUP.add(this.hii);
        this.hij = new j(this.hhW.getPageContext(), bu.dLw, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hij.a(this.hhX);
        this.aUP.add(this.hij);
        this.hik = new com.baidu.tieba.enterForum.tabfeed.a.a(this.hhW.getPageContext(), bu.dLz, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hik.a(this.hhX);
        this.aUP.add(this.hik);
        this.hil = new m(this.hhW.getPageContext(), bo.dKE, this.hhW.getUniqueId(), this.hhW.getTabName());
        this.hil.a(this.hhX);
        this.aUP.add(this.hil);
        this.hhX.addAdapters(this.aUP);
    }

    public void notifyDataSetChanged() {
        this.hhX.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.hhX.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.hhZ != null) {
            this.hhZ.setFromCDN(z);
        }
        if (this.hib != null) {
            this.hib.setFromCDN(z);
        }
        if (this.hia != null) {
            this.hia.setFromCDN(z);
        }
    }
}
