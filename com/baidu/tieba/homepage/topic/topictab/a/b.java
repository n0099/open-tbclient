package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eEc;
    private c fNZ;
    private a fPB;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eEc = rVar;
        initAdapters();
        this.eEc.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fPB = new a(this.mPageContext);
        this.fNZ = new c(this.mPageContext);
        this.mAdapters.add(this.fPB);
        this.mAdapters.add(this.fNZ);
    }

    public void notifyDataSetChanged() {
        if (this.eEc != null) {
            this.eEc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eEc.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
