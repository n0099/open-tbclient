package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bbu;
    private v hyl;
    private c iTd;
    private a iTe;
    private com.baidu.tieba.homepage.topic.topictab.a.b iTf;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hyl = vVar;
        Jv();
        this.hyl.addAdapters(this.bbu);
    }

    private void Jv() {
        this.bbu = new ArrayList();
        this.iTd = new c(this.mPageContext);
        this.iTe = new a(this.mPageContext);
        this.iTf = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bbu.add(this.iTd);
        this.bbu.add(this.iTe);
        this.bbu.add(this.iTf);
    }

    public void notifyDataSetChanged() {
        if (this.hyl != null) {
            this.hyl.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hyl.setData(list);
    }
}
