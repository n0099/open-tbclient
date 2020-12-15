package com.baidu.tieba.enterForum.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.by;
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
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private EnterForumTabFeedFragment iAH;
    private BdTypeRecyclerView iAI;
    private k iAJ;
    private com.baidu.tieba.enterForum.tabfeed.a.b iAK;
    private d iAL;
    private c iAM;
    private e iAN;
    private l iAO;
    private g iAP;
    private i iAQ;
    private h iAR;
    private f iAS;
    private j iAT;
    private com.baidu.tieba.enterForum.tabfeed.a.a iAU;
    private m iAV;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iAH = enterForumTabFeedFragment;
        this.iAI = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.iAJ = new k(this.iAH.getPageContext(), by.eIY, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAJ.a(this.iAI);
        this.bnf.add(this.iAJ);
        this.iAK = new com.baidu.tieba.enterForum.tabfeed.a.b(this.iAH.getPageContext(), by.eJd, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAK.a(this.iAI);
        this.bnf.add(this.iAK);
        this.iAL = new d(this.iAH.getPageContext(), by.eJb, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAL.a(this.iAI);
        this.bnf.add(this.iAL);
        this.iAM = new c(this.iAH.getPageContext(), by.eJc, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAM.a(this.iAI);
        this.bnf.add(this.iAM);
        this.iAN = new e(this.iAH.getPageContext(), by.eIZ, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAN.a(this.iAI);
        this.bnf.add(this.iAN);
        this.iAO = new l(this.iAH.getPageContext(), by.eJq, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAO.a(this.iAI);
        this.bnf.add(this.iAO);
        this.iAP = new g(this.iAH.getPageContext(), by.eJj, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAP.a(this.iAI);
        this.bnf.add(this.iAP);
        this.iAQ = new i(this.iAH.getPageContext(), by.eJl, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAQ.a(this.iAI);
        this.bnf.add(this.iAQ);
        this.iAR = new h(this.iAH.getPageContext(), by.eJm, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAR.a(this.iAI);
        this.bnf.add(this.iAR);
        this.iAS = new f(this.iAH.getPageContext(), by.eJi, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAS.a(this.iAI);
        this.bnf.add(this.iAS);
        this.iAT = new j(this.iAH.getPageContext(), by.eJe, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAT.a(this.iAI);
        this.bnf.add(this.iAT);
        this.iAU = new com.baidu.tieba.enterForum.tabfeed.a.a(this.iAH.getPageContext(), by.eJh, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAU.a(this.iAI);
        this.bnf.add(this.iAU);
        this.iAV = new m(this.iAH.getPageContext(), bs.eIj, this.iAH.getUniqueId(), this.iAH.getTabName());
        this.iAV.a(this.iAI);
        this.bnf.add(this.iAV);
        this.iAI.addAdapters(this.bnf);
    }

    public void notifyDataSetChanged() {
        this.iAI.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.iAI.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.iAK != null) {
            this.iAK.setFromCDN(z);
        }
        if (this.iAM != null) {
            this.iAM.setFromCDN(z);
        }
        if (this.iAL != null) {
            this.iAL.setFromCDN(z);
        }
    }
}
