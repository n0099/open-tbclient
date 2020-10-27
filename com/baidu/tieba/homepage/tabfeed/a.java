package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.homepage.tabfeed.a.d;
import com.baidu.tieba.homepage.tabfeed.a.e;
import com.baidu.tieba.homepage.tabfeed.a.f;
import com.baidu.tieba.homepage.tabfeed.a.g;
import com.baidu.tieba.homepage.tabfeed.a.h;
import com.baidu.tieba.homepage.tabfeed.a.i;
import com.baidu.tieba.homepage.tabfeed.a.j;
import com.baidu.tieba.homepage.tabfeed.a.k;
import com.baidu.tieba.homepage.tabfeed.a.l;
import com.baidu.tieba.homepage.tabfeed.a.m;
import com.baidu.tieba.homepage.tabfeed.a.n;
import com.baidu.tieba.homepage.tabfeed.a.o;
import com.baidu.tieba.homepage.tabfeed.a.p;
import com.baidu.tieba.homepage.tabfeed.a.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private BdTypeRecyclerView ijb;
    private HomePageTabFeedFragment jBC;
    private p jBD;
    private e jBE;
    private g jBF;
    private f jBG;
    private h jBH;
    private q jBI;
    private i jBJ;
    private k jBK;
    private m jBL;
    private l jBM;
    private o jBN;
    private d jBO;
    private com.baidu.tieba.homepage.tabfeed.a.b jBP;
    private com.baidu.tieba.homepage.tabfeed.a.a jBQ;
    private com.baidu.tieba.homepage.tabfeed.a.c jBR;
    private j jBS;
    private n jBT;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jBC = homePageTabFeedFragment;
        this.ijb = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.jBD = new p(this.jBC.getPageContext(), bw.exO, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBD.a(this.ijb);
        this.bje.add(this.jBD);
        this.jBE = new e(this.jBC.getPageContext(), bw.exT, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBE.a(this.ijb);
        this.bje.add(this.jBE);
        this.jBF = new g(this.jBC.getPageContext(), bw.exR, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBF.a(this.ijb);
        this.bje.add(this.jBF);
        this.jBG = new f(this.jBC.getPageContext(), bw.exS, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBG.a(this.ijb);
        this.bje.add(this.jBG);
        this.jBH = new h(this.jBC.getPageContext(), bw.exP, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBH.a(this.ijb);
        this.bje.add(this.jBH);
        this.jBI = new q(this.jBC.getPageContext(), bw.eyg, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBI.a(this.ijb);
        this.bje.add(this.jBI);
        this.jBJ = new i(this.jBC.getPageContext(), bw.exY, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBJ.a(this.ijb);
        this.bje.add(this.jBJ);
        this.jBK = new k(this.jBC.getPageContext(), bw.exZ, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBK.a(this.ijb);
        this.bje.add(this.jBK);
        this.jBL = new m(this.jBC.getPageContext(), bw.eyb, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBL.a(this.ijb);
        this.bje.add(this.jBL);
        this.jBM = new l(this.jBC.getPageContext(), bw.eyc, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBM.a(this.ijb);
        this.bje.add(this.jBM);
        this.jBN = new o(this.jBC.getPageContext(), bw.exU, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBN.a(this.ijb);
        this.bje.add(this.jBN);
        this.jBO = new d(this.jBC.getPageContext(), bw.exX, this.jBC.getUniqueId(), this.jBC.getTabName());
        this.jBO.a(this.ijb);
        this.bje.add(this.jBO);
        this.jBR = new com.baidu.tieba.homepage.tabfeed.a.c(this.jBC.getPageContext(), com.baidu.tieba.card.data.k.TYPE, this.jBC.getTabName());
        this.bje.add(this.jBR);
        this.jBP = new com.baidu.tieba.homepage.tabfeed.a.b(this.jBC.getPageContext(), bo.euv);
        this.jBP.a(this.ijb);
        this.bje.add(this.jBP);
        this.jBQ = new com.baidu.tieba.homepage.tabfeed.a.a(this.jBC.getPageContext(), bj.euv);
        this.jBQ.a(this.ijb);
        this.bje.add(this.jBQ);
        this.jBS = new j(this.jBC.getPageContext());
        this.jBS.a(this.ijb);
        this.bje.add(this.jBS);
        this.jBT = new n(this.jBC.getPageContext());
        this.jBT.a(this.ijb);
        this.bje.add(this.jBT);
        this.ijb.addAdapters(this.bje);
    }

    public void notifyDataSetChanged() {
        this.ijb.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.ijb.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.jBQ != null) {
            this.jBQ.setTabName(str);
        }
    }
}
