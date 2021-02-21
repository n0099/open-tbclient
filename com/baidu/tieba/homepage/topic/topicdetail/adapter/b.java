package com.baidu.tieba.homepage.topic.topicdetail.adapter;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bns;
    private s iLY;
    private c koD;
    private a koE;
    private com.baidu.tieba.homepage.topic.topictab.a.b koF;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLY = sVar;
        Kw();
        this.iLY.addAdapters(this.bns);
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.koD = new c(this.mPageContext);
        this.koE = new a(this.mPageContext);
        this.koF = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bns.add(this.koD);
        this.bns.add(this.koE);
        this.bns.add(this.koF);
    }

    public void notifyDataSetChanged() {
        if (this.iLY != null) {
            this.iLY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iLY.setData(list);
    }
}
