package com.baidu.tieba.homepage.topic.topicdetail.adapter;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> boM;
    private s iKI;
    private c kkN;
    private a kkO;
    private com.baidu.tieba.homepage.topic.topictab.a.b kkP;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iKI = sVar;
        MT();
        this.iKI.addAdapters(this.boM);
    }

    private void MT() {
        this.boM = new ArrayList();
        this.kkN = new c(this.mPageContext);
        this.kkO = new a(this.mPageContext);
        this.kkP = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.boM.add(this.kkN);
        this.boM.add(this.kkO);
        this.boM.add(this.kkP);
    }

    public void notifyDataSetChanged() {
        if (this.iKI != null) {
            this.iKI.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iKI.setData(list);
    }
}
