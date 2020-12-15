package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bnf;
    private v iyv;
    private c jXB;
    private a jXC;
    private com.baidu.tieba.homepage.topic.topictab.a.b jXD;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.iyv = vVar;
        Nt();
        this.iyv.addAdapters(this.bnf);
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.jXB = new c(this.mPageContext);
        this.jXC = new a(this.mPageContext);
        this.jXD = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bnf.add(this.jXB);
        this.bnf.add(this.jXC);
        this.bnf.add(this.jXD);
    }

    public void notifyDataSetChanged() {
        if (this.iyv != null) {
            this.iyv.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.iyv.setData(list);
    }
}
