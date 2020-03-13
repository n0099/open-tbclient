package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> asF;
    private r fWQ;
    private c hgh;
    private a hgi;
    private com.baidu.tieba.homepage.topic.topictab.a.c hgj;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fWQ = rVar;
        wM();
        this.fWQ.addAdapters(this.asF);
    }

    private void wM() {
        this.asF = new ArrayList();
        this.hgh = new c(this.mPageContext);
        this.hgi = new a(this.mPageContext);
        this.hgj = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.asF.add(this.hgh);
        this.asF.add(this.hgi);
        this.asF.add(this.hgj);
    }

    public void notifyDataSetChanged() {
        if (this.fWQ != null) {
            this.fWQ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fWQ.setData(list);
    }
}
