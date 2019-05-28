package com.baidu.tieba.homepage.daily.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private r eTY;
    private e fYC;
    private d fYD;
    private c fYE;
    private b fYF;
    private f fYG;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eTY = rVar;
        initAdapters();
        this.eTY.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fYC = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.fYU);
        this.fYD = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.fYQ);
        this.fYE = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.fYO);
        this.fYF = new b(this.mPageContext, bg.bIi);
        this.fYG = new f(this.mPageContext, bg.bIw);
        this.mAdapters.add(this.fYC);
        this.mAdapters.add(this.fYD);
        this.mAdapters.add(this.fYE);
        this.mAdapters.add(this.fYF);
        this.mAdapters.add(this.fYG);
    }

    public void notifyDataSetChanged() {
        if (this.eTY != null) {
            this.eTY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eTY.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
