package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eEr;
    private c fOj;
    private a fOk;
    private com.baidu.tieba.homepage.topic.topictab.a.c fOl;
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
        this.fOj = new c(this.mPageContext);
        this.fOk = new a(this.mPageContext);
        this.fOl = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.mAdapters.add(this.fOj);
        this.mAdapters.add(this.fOk);
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
}
