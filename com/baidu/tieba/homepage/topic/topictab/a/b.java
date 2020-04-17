package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aMd;
    private r gEc;
    private c hRt;
    private a hSR;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.gEc = rVar;
        BC();
        this.gEc.addAdapters(this.aMd);
    }

    private void BC() {
        this.aMd = new ArrayList();
        this.hSR = new a(this.mPageContext);
        this.hRt = new c(this.mPageContext);
        this.aMd.add(this.hSR);
        this.aMd.add(this.hRt);
    }

    public void notifyDataSetChanged() {
        if (this.gEc != null) {
            this.gEc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.gEc.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
