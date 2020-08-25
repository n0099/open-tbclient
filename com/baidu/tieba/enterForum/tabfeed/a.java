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
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
    private com.baidu.tieba.enterForum.tabfeed.a.b hAA;
    private d hAB;
    private c hAC;
    private e hAD;
    private l hAE;
    private g hAF;
    private i hAG;
    private h hAH;
    private f hAI;
    private j hAJ;
    private com.baidu.tieba.enterForum.tabfeed.a.a hAK;
    private m hAL;
    private EnterForumTabFeedFragment hAx;
    private BdTypeRecyclerView hAy;
    private k hAz;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hAx = enterForumTabFeedFragment;
        this.hAy = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.hAz = new k(this.hAx.getPageContext(), bw.eaX, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAz.a(this.hAy);
        this.bbu.add(this.hAz);
        this.hAA = new com.baidu.tieba.enterForum.tabfeed.a.b(this.hAx.getPageContext(), bw.ebc, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAA.a(this.hAy);
        this.bbu.add(this.hAA);
        this.hAB = new d(this.hAx.getPageContext(), bw.eba, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAB.a(this.hAy);
        this.bbu.add(this.hAB);
        this.hAC = new c(this.hAx.getPageContext(), bw.ebb, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAC.a(this.hAy);
        this.bbu.add(this.hAC);
        this.hAD = new e(this.hAx.getPageContext(), bw.eaY, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAD.a(this.hAy);
        this.bbu.add(this.hAD);
        this.hAE = new l(this.hAx.getPageContext(), bw.ebo, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAE.a(this.hAy);
        this.bbu.add(this.hAE);
        this.hAF = new g(this.hAx.getPageContext(), bw.ebi, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAF.a(this.hAy);
        this.bbu.add(this.hAF);
        this.hAG = new i(this.hAx.getPageContext(), bw.ebk, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAG.a(this.hAy);
        this.bbu.add(this.hAG);
        this.hAH = new h(this.hAx.getPageContext(), bw.ebl, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAH.a(this.hAy);
        this.bbu.add(this.hAH);
        this.hAI = new f(this.hAx.getPageContext(), bw.ebh, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAI.a(this.hAy);
        this.bbu.add(this.hAI);
        this.hAJ = new j(this.hAx.getPageContext(), bw.ebd, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAJ.a(this.hAy);
        this.bbu.add(this.hAJ);
        this.hAK = new com.baidu.tieba.enterForum.tabfeed.a.a(this.hAx.getPageContext(), bw.ebg, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAK.a(this.hAy);
        this.bbu.add(this.hAK);
        this.hAL = new m(this.hAx.getPageContext(), bq.eak, this.hAx.getUniqueId(), this.hAx.getTabName());
        this.hAL.a(this.hAy);
        this.bbu.add(this.hAL);
        this.hAy.addAdapters(this.bbu);
    }

    public void notifyDataSetChanged() {
        this.hAy.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.hAy.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.hAA != null) {
            this.hAA.setFromCDN(z);
        }
        if (this.hAC != null) {
            this.hAC.setFromCDN(z);
        }
        if (this.hAB != null) {
            this.hAB.setFromCDN(z);
        }
    }
}
