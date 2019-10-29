package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> agQ;
    private r fdE;
    private c gnF;
    private a gnG;
    private com.baidu.tieba.homepage.topic.topictab.a.c gnH;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fdE = rVar;
        sX();
        this.fdE.addAdapters(this.agQ);
    }

    private void sX() {
        this.agQ = new ArrayList();
        this.gnF = new c(this.mPageContext);
        this.gnG = new a(this.mPageContext);
        this.gnH = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.agQ.add(this.gnF);
        this.agQ.add(this.gnG);
        this.agQ.add(this.gnH);
    }

    public void notifyDataSetChanged() {
        if (this.fdE != null) {
            this.fdE.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fdE.setData(list);
    }
}
