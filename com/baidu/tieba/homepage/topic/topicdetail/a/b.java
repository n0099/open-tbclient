package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aWf;
    private v hlu;
    private c iEf;
    private a iEg;
    private com.baidu.tieba.homepage.topic.topictab.a.b iEh;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hlu = vVar;
        DS();
        this.hlu.addAdapters(this.aWf);
    }

    private void DS() {
        this.aWf = new ArrayList();
        this.iEf = new c(this.mPageContext);
        this.iEg = new a(this.mPageContext);
        this.iEh = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.aWf.add(this.iEf);
        this.aWf.add(this.iEg);
        this.aWf.add(this.iEh);
    }

    public void notifyDataSetChanged() {
        if (this.hlu != null) {
            this.hlu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hlu.setData(list);
    }
}
