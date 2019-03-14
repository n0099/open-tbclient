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
    private r eEr;
    private e fHS;
    private d fHT;
    private c fHU;
    private b fHV;
    private f fHW;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eEr = rVar;
        initAdapters();
        this.eEr.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fHS = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.fIk);
        this.fHT = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.fIg);
        this.fHU = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.fIe);
        this.fHV = new b(this.mPageContext, bg.bAQ);
        this.fHW = new f(this.mPageContext, bg.bBd);
        this.mAdapters.add(this.fHS);
        this.mAdapters.add(this.fHT);
        this.mAdapters.add(this.fHU);
        this.mAdapters.add(this.fHV);
        this.mAdapters.add(this.fHW);
    }

    public void notifyDataSetChanged() {
        if (this.eEr != null) {
            this.eEr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eEr.setData(list);
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
