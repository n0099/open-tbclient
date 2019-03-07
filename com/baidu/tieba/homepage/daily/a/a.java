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
    private r eEv;
    private e fHT;
    private d fHU;
    private c fHV;
    private b fHW;
    private f fHX;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eEv = rVar;
        initAdapters();
        this.eEv.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fHT = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.fIl);
        this.fHU = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.fIh);
        this.fHV = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.fIf);
        this.fHW = new b(this.mPageContext, bg.bAO);
        this.fHX = new f(this.mPageContext, bg.bBb);
        this.mAdapters.add(this.fHT);
        this.mAdapters.add(this.fHU);
        this.mAdapters.add(this.fHV);
        this.mAdapters.add(this.fHW);
        this.mAdapters.add(this.fHX);
    }

    public void notifyDataSetChanged() {
        if (this.eEv != null) {
            this.eEv.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eEv.setData(list);
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
