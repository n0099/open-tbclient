package com.baidu.tieba.enterForum.tabfeed;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bx;
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
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private EnterForumTabFeedFragment ipN;
    private BdTypeRecyclerView ipO;
    private k ipP;
    private com.baidu.tieba.enterForum.tabfeed.a.b ipQ;
    private d ipR;
    private c ipS;
    private e ipT;
    private l ipU;
    private g ipV;
    private i ipW;
    private h ipX;
    private f ipY;
    private j ipZ;
    private com.baidu.tieba.enterForum.tabfeed.a.a iqa;
    private m iqb;

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ipN = enterForumTabFeedFragment;
        this.ipO = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.ipP = new k(this.ipN.getPageContext(), bx.eBX, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipP.a(this.ipO);
        this.biN.add(this.ipP);
        this.ipQ = new com.baidu.tieba.enterForum.tabfeed.a.b(this.ipN.getPageContext(), bx.eCc, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipQ.a(this.ipO);
        this.biN.add(this.ipQ);
        this.ipR = new d(this.ipN.getPageContext(), bx.eCa, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipR.a(this.ipO);
        this.biN.add(this.ipR);
        this.ipS = new c(this.ipN.getPageContext(), bx.eCb, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipS.a(this.ipO);
        this.biN.add(this.ipS);
        this.ipT = new e(this.ipN.getPageContext(), bx.eBY, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipT.a(this.ipO);
        this.biN.add(this.ipT);
        this.ipU = new l(this.ipN.getPageContext(), bx.eCo, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipU.a(this.ipO);
        this.biN.add(this.ipU);
        this.ipV = new g(this.ipN.getPageContext(), bx.eCi, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipV.a(this.ipO);
        this.biN.add(this.ipV);
        this.ipW = new i(this.ipN.getPageContext(), bx.eCk, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipW.a(this.ipO);
        this.biN.add(this.ipW);
        this.ipX = new h(this.ipN.getPageContext(), bx.eCl, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipX.a(this.ipO);
        this.biN.add(this.ipX);
        this.ipY = new f(this.ipN.getPageContext(), bx.eCh, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipY.a(this.ipO);
        this.biN.add(this.ipY);
        this.ipZ = new j(this.ipN.getPageContext(), bx.eCd, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.ipZ.a(this.ipO);
        this.biN.add(this.ipZ);
        this.iqa = new com.baidu.tieba.enterForum.tabfeed.a.a(this.ipN.getPageContext(), bx.eCg, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.iqa.a(this.ipO);
        this.biN.add(this.iqa);
        this.iqb = new m(this.ipN.getPageContext(), br.eBj, this.ipN.getUniqueId(), this.ipN.getTabName());
        this.iqb.a(this.ipO);
        this.biN.add(this.iqb);
        this.ipO.addAdapters(this.biN);
    }

    public void notifyDataSetChanged() {
        this.ipO.getAdapter().notifyDataSetChanged();
    }

    public void setData(ArrayList<q> arrayList) {
        this.ipO.setData(arrayList);
    }

    public void setIsFromCDN(boolean z) {
        if (this.ipQ != null) {
            this.ipQ.setFromCDN(z);
        }
        if (this.ipS != null) {
            this.ipS.setFromCDN(z);
        }
        if (this.ipR != null) {
            this.ipR.setFromCDN(z);
        }
    }
}
