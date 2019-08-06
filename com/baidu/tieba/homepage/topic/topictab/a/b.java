package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eZn;
    private c gmr;
    private a gnQ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eZn = rVar;
        initAdapters();
        this.eZn.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.gnQ = new a(this.mPageContext);
        this.gmr = new c(this.mPageContext);
        this.mAdapters.add(this.gnQ);
        this.mAdapters.add(this.gmr);
    }

    public void notifyDataSetChanged() {
        if (this.eZn != null) {
            this.eZn.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eZn.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
