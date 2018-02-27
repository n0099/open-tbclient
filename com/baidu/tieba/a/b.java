package com.baidu.tieba.a;

import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private HTypeListView bTD;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bTD = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.mAdapters.add(new c(this.mTbPageContext, com.baidu.tbadk.data.a.bqB));
        this.bTD.addAdapters(this.mAdapters);
    }

    public void setDatas(List<i> list) {
        if (!v.E(list)) {
            this.bTD.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bTD != null && (this.bTD.getAdapter() instanceof r)) {
            ((r) this.bTD.getAdapter()).notifyDataSetChanged();
        }
    }
}
