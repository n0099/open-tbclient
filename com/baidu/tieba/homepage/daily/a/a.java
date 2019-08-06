package com.baidu.tieba.homepage.daily.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private r eZn;
    private e ges;
    private d get;
    private c geu;
    private b gev;
    private f gew;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eZn = rVar;
        initAdapters();
        this.eZn.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.ges = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.geK);
        this.get = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.geG);
        this.geu = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.geE);
        this.gev = new b(this.mPageContext, bh.bJo);
        this.gew = new f(this.mPageContext, bh.bJC);
        this.mAdapters.add(this.ges);
        this.mAdapters.add(this.get);
        this.mAdapters.add(this.geu);
        this.mAdapters.add(this.gev);
        this.mAdapters.add(this.gew);
    }

    public void notifyDataSetChanged() {
        if (this.eZn != null) {
            this.eZn.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eZn.setData(list);
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
