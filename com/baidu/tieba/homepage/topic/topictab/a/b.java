package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r eTY;
    private a ggL;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eTY = rVar;
        initAdapters();
        this.eTY.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.ggL = new a(this.mPageContext);
        this.mAdapters.add(this.ggL);
    }

    public void notifyDataSetChanged() {
        if (this.eTY != null) {
            this.eTY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eTY.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
