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
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private EnterForumTabFeedFragment hHF;
    private BdTypeRecyclerView hHG;
    private k hHH;
    private com.baidu.tieba.enterForum.tabfeed.a.b hHI;
    private d hHJ;
    private c hHK;
    private e hHL;
    private l hHM;
    private g hHN;
    private i hHO;
    private h hHP;
    private f hHQ;
    private j hHR;
    private com.baidu.tieba.enterForum.tabfeed.a.a hHS;
    private m hHT;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hHF = enterForumTabFeedFragment;
        this.hHG = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.hHH = new k(this.hHF.getPageContext(), bw.edl, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHH.a(this.hHG);
        this.bdV.add(this.hHH);
        this.hHI = new com.baidu.tieba.enterForum.tabfeed.a.b(this.hHF.getPageContext(), bw.edq, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHI.a(this.hHG);
        this.bdV.add(this.hHI);
        this.hHJ = new d(this.hHF.getPageContext(), bw.edo, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHJ.a(this.hHG);
        this.bdV.add(this.hHJ);
        this.hHK = new c(this.hHF.getPageContext(), bw.edp, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHK.a(this.hHG);
        this.bdV.add(this.hHK);
        this.hHL = new e(this.hHF.getPageContext(), bw.edm, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHL.a(this.hHG);
        this.bdV.add(this.hHL);
        this.hHM = new l(this.hHF.getPageContext(), bw.edC, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHM.a(this.hHG);
        this.bdV.add(this.hHM);
        this.hHN = new g(this.hHF.getPageContext(), bw.edw, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHN.a(this.hHG);
        this.bdV.add(this.hHN);
        this.hHO = new i(this.hHF.getPageContext(), bw.edy, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHO.a(this.hHG);
        this.bdV.add(this.hHO);
        this.hHP = new h(this.hHF.getPageContext(), bw.edz, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHP.a(this.hHG);
        this.bdV.add(this.hHP);
        this.hHQ = new f(this.hHF.getPageContext(), bw.edv, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHQ.a(this.hHG);
        this.bdV.add(this.hHQ);
        this.hHR = new j(this.hHF.getPageContext(), bw.edr, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHR.a(this.hHG);
        this.bdV.add(this.hHR);
        this.hHS = new com.baidu.tieba.enterForum.tabfeed.a.a(this.hHF.getPageContext(), bw.edu, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHS.a(this.hHG);
        this.bdV.add(this.hHS);
        this.hHT = new m(this.hHF.getPageContext(), bq.ecy, this.hHF.getUniqueId(), this.hHF.getTabName());
        this.hHT.a(this.hHG);
        this.bdV.add(this.hHT);
        this.hHG.addAdapters(this.bdV);
    }

    public void notifyDataSetChanged() {
        this.hHG.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.hHG.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.hHI != null) {
            this.hHI.setFromCDN(z);
        }
        if (this.hHK != null) {
            this.hHK.setFromCDN(z);
        }
        if (this.hHJ != null) {
            this.hHJ.setFromCDN(z);
        }
    }
}
