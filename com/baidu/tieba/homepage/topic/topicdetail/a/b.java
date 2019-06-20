package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eTY;
    private c gfj;
    private a gfk;
    private com.baidu.tieba.homepage.topic.topictab.a.c gfl;
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
        this.gfj = new c(this.mPageContext);
        this.gfk = new a(this.mPageContext);
        this.gfl = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.mAdapters.add(this.gfj);
        this.mAdapters.add(this.gfk);
        this.mAdapters.add(this.gfl);
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
