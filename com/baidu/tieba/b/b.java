package com.baidu.tieba.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private HTypeListView cOb;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.cOb = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.mAdapters.add(new c(this.mTbPageContext, com.baidu.tbadk.data.a.cgN));
        this.cOb.addAdapters(this.mAdapters);
    }

    public void setDatas(List<m> list) {
        if (!v.T(list)) {
            this.cOb.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.cOb != null && (this.cOb.getAdapter() instanceof com.baidu.adp.widget.ListView.v)) {
            ((com.baidu.adp.widget.ListView.v) this.cOb.getAdapter()).notifyDataSetChanged();
        }
    }
}
