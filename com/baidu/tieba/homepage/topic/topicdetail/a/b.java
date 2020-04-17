package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aMd;
    private r gEc;
    private c hRr;
    private a hRs;
    private com.baidu.tieba.homepage.topic.topictab.a.c hRt;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.gEc = rVar;
        BC();
        this.gEc.addAdapters(this.aMd);
    }

    private void BC() {
        this.aMd = new ArrayList();
        this.hRr = new c(this.mPageContext);
        this.hRs = new a(this.mPageContext);
        this.hRt = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.aMd.add(this.hRr);
        this.aMd.add(this.hRs);
        this.aMd.add(this.hRt);
    }

    public void notifyDataSetChanged() {
        if (this.gEc != null) {
            this.gEc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.gEc.setData(list);
    }
}
