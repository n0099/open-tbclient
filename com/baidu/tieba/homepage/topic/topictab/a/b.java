package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> asF;
    private r fWQ;
    private c hgj;
    private a hhH;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fWQ = rVar;
        wM();
        this.fWQ.addAdapters(this.asF);
    }

    private void wM() {
        this.asF = new ArrayList();
        this.hhH = new a(this.mPageContext);
        this.hgj = new c(this.mPageContext);
        this.asF.add(this.hhH);
        this.asF.add(this.hgj);
    }

    public void notifyDataSetChanged() {
        if (this.fWQ != null) {
            this.fWQ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fWQ.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
