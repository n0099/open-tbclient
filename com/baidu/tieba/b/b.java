package com.baidu.tieba.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private HTypeListView bnZ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bnZ = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.mAdapters.add(new c(this.mTbPageContext, com.baidu.tbadk.data.a.aKC));
        this.bnZ.addAdapters(this.mAdapters);
    }

    public void setDatas(List<h> list) {
        if (!w.z(list)) {
            this.bnZ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bnZ != null && (this.bnZ.getAdapter() instanceof q)) {
            ((q) this.bnZ.getAdapter()).notifyDataSetChanged();
        }
    }
}
