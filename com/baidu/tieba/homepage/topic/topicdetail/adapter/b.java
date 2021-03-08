package com.baidu.tieba.homepage.topic.topicdetail.adapter;

import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> boS;
    private s iNH;
    private c kqF;
    private a kqG;
    private com.baidu.tieba.homepage.topic.topictab.a.b kqH;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iNH = sVar;
        Kz();
        this.iNH.addAdapters(this.boS);
    }

    private void Kz() {
        this.boS = new ArrayList();
        this.kqF = new c(this.mPageContext);
        this.kqG = new a(this.mPageContext);
        this.kqH = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.boS.add(this.kqF);
        this.boS.add(this.kqG);
        this.boS.add(this.kqH);
    }

    public void notifyDataSetChanged() {
        if (this.iNH != null) {
            this.iNH.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iNH.setData(list);
    }
}
