package com.baidu.tieba.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private HTypeListView djb;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.djb = hTypeListView;
        sX();
    }

    private void sX() {
        this.agQ.add(new c(this.mTbPageContext, com.baidu.tbadk.data.a.cDI));
        this.djb.addAdapters(this.agQ);
    }

    public void setDatas(List<m> list) {
        if (!v.isEmpty(list)) {
            this.djb.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.djb != null && (this.djb.getAdapter() instanceof com.baidu.adp.widget.ListView.v)) {
            ((com.baidu.adp.widget.ListView.v) this.djb.getAdapter()).notifyDataSetChanged();
        }
    }
}
