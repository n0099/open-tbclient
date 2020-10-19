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
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private EnterForumTabFeedFragment hWA;
    private BdTypeRecyclerView hWB;
    private k hWC;
    private com.baidu.tieba.enterForum.tabfeed.a.b hWD;
    private d hWE;
    private c hWF;
    private e hWG;
    private l hWH;
    private g hWI;
    private i hWJ;
    private h hWK;
    private f hWL;
    private j hWM;
    private com.baidu.tieba.enterForum.tabfeed.a.a hWN;
    private m hWO;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hWA = enterForumTabFeedFragment;
        this.hWB = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.hWC = new k(this.hWA.getPageContext(), bw.epq, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWC.a(this.hWB);
        this.bhH.add(this.hWC);
        this.hWD = new com.baidu.tieba.enterForum.tabfeed.a.b(this.hWA.getPageContext(), bw.epv, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWD.a(this.hWB);
        this.bhH.add(this.hWD);
        this.hWE = new d(this.hWA.getPageContext(), bw.ept, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWE.a(this.hWB);
        this.bhH.add(this.hWE);
        this.hWF = new c(this.hWA.getPageContext(), bw.epu, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWF.a(this.hWB);
        this.bhH.add(this.hWF);
        this.hWG = new e(this.hWA.getPageContext(), bw.epr, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWG.a(this.hWB);
        this.bhH.add(this.hWG);
        this.hWH = new l(this.hWA.getPageContext(), bw.epH, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWH.a(this.hWB);
        this.bhH.add(this.hWH);
        this.hWI = new g(this.hWA.getPageContext(), bw.epB, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWI.a(this.hWB);
        this.bhH.add(this.hWI);
        this.hWJ = new i(this.hWA.getPageContext(), bw.epD, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWJ.a(this.hWB);
        this.bhH.add(this.hWJ);
        this.hWK = new h(this.hWA.getPageContext(), bw.epE, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWK.a(this.hWB);
        this.bhH.add(this.hWK);
        this.hWL = new f(this.hWA.getPageContext(), bw.epA, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWL.a(this.hWB);
        this.bhH.add(this.hWL);
        this.hWM = new j(this.hWA.getPageContext(), bw.epw, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWM.a(this.hWB);
        this.bhH.add(this.hWM);
        this.hWN = new com.baidu.tieba.enterForum.tabfeed.a.a(this.hWA.getPageContext(), bw.epz, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWN.a(this.hWB);
        this.bhH.add(this.hWN);
        this.hWO = new m(this.hWA.getPageContext(), bq.eoD, this.hWA.getUniqueId(), this.hWA.getTabName());
        this.hWO.a(this.hWB);
        this.bhH.add(this.hWO);
        this.hWB.addAdapters(this.bhH);
    }

    public void notifyDataSetChanged() {
        this.hWB.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.hWB.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.hWD != null) {
            this.hWD.setFromCDN(z);
        }
        if (this.hWF != null) {
            this.hWF.setFromCDN(z);
        }
        if (this.hWE != null) {
            this.hWE.setFromCDN(z);
        }
    }
}
