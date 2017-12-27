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
    private HTypeListView bRu;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bRu = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.mAdapters.add(new c(this.mTbPageContext, com.baidu.tbadk.data.a.boi));
        this.bRu.addAdapters(this.mAdapters);
    }

    public void setDatas(List<i> list) {
        if (!v.G(list)) {
            this.bRu.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bRu != null && (this.bRu.getAdapter() instanceof r)) {
            ((r) this.bRu.getAdapter()).notifyDataSetChanged();
        }
    }
}
