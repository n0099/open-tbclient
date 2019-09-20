package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private r faT;
    private c goi;
    private a gpH;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.faT = rVar;
        initAdapters();
        this.faT.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.gpH = new a(this.mPageContext);
        this.goi = new c(this.mPageContext);
        this.mAdapters.add(this.gpH);
        this.mAdapters.add(this.goi);
    }

    public void notifyDataSetChanged() {
        if (this.faT != null) {
            this.faT.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.faT.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
