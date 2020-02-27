package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> asE;
    private r fWB;
    private c hfT;
    private a hfU;
    private com.baidu.tieba.homepage.topic.topictab.a.c hfV;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fWB = rVar;
        wM();
        this.fWB.addAdapters(this.asE);
    }

    private void wM() {
        this.asE = new ArrayList();
        this.hfT = new c(this.mPageContext);
        this.hfU = new a(this.mPageContext);
        this.hfV = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.asE.add(this.hfT);
        this.asE.add(this.hfU);
        this.asE.add(this.hfV);
    }

    public void notifyDataSetChanged() {
        if (this.fWB != null) {
            this.fWB.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fWB.setData(list);
    }
}
