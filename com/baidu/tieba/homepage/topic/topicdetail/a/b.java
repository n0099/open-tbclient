package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eTY;
    private c gfh;
    private a gfi;
    private com.baidu.tieba.homepage.topic.topictab.a.c gfj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eTY = rVar;
        initAdapters();
        this.eTY.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.gfh = new c(this.mPageContext);
        this.gfi = new a(this.mPageContext);
        this.gfj = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.mAdapters.add(this.gfh);
        this.mAdapters.add(this.gfi);
        this.mAdapters.add(this.gfj);
    }

    public void notifyDataSetChanged() {
        if (this.eTY != null) {
            this.eTY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eTY.setData(list);
    }
}
