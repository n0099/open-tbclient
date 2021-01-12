package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bz;
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
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private BdTypeRecyclerView iIn;
    private h keA;
    private q keB;
    private i keC;
    private k keD;
    private m keE;
    private l keF;
    private o keG;
    private d keH;
    private com.baidu.tieba.homepage.tabfeed.a.b keI;
    private com.baidu.tieba.homepage.tabfeed.a.a keJ;
    private com.baidu.tieba.homepage.tabfeed.a.c keK;
    private j keL;
    private n keM;
    private HomePageTabFeedFragment keu;
    private p kev;
    private e kew;
    private g kex;
    private f kez;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.keu = homePageTabFeedFragment;
        this.iIn = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.kev = new p(this.keu.getPageContext(), bz.eOg, this.keu.getUniqueId(), this.keu.getTabName());
        this.kev.a(this.iIn);
        this.bjZ.add(this.kev);
        this.kew = new e(this.keu.getPageContext(), bz.eOl, this.keu.getUniqueId(), this.keu.getTabName());
        this.kew.a(this.iIn);
        this.bjZ.add(this.kew);
        this.kex = new g(this.keu.getPageContext(), bz.eOj, this.keu.getUniqueId(), this.keu.getTabName());
        this.kex.a(this.iIn);
        this.bjZ.add(this.kex);
        this.kez = new f(this.keu.getPageContext(), bz.eOk, this.keu.getUniqueId(), this.keu.getTabName());
        this.kez.a(this.iIn);
        this.bjZ.add(this.kez);
        this.keA = new h(this.keu.getPageContext(), bz.eOh, this.keu.getUniqueId(), this.keu.getTabName());
        this.keA.a(this.iIn);
        this.bjZ.add(this.keA);
        this.keB = new q(this.keu.getPageContext(), bz.eOy, this.keu.getUniqueId(), this.keu.getTabName());
        this.keB.a(this.iIn);
        this.bjZ.add(this.keB);
        this.keC = new i(this.keu.getPageContext(), bz.eOq, this.keu.getUniqueId(), this.keu.getTabName());
        this.keC.a(this.iIn);
        this.bjZ.add(this.keC);
        this.keD = new k(this.keu.getPageContext(), bz.eOr, this.keu.getUniqueId(), this.keu.getTabName());
        this.keD.a(this.iIn);
        this.bjZ.add(this.keD);
        this.keE = new m(this.keu.getPageContext(), bz.eOt, this.keu.getUniqueId(), this.keu.getTabName());
        this.keE.a(this.iIn);
        this.bjZ.add(this.keE);
        this.keF = new l(this.keu.getPageContext(), bz.eOu, this.keu.getUniqueId(), this.keu.getTabName());
        this.keF.a(this.iIn);
        this.bjZ.add(this.keF);
        this.keG = new o(this.keu.getPageContext(), bz.eOm, this.keu.getUniqueId(), this.keu.getTabName());
        this.keG.a(this.iIn);
        this.bjZ.add(this.keG);
        this.keH = new d(this.keu.getPageContext(), bz.eOp, this.keu.getUniqueId(), this.keu.getTabName());
        this.keH.a(this.iIn);
        this.bjZ.add(this.keH);
        this.keK = new com.baidu.tieba.homepage.tabfeed.a.c(this.keu.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.keu.getTabName());
        this.bjZ.add(this.keK);
        this.keI = new com.baidu.tieba.homepage.tabfeed.a.b(this.keu.getPageContext(), br.eKJ);
        this.keI.a(this.iIn);
        this.bjZ.add(this.keI);
        this.keJ = new com.baidu.tieba.homepage.tabfeed.a.a(this.keu.getPageContext(), bm.eKJ);
        this.keJ.a(this.iIn);
        this.bjZ.add(this.keJ);
        this.keL = new j(this.keu.getPageContext());
        this.keL.a(this.iIn);
        this.bjZ.add(this.keL);
        this.keM = new n(this.keu.getPageContext());
        this.keM.a(this.iIn);
        this.bjZ.add(this.keM);
        this.iIn.addAdapters(this.bjZ);
    }

    public void notifyDataSetChanged() {
        this.iIn.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        this.iIn.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.keJ != null) {
            this.keJ.setTabName(str);
        }
    }
}
