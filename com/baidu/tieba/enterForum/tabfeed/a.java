package com.baidu.tieba.enterForum.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.bv;
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
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private EnterForumTabFeedFragment hnG;
    private BdTypeRecyclerView hnH;
    private k hnI;
    private com.baidu.tieba.enterForum.tabfeed.a.b hnJ;
    private d hnK;
    private c hnL;
    private e hnM;
    private l hnN;
    private g hnO;
    private i hnP;
    private h hnQ;
    private f hnR;
    private j hnS;
    private com.baidu.tieba.enterForum.tabfeed.a.a hnT;
    private m hnU;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hnG = enterForumTabFeedFragment;
        this.hnH = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.hnI = new k(this.hnG.getPageContext(), bv.dRB, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnI.a(this.hnH);
        this.aWf.add(this.hnI);
        this.hnJ = new com.baidu.tieba.enterForum.tabfeed.a.b(this.hnG.getPageContext(), bv.dRG, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnJ.a(this.hnH);
        this.aWf.add(this.hnJ);
        this.hnK = new d(this.hnG.getPageContext(), bv.dRE, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnK.a(this.hnH);
        this.aWf.add(this.hnK);
        this.hnL = new c(this.hnG.getPageContext(), bv.dRF, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnL.a(this.hnH);
        this.aWf.add(this.hnL);
        this.hnM = new e(this.hnG.getPageContext(), bv.dRC, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnM.a(this.hnH);
        this.aWf.add(this.hnM);
        this.hnN = new l(this.hnG.getPageContext(), bv.dRS, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnN.a(this.hnH);
        this.aWf.add(this.hnN);
        this.hnO = new g(this.hnG.getPageContext(), bv.dRM, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnO.a(this.hnH);
        this.aWf.add(this.hnO);
        this.hnP = new i(this.hnG.getPageContext(), bv.dRO, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnP.a(this.hnH);
        this.aWf.add(this.hnP);
        this.hnQ = new h(this.hnG.getPageContext(), bv.dRP, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnQ.a(this.hnH);
        this.aWf.add(this.hnQ);
        this.hnR = new f(this.hnG.getPageContext(), bv.dRL, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnR.a(this.hnH);
        this.aWf.add(this.hnR);
        this.hnS = new j(this.hnG.getPageContext(), bv.dRH, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnS.a(this.hnH);
        this.aWf.add(this.hnS);
        this.hnT = new com.baidu.tieba.enterForum.tabfeed.a.a(this.hnG.getPageContext(), bv.dRK, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnT.a(this.hnH);
        this.aWf.add(this.hnT);
        this.hnU = new m(this.hnG.getPageContext(), bp.dQQ, this.hnG.getUniqueId(), this.hnG.getTabName());
        this.hnU.a(this.hnH);
        this.aWf.add(this.hnU);
        this.hnH.addAdapters(this.aWf);
    }

    public void notifyDataSetChanged() {
        this.hnH.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.hnH.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.hnJ != null) {
            this.hnJ.setFromCDN(z);
        }
        if (this.hnL != null) {
            this.hnL.setFromCDN(z);
        }
        if (this.hnK != null) {
            this.hnK.setFromCDN(z);
        }
    }
}
