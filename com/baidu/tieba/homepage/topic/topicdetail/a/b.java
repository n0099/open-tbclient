package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r faT;
    private c gog;
    private a goh;
    private com.baidu.tieba.homepage.topic.topictab.a.c goi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.faT = rVar;
        initAdapters();
        this.faT.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.gog = new c(this.mPageContext);
        this.goh = new a(this.mPageContext);
        this.goi = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.mAdapters.add(this.gog);
        this.mAdapters.add(this.goh);
        this.mAdapters.add(this.goi);
    }

    public void notifyDataSetChanged() {
        if (this.faT != null) {
            this.faT.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.faT.setData(list);
    }
}
