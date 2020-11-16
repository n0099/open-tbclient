package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> biN;
    private v inB;
    private c jJW;
    private a jJX;
    private com.baidu.tieba.homepage.topic.topictab.a.b jJY;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.inB = vVar;
        Lp();
        this.inB.addAdapters(this.biN);
    }

    private void Lp() {
        this.biN = new ArrayList();
        this.jJW = new c(this.mPageContext);
        this.jJX = new a(this.mPageContext);
        this.jJY = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.biN.add(this.jJW);
        this.biN.add(this.jJX);
        this.biN.add(this.jJY);
    }

    public void notifyDataSetChanged() {
        if (this.inB != null) {
            this.inB.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.inB.setData(list);
    }
}
