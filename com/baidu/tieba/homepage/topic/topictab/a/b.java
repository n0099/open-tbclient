package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> agy;
    private r fcN;
    private c gmQ;
    private a gop;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fcN = rVar;
        sY();
        this.fcN.addAdapters(this.agy);
    }

    private void sY() {
        this.agy = new ArrayList();
        this.gop = new a(this.mPageContext);
        this.gmQ = new c(this.mPageContext);
        this.agy.add(this.gop);
        this.agy.add(this.gmQ);
    }

    public void notifyDataSetChanged() {
        if (this.fcN != null) {
            this.fcN.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fcN.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
