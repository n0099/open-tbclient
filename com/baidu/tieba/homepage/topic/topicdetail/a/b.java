package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eZn;
    private c gmp;
    private a gmq;
    private com.baidu.tieba.homepage.topic.topictab.a.c gmr;
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
        this.gmp = new c(this.mPageContext);
        this.gmq = new a(this.mPageContext);
        this.gmr = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.mAdapters.add(this.gmp);
        this.mAdapters.add(this.gmq);
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
}
