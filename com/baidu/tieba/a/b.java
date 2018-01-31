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
    private HTypeListView bRJ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bRJ = hTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.mAdapters.add(new c(this.mTbPageContext, com.baidu.tbadk.data.a.boA));
        this.bRJ.addAdapters(this.mAdapters);
    }

    public void setDatas(List<i> list) {
        if (!v.E(list)) {
            this.bRJ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bRJ != null && (this.bRJ.getAdapter() instanceof r)) {
            ((r) this.bRJ.getAdapter()).notifyDataSetChanged();
        }
    }
}
