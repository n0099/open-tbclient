package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bdV;
    private v hFt;
    private c jbP;
    private a jbQ;
    private com.baidu.tieba.homepage.topic.topictab.a.b jbR;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hFt = vVar;
        JZ();
        this.hFt.addAdapters(this.bdV);
    }

    private void JZ() {
        this.bdV = new ArrayList();
        this.jbP = new c(this.mPageContext);
        this.jbQ = new a(this.mPageContext);
        this.jbR = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bdV.add(this.jbP);
        this.bdV.add(this.jbQ);
        this.bdV.add(this.jbR);
    }

    public void notifyDataSetChanged() {
        if (this.hFt != null) {
            this.hFt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hFt.setData(list);
    }
}
