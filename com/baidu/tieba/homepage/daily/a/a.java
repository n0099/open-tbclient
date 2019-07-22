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
    private r eYZ;
    private e gdB;
    private d gdC;
    private c gdD;
    private b gdE;
    private f gdF;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eYZ = rVar;
        initAdapters();
        this.eYZ.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.gdB = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.gdT);
        this.gdC = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.gdP);
        this.gdD = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.gdN);
        this.gdE = new b(this.mPageContext, bg.bJj);
        this.gdF = new f(this.mPageContext, bg.bJx);
        this.mAdapters.add(this.gdB);
        this.mAdapters.add(this.gdC);
        this.mAdapters.add(this.gdD);
        this.mAdapters.add(this.gdE);
        this.mAdapters.add(this.gdF);
    }

    public void notifyDataSetChanged() {
        if (this.eYZ != null) {
            this.eYZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eYZ.setData(list);
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
