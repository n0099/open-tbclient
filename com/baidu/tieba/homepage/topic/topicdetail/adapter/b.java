package com.baidu.tieba.homepage.topic.topicdetail.adapter;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bns;
    private s iLK;
    private c kop;
    private a koq;
    private com.baidu.tieba.homepage.topic.topictab.a.b kor;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLK = sVar;
        Kw();
        this.iLK.addAdapters(this.bns);
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.kop = new c(this.mPageContext);
        this.koq = new a(this.mPageContext);
        this.kor = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bns.add(this.kop);
        this.bns.add(this.koq);
        this.bns.add(this.kor);
    }

    public void notifyDataSetChanged() {
        if (this.iLK != null) {
            this.iLK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iLK.setData(list);
    }
}
