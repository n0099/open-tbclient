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
    private r fWB;
    private c hfV;
    private a hht;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fWB = rVar;
        wM();
        this.fWB.addAdapters(this.asE);
    }

    private void wM() {
        this.asE = new ArrayList();
        this.hht = new a(this.mPageContext);
        this.hfV = new c(this.mPageContext);
        this.asE.add(this.hht);
        this.asE.add(this.hfV);
    }

    public void notifyDataSetChanged() {
        if (this.fWB != null) {
            this.fWB.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fWB.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
