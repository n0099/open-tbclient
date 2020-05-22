package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aSj;
    private t gSQ;
    private c igh;
    private a igi;
    private com.baidu.tieba.homepage.topic.topictab.a.c igj;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, t tVar) {
        this.mPageContext = tbPageContext;
        this.gSQ = tVar;
        CY();
        this.gSQ.addAdapters(this.aSj);
    }

    private void CY() {
        this.aSj = new ArrayList();
        this.igh = new c(this.mPageContext);
        this.igi = new a(this.mPageContext);
        this.igj = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.aSj.add(this.igh);
        this.aSj.add(this.igi);
        this.aSj.add(this.igj);
    }

    public void notifyDataSetChanged() {
        if (this.gSQ != null) {
            this.gSQ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<o> list) {
        this.gSQ.setData(list);
    }
}
