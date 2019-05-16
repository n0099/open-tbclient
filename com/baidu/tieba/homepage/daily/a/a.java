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
    private r eTX;
    private e fYB;
    private d fYC;
    private c fYD;
    private b fYE;
    private f fYF;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eTX = rVar;
        initAdapters();
        this.eTX.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fYB = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.fYT);
        this.fYC = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.fYP);
        this.fYD = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.fYN);
        this.fYE = new b(this.mPageContext, bg.bIi);
        this.fYF = new f(this.mPageContext, bg.bIw);
        this.mAdapters.add(this.fYB);
        this.mAdapters.add(this.fYC);
        this.mAdapters.add(this.fYD);
        this.mAdapters.add(this.fYE);
        this.mAdapters.add(this.fYF);
    }

    public void notifyDataSetChanged() {
        if (this.eTX != null) {
            this.eTX.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eTX.setData(list);
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
