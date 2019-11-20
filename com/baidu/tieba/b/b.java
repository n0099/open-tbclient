package com.baidu.tieba.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private HTypeListView dij;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.dij = hTypeListView;
        sY();
    }

    private void sY() {
        this.agy.add(new c(this.mTbPageContext, com.baidu.tbadk.data.a.cCR));
        this.dij.addAdapters(this.agy);
    }

    public void setDatas(List<m> list) {
        if (!v.isEmpty(list)) {
            this.dij.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.dij != null && (this.dij.getAdapter() instanceof com.baidu.adp.widget.ListView.v)) {
            ((com.baidu.adp.widget.ListView.v) this.dij.getAdapter()).notifyDataSetChanged();
        }
    }
}
