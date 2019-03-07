package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eEv;
    private c fOk;
    private a fOl;
    private com.baidu.tieba.homepage.topic.topictab.a.c fOm;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eEv = rVar;
        initAdapters();
        this.eEv.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fOk = new c(this.mPageContext);
        this.fOl = new a(this.mPageContext);
        this.fOm = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.mAdapters.add(this.fOk);
        this.mAdapters.add(this.fOl);
        this.mAdapters.add(this.fOm);
    }

    public void notifyDataSetChanged() {
        if (this.eEv != null) {
            this.eEv.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eEv.setData(list);
    }
}
