package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eYZ;
    private c glz;
    private a gmY;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eYZ = rVar;
        initAdapters();
        this.eYZ.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.gmY = new a(this.mPageContext);
        this.glz = new c(this.mPageContext);
        this.mAdapters.add(this.gmY);
        this.mAdapters.add(this.glz);
    }

    public void notifyDataSetChanged() {
        if (this.eYZ != null) {
            this.eYZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eYZ.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
