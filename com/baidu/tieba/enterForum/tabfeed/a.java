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
    private EnterForumTabFeedFragment iAF;
    private BdTypeRecyclerView iAG;
    private k iAH;
    private com.baidu.tieba.enterForum.tabfeed.a.b iAI;
    private d iAJ;
    private c iAK;
    private e iAL;
    private l iAM;
    private g iAN;
    private i iAO;
    private h iAP;
    private f iAQ;
    private j iAR;
    private com.baidu.tieba.enterForum.tabfeed.a.a iAS;
    private m iAT;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iAF = enterForumTabFeedFragment;
        this.iAG = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.iAH = new k(this.iAF.getPageContext(), by.eIY, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAH.a(this.iAG);
        this.bnf.add(this.iAH);
        this.iAI = new com.baidu.tieba.enterForum.tabfeed.a.b(this.iAF.getPageContext(), by.eJd, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAI.a(this.iAG);
        this.bnf.add(this.iAI);
        this.iAJ = new d(this.iAF.getPageContext(), by.eJb, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAJ.a(this.iAG);
        this.bnf.add(this.iAJ);
        this.iAK = new c(this.iAF.getPageContext(), by.eJc, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAK.a(this.iAG);
        this.bnf.add(this.iAK);
        this.iAL = new e(this.iAF.getPageContext(), by.eIZ, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAL.a(this.iAG);
        this.bnf.add(this.iAL);
        this.iAM = new l(this.iAF.getPageContext(), by.eJq, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAM.a(this.iAG);
        this.bnf.add(this.iAM);
        this.iAN = new g(this.iAF.getPageContext(), by.eJj, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAN.a(this.iAG);
        this.bnf.add(this.iAN);
        this.iAO = new i(this.iAF.getPageContext(), by.eJl, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAO.a(this.iAG);
        this.bnf.add(this.iAO);
        this.iAP = new h(this.iAF.getPageContext(), by.eJm, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAP.a(this.iAG);
        this.bnf.add(this.iAP);
        this.iAQ = new f(this.iAF.getPageContext(), by.eJi, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAQ.a(this.iAG);
        this.bnf.add(this.iAQ);
        this.iAR = new j(this.iAF.getPageContext(), by.eJe, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAR.a(this.iAG);
        this.bnf.add(this.iAR);
        this.iAS = new com.baidu.tieba.enterForum.tabfeed.a.a(this.iAF.getPageContext(), by.eJh, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAS.a(this.iAG);
        this.bnf.add(this.iAS);
        this.iAT = new m(this.iAF.getPageContext(), bs.eIj, this.iAF.getUniqueId(), this.iAF.getTabName());
        this.iAT.a(this.iAG);
        this.bnf.add(this.iAT);
        this.iAG.addAdapters(this.bnf);
    }

    public void notifyDataSetChanged() {
        this.iAG.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.iAG.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.iAI != null) {
            this.iAI.setFromCDN(z);
        }
        if (this.iAK != null) {
            this.iAK.setFromCDN(z);
        }
        if (this.iAJ != null) {
            this.iAJ.setFromCDN(z);
        }
    }
}
