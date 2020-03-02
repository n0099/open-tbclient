package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> asE;
    private r fWD;
    private c hfX;
    private a hhv;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fWD = rVar;
        wM();
        this.fWD.addAdapters(this.asE);
    }

    private void wM() {
        this.asE = new ArrayList();
        this.hhv = new a(this.mPageContext);
        this.hfX = new c(this.mPageContext);
        this.asE.add(this.hhv);
        this.asE.add(this.hfX);
    }

    public void notifyDataSetChanged() {
        if (this.fWD != null) {
            this.fWD.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fWD.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
