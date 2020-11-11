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
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private BdTypeRecyclerView ipa;
    private p jHA;
    private e jHB;
    private g jHC;
    private f jHD;
    private h jHE;
    private q jHF;
    private i jHG;
    private k jHH;
    private m jHI;
    private l jHJ;
    private o jHK;
    private d jHL;
    private com.baidu.tieba.homepage.tabfeed.a.b jHM;
    private com.baidu.tieba.homepage.tabfeed.a.a jHN;
    private com.baidu.tieba.homepage.tabfeed.a.c jHO;
    private j jHP;
    private n jHQ;
    private HomePageTabFeedFragment jHz;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jHz = homePageTabFeedFragment;
        this.ipa = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.jHA = new p(this.jHz.getPageContext(), bw.eDF, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHA.a(this.ipa);
        this.bky.add(this.jHA);
        this.jHB = new e(this.jHz.getPageContext(), bw.eDK, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHB.a(this.ipa);
        this.bky.add(this.jHB);
        this.jHC = new g(this.jHz.getPageContext(), bw.eDI, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHC.a(this.ipa);
        this.bky.add(this.jHC);
        this.jHD = new f(this.jHz.getPageContext(), bw.eDJ, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHD.a(this.ipa);
        this.bky.add(this.jHD);
        this.jHE = new h(this.jHz.getPageContext(), bw.eDG, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHE.a(this.ipa);
        this.bky.add(this.jHE);
        this.jHF = new q(this.jHz.getPageContext(), bw.eDW, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHF.a(this.ipa);
        this.bky.add(this.jHF);
        this.jHG = new i(this.jHz.getPageContext(), bw.eDP, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHG.a(this.ipa);
        this.bky.add(this.jHG);
        this.jHH = new k(this.jHz.getPageContext(), bw.eDQ, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHH.a(this.ipa);
        this.bky.add(this.jHH);
        this.jHI = new m(this.jHz.getPageContext(), bw.eDS, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHI.a(this.ipa);
        this.bky.add(this.jHI);
        this.jHJ = new l(this.jHz.getPageContext(), bw.eDT, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHJ.a(this.ipa);
        this.bky.add(this.jHJ);
        this.jHK = new o(this.jHz.getPageContext(), bw.eDL, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHK.a(this.ipa);
        this.bky.add(this.jHK);
        this.jHL = new d(this.jHz.getPageContext(), bw.eDO, this.jHz.getUniqueId(), this.jHz.getTabName());
        this.jHL.a(this.ipa);
        this.bky.add(this.jHL);
        this.jHO = new com.baidu.tieba.homepage.tabfeed.a.c(this.jHz.getPageContext(), com.baidu.tieba.card.data.k.TYPE, this.jHz.getTabName());
        this.bky.add(this.jHO);
        this.jHM = new com.baidu.tieba.homepage.tabfeed.a.b(this.jHz.getPageContext(), bo.eAo);
        this.jHM.a(this.ipa);
        this.bky.add(this.jHM);
        this.jHN = new com.baidu.tieba.homepage.tabfeed.a.a(this.jHz.getPageContext(), bj.eAo);
        this.jHN.a(this.ipa);
        this.bky.add(this.jHN);
        this.jHP = new j(this.jHz.getPageContext());
        this.jHP.a(this.ipa);
        this.bky.add(this.jHP);
        this.jHQ = new n(this.jHz.getPageContext());
        this.jHQ.a(this.ipa);
        this.bky.add(this.jHQ);
        this.ipa.addAdapters(this.bky);
    }

    public void notifyDataSetChanged() {
        this.ipa.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.ipa.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.jHN != null) {
            this.jHN.setTabName(str);
        }
    }
}
