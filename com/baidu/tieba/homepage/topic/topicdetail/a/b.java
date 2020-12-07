package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bnf;
    private v iyt;
    private a jXA;
    private com.baidu.tieba.homepage.topic.topictab.a.b jXB;
    private c jXz;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.iyt = vVar;
        Nt();
        this.iyt.addAdapters(this.bnf);
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.jXz = new c(this.mPageContext);
        this.jXA = new a(this.mPageContext);
        this.jXB = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bnf.add(this.jXz);
        this.bnf.add(this.jXA);
        this.bnf.add(this.jXB);
    }

    public void notifyDataSetChanged() {
        if (this.iyt != null) {
            this.iyt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.iyt.setData(list);
    }
}
