package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eEr;
    private c fOl;
    private a fPN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eEr = rVar;
        initAdapters();
        this.eEr.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fPN = new a(this.mPageContext);
        this.fOl = new c(this.mPageContext);
        this.mAdapters.add(this.fPN);
        this.mAdapters.add(this.fOl);
    }

    public void notifyDataSetChanged() {
        if (this.eEr != null) {
            this.eEr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eEr.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
