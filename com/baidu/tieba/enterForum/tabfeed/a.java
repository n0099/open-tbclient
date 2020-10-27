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
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private EnterForumTabFeedFragment ija;
    private BdTypeRecyclerView ijb;
    private k ijc;
    private com.baidu.tieba.enterForum.tabfeed.a.b ijd;
    private d ije;
    private c ijf;
    private e ijg;
    private l ijh;
    private g iji;
    private i ijj;
    private h ijk;
    private f ijl;
    private j ijm;
    private com.baidu.tieba.enterForum.tabfeed.a.a ijn;
    private m ijo;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ija = enterForumTabFeedFragment;
        this.ijb = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.ijc = new k(this.ija.getPageContext(), bw.exO, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijc.a(this.ijb);
        this.bje.add(this.ijc);
        this.ijd = new com.baidu.tieba.enterForum.tabfeed.a.b(this.ija.getPageContext(), bw.exT, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijd.a(this.ijb);
        this.bje.add(this.ijd);
        this.ije = new d(this.ija.getPageContext(), bw.exR, this.ija.getUniqueId(), this.ija.getTabName());
        this.ije.a(this.ijb);
        this.bje.add(this.ije);
        this.ijf = new c(this.ija.getPageContext(), bw.exS, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijf.a(this.ijb);
        this.bje.add(this.ijf);
        this.ijg = new e(this.ija.getPageContext(), bw.exP, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijg.a(this.ijb);
        this.bje.add(this.ijg);
        this.ijh = new l(this.ija.getPageContext(), bw.eyg, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijh.a(this.ijb);
        this.bje.add(this.ijh);
        this.iji = new g(this.ija.getPageContext(), bw.exZ, this.ija.getUniqueId(), this.ija.getTabName());
        this.iji.a(this.ijb);
        this.bje.add(this.iji);
        this.ijj = new i(this.ija.getPageContext(), bw.eyb, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijj.a(this.ijb);
        this.bje.add(this.ijj);
        this.ijk = new h(this.ija.getPageContext(), bw.eyc, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijk.a(this.ijb);
        this.bje.add(this.ijk);
        this.ijl = new f(this.ija.getPageContext(), bw.exY, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijl.a(this.ijb);
        this.bje.add(this.ijl);
        this.ijm = new j(this.ija.getPageContext(), bw.exU, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijm.a(this.ijb);
        this.bje.add(this.ijm);
        this.ijn = new com.baidu.tieba.enterForum.tabfeed.a.a(this.ija.getPageContext(), bw.exX, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijn.a(this.ijb);
        this.bje.add(this.ijn);
        this.ijo = new m(this.ija.getPageContext(), bq.exa, this.ija.getUniqueId(), this.ija.getTabName());
        this.ijo.a(this.ijb);
        this.bje.add(this.ijo);
        this.ijb.addAdapters(this.bje);
    }

    public void notifyDataSetChanged() {
        this.ijb.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.ijb.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.ijd != null) {
            this.ijd.setFromCDN(z);
        }
        if (this.ijf != null) {
            this.ijf.setFromCDN(z);
        }
        if (this.ije != null) {
            this.ije.setFromCDN(z);
        }
    }
}
