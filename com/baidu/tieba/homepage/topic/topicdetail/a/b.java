package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bbw;
    private v hyr;
    private c iTj;
    private a iTk;
    private com.baidu.tieba.homepage.topic.topictab.a.b iTl;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hyr = vVar;
        Jv();
        this.hyr.addAdapters(this.bbw);
    }

    private void Jv() {
        this.bbw = new ArrayList();
        this.iTj = new c(this.mPageContext);
        this.iTk = new a(this.mPageContext);
        this.iTl = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bbw.add(this.iTj);
        this.bbw.add(this.iTk);
        this.bbw.add(this.iTl);
    }

    public void notifyDataSetChanged() {
        if (this.hyr != null) {
            this.hyr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hyr.setData(list);
    }
}
