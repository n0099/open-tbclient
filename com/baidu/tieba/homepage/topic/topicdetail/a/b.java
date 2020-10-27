package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bje;
    private v igO;
    private c jDo;
    private a jDp;
    private com.baidu.tieba.homepage.topic.topictab.a.b jDq;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.igO = vVar;
        Ly();
        this.igO.addAdapters(this.bje);
    }

    private void Ly() {
        this.bje = new ArrayList();
        this.jDo = new c(this.mPageContext);
        this.jDp = new a(this.mPageContext);
        this.jDq = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bje.add(this.jDo);
        this.bje.add(this.jDp);
        this.bje.add(this.jDq);
    }

    public void notifyDataSetChanged() {
        if (this.igO != null) {
            this.igO.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.igO.setData(list);
    }
}
