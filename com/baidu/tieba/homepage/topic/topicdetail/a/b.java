package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eTX;
    private c gfg;
    private a gfh;
    private com.baidu.tieba.homepage.topic.topictab.a.c gfi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eTX = rVar;
        initAdapters();
        this.eTX.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.gfg = new c(this.mPageContext);
        this.gfh = new a(this.mPageContext);
        this.gfi = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.mAdapters.add(this.gfg);
        this.mAdapters.add(this.gfh);
        this.mAdapters.add(this.gfi);
    }

    public void notifyDataSetChanged() {
        if (this.eTX != null) {
            this.eTX.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eTX.setData(list);
    }
}
