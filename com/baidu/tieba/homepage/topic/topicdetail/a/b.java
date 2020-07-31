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
    private c iEd;
    private a iEe;
    private com.baidu.tieba.homepage.topic.topictab.a.b iEf;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hlu = vVar;
        DS();
        this.hlu.addAdapters(this.aWf);
    }

    private void DS() {
        this.aWf = new ArrayList();
        this.iEd = new c(this.mPageContext);
        this.iEe = new a(this.mPageContext);
        this.iEf = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.aWf.add(this.iEd);
        this.aWf.add(this.iEe);
        this.aWf.add(this.iEf);
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
