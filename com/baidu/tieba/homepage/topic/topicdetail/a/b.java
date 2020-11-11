package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bky;
    private v imM;
    private c jJl;
    private a jJm;
    private com.baidu.tieba.homepage.topic.topictab.a.b jJn;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.imM = vVar;
        LY();
        this.imM.addAdapters(this.bky);
    }

    private void LY() {
        this.bky = new ArrayList();
        this.jJl = new c(this.mPageContext);
        this.jJm = new a(this.mPageContext);
        this.jJn = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bky.add(this.jJl);
        this.bky.add(this.jJm);
        this.bky.add(this.jJn);
    }

    public void notifyDataSetChanged() {
        if (this.imM != null) {
            this.imM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.imM.setData(list);
    }
}
