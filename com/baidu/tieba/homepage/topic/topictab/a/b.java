package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aoz;
    private r fRq;
    private c har;
    private a hbQ;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fRq = rVar;
        uR();
        this.fRq.addAdapters(this.aoz);
    }

    private void uR() {
        this.aoz = new ArrayList();
        this.hbQ = new a(this.mPageContext);
        this.har = new c(this.mPageContext);
        this.aoz.add(this.hbQ);
        this.aoz.add(this.har);
    }

    public void notifyDataSetChanged() {
        if (this.fRq != null) {
            this.fRq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fRq.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
