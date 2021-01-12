package com.baidu.tieba.homepage.topic.topicdetail.adapter;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bjZ;
    private s iGb;
    private c kgh;
    private a kgi;
    private com.baidu.tieba.homepage.topic.topictab.a.b kgj;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iGb = sVar;
        IY();
        this.iGb.addAdapters(this.bjZ);
    }

    private void IY() {
        this.bjZ = new ArrayList();
        this.kgh = new c(this.mPageContext);
        this.kgi = new a(this.mPageContext);
        this.kgj = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.bjZ.add(this.kgh);
        this.bjZ.add(this.kgi);
        this.bjZ.add(this.kgj);
    }

    public void notifyDataSetChanged() {
        if (this.iGb != null) {
            this.iGb.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iGb.setData(list);
    }
}
