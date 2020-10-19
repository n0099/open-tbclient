package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bhH;
    private v hUo;
    private c jqO;
    private a jqP;
    private com.baidu.tieba.homepage.topic.topictab.a.b jqQ;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hUo = vVar;
        Le();
        this.hUo.addAdapters(this.bhH);
    }

    private void Le() {
        this.bhH = new ArrayList();
        this.jqO = new c(this.mPageContext);
        this.jqP = new a(this.mPageContext);
        this.jqQ = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bhH.add(this.jqO);
        this.bhH.add(this.jqP);
        this.bhH.add(this.jqQ);
    }

    public void notifyDataSetChanged() {
        if (this.hUo != null) {
            this.hUo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hUo.setData(list);
    }
}
