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
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private EnterForumTabFeedFragment hAD;
    private BdTypeRecyclerView hAE;
    private k hAF;
    private com.baidu.tieba.enterForum.tabfeed.a.b hAG;
    private d hAH;
    private c hAI;
    private e hAJ;
    private l hAK;
    private g hAL;
    private i hAM;
    private h hAN;
    private f hAO;
    private j hAP;
    private com.baidu.tieba.enterForum.tabfeed.a.a hAQ;
    private m hAR;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hAD = enterForumTabFeedFragment;
        this.hAE = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.hAF = new k(this.hAD.getPageContext(), bw.ebb, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAF.a(this.hAE);
        this.bbw.add(this.hAF);
        this.hAG = new com.baidu.tieba.enterForum.tabfeed.a.b(this.hAD.getPageContext(), bw.ebg, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAG.a(this.hAE);
        this.bbw.add(this.hAG);
        this.hAH = new d(this.hAD.getPageContext(), bw.ebe, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAH.a(this.hAE);
        this.bbw.add(this.hAH);
        this.hAI = new c(this.hAD.getPageContext(), bw.ebf, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAI.a(this.hAE);
        this.bbw.add(this.hAI);
        this.hAJ = new e(this.hAD.getPageContext(), bw.ebc, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAJ.a(this.hAE);
        this.bbw.add(this.hAJ);
        this.hAK = new l(this.hAD.getPageContext(), bw.ebs, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAK.a(this.hAE);
        this.bbw.add(this.hAK);
        this.hAL = new g(this.hAD.getPageContext(), bw.ebm, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAL.a(this.hAE);
        this.bbw.add(this.hAL);
        this.hAM = new i(this.hAD.getPageContext(), bw.ebo, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAM.a(this.hAE);
        this.bbw.add(this.hAM);
        this.hAN = new h(this.hAD.getPageContext(), bw.ebp, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAN.a(this.hAE);
        this.bbw.add(this.hAN);
        this.hAO = new f(this.hAD.getPageContext(), bw.ebl, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAO.a(this.hAE);
        this.bbw.add(this.hAO);
        this.hAP = new j(this.hAD.getPageContext(), bw.ebh, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAP.a(this.hAE);
        this.bbw.add(this.hAP);
        this.hAQ = new com.baidu.tieba.enterForum.tabfeed.a.a(this.hAD.getPageContext(), bw.ebk, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAQ.a(this.hAE);
        this.bbw.add(this.hAQ);
        this.hAR = new m(this.hAD.getPageContext(), bq.eao, this.hAD.getUniqueId(), this.hAD.getTabName());
        this.hAR.a(this.hAE);
        this.bbw.add(this.hAR);
        this.hAE.addAdapters(this.bbw);
    }

    public void notifyDataSetChanged() {
        this.hAE.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.hAE.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.hAG != null) {
            this.hAG.setFromCDN(z);
        }
        if (this.hAI != null) {
            this.hAI.setFromCDN(z);
        }
        if (this.hAH != null) {
            this.hAH.setFromCDN(z);
        }
    }
}
