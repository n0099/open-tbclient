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
    private r eEd;
    private e fHG;
    private d fHH;
    private c fHI;
    private b fHJ;
    private f fHK;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eEd = rVar;
        initAdapters();
        this.eEd.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fHG = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.fHY);
        this.fHH = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.fHU);
        this.fHI = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.fHS);
        this.fHJ = new b(this.mPageContext, bg.bAU);
        this.fHK = new f(this.mPageContext, bg.bBh);
        this.mAdapters.add(this.fHG);
        this.mAdapters.add(this.fHH);
        this.mAdapters.add(this.fHI);
        this.mAdapters.add(this.fHJ);
        this.mAdapters.add(this.fHK);
    }

    public void notifyDataSetChanged() {
        if (this.eEd != null) {
            this.eEd.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eEd.setData(list);
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
