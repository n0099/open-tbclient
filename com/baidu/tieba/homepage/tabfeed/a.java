package com.baidu.tieba.homepage.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.cb;
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
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private BdTypeRecyclerView iOj;
    private HomePageTabFeedFragment kmR;
    private p kmS;
    private e kmT;
    private g kmU;
    private f kmV;
    private h kmW;
    private q kmX;
    private i kmY;
    private k kmZ;
    private m kna;
    private l knb;
    private o knc;
    private d knd;
    private com.baidu.tieba.homepage.tabfeed.a.b kne;
    private com.baidu.tieba.homepage.tabfeed.a.a knf;
    private com.baidu.tieba.homepage.tabfeed.a.c kng;
    private j knh;
    private n kni;

    public a(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kmR = homePageTabFeedFragment;
        this.iOj = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.kmS = new p(this.kmR.getPageContext(), cb.eQs, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.kmS.a(this.iOj);
        this.bns.add(this.kmS);
        this.kmT = new e(this.kmR.getPageContext(), cb.eQx, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.kmT.a(this.iOj);
        this.bns.add(this.kmT);
        this.kmU = new g(this.kmR.getPageContext(), cb.eQv, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.kmU.a(this.iOj);
        this.bns.add(this.kmU);
        this.kmV = new f(this.kmR.getPageContext(), cb.eQw, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.kmV.a(this.iOj);
        this.bns.add(this.kmV);
        this.kmW = new h(this.kmR.getPageContext(), cb.eQt, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.kmW.a(this.iOj);
        this.bns.add(this.kmW);
        this.kmX = new q(this.kmR.getPageContext(), cb.eQK, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.kmX.a(this.iOj);
        this.bns.add(this.kmX);
        this.kmY = new i(this.kmR.getPageContext(), cb.eQC, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.kmY.a(this.iOj);
        this.bns.add(this.kmY);
        this.kmZ = new k(this.kmR.getPageContext(), cb.eQD, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.kmZ.a(this.iOj);
        this.bns.add(this.kmZ);
        this.kna = new m(this.kmR.getPageContext(), cb.eQF, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.kna.a(this.iOj);
        this.bns.add(this.kna);
        this.knb = new l(this.kmR.getPageContext(), cb.eQG, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.knb.a(this.iOj);
        this.bns.add(this.knb);
        this.knc = new o(this.kmR.getPageContext(), cb.eQy, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.knc.a(this.iOj);
        this.bns.add(this.knc);
        this.knd = new d(this.kmR.getPageContext(), cb.eQB, this.kmR.getUniqueId(), this.kmR.getTabName());
        this.knd.a(this.iOj);
        this.bns.add(this.knd);
        this.kng = new com.baidu.tieba.homepage.tabfeed.a.c(this.kmR.getPageContext(), com.baidu.tieba.card.data.j.TYPE, this.kmR.getTabName());
        this.bns.add(this.kng);
        this.kne = new com.baidu.tieba.homepage.tabfeed.a.b(this.kmR.getPageContext(), bt.eMV);
        this.kne.a(this.iOj);
        this.bns.add(this.kne);
        this.knf = new com.baidu.tieba.homepage.tabfeed.a.a(this.kmR.getPageContext(), bo.eMV);
        this.knf.a(this.iOj);
        this.bns.add(this.knf);
        this.knh = new j(this.kmR.getPageContext());
        this.knh.a(this.iOj);
        this.bns.add(this.knh);
        this.kni = new n(this.kmR.getPageContext());
        this.kni.a(this.iOj);
        this.bns.add(this.kni);
        this.iOj.addAdapters(this.bns);
    }

    public void notifyDataSetChanged() {
        this.iOj.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        this.iOj.setData(arrayList);
    }

    public void setTabName(String str) {
        if (this.knf != null) {
            this.knf.setTabName(str);
        }
    }
}
