package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> agQ;
    private r fdE;
    private c gnH;
    private a gpg;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fdE = rVar;
        sX();
        this.fdE.addAdapters(this.agQ);
    }

    private void sX() {
        this.agQ = new ArrayList();
        this.gpg = new a(this.mPageContext);
        this.gnH = new c(this.mPageContext);
        this.agQ.add(this.gpg);
        this.agQ.add(this.gnH);
    }

    public void notifyDataSetChanged() {
        if (this.fdE != null) {
            this.fdE.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fdE.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
