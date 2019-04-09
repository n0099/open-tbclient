package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eEd;
    private c fNX;
    private a fNY;
    private com.baidu.tieba.homepage.topic.topictab.a.c fNZ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eEd = rVar;
        initAdapters();
        this.eEd.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fNX = new c(this.mPageContext);
        this.fNY = new a(this.mPageContext);
        this.fNZ = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.mAdapters.add(this.fNX);
        this.mAdapters.add(this.fNY);
        this.mAdapters.add(this.fNZ);
    }

    public void notifyDataSetChanged() {
        if (this.eEd != null) {
            this.eEd.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eEd.setData(list);
    }
}
