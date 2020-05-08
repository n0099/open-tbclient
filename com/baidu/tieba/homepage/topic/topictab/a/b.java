package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aMj;
    private r gEi;
    private c hRz;
    private a hSX;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.gEi = rVar;
        BB();
        this.gEi.addAdapters(this.aMj);
    }

    private void BB() {
        this.aMj = new ArrayList();
        this.hSX = new a(this.mPageContext);
        this.hRz = new c(this.mPageContext);
        this.aMj.add(this.hSX);
        this.aMj.add(this.hRz);
    }

    public void notifyDataSetChanged() {
        if (this.gEi != null) {
            this.gEi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.gEi.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
