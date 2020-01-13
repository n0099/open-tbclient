package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> apl;
    private r fUA;
    private c hdU;
    private a hft;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fUA = rVar;
        vi();
        this.fUA.addAdapters(this.apl);
    }

    private void vi() {
        this.apl = new ArrayList();
        this.hft = new a(this.mPageContext);
        this.hdU = new c(this.mPageContext);
        this.apl.add(this.hft);
        this.apl.add(this.hdU);
    }

    public void notifyDataSetChanged() {
        if (this.fUA != null) {
            this.fUA.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fUA.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
