package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> asP;
    private r fXy;
    private c hhH;
    private a hhI;
    private com.baidu.tieba.homepage.topic.topictab.a.c hhJ;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fXy = rVar;
        wR();
        this.fXy.addAdapters(this.asP);
    }

    private void wR() {
        this.asP = new ArrayList();
        this.hhH = new c(this.mPageContext);
        this.hhI = new a(this.mPageContext);
        this.hhJ = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.asP.add(this.hhH);
        this.asP.add(this.hhI);
        this.asP.add(this.hhJ);
    }

    public void notifyDataSetChanged() {
        if (this.fXy != null) {
            this.fXy.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fXy.setData(list);
    }
}
