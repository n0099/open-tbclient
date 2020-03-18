package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> asP;
    private r fXy;
    private c hhJ;
    private a hji;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fXy = rVar;
        wR();
        this.fXy.addAdapters(this.asP);
    }

    private void wR() {
        this.asP = new ArrayList();
        this.hji = new a(this.mPageContext);
        this.hhJ = new c(this.mPageContext);
        this.asP.add(this.hji);
        this.asP.add(this.hhJ);
    }

    public void notifyDataSetChanged() {
        if (this.fXy != null) {
            this.fXy.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fXy.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
