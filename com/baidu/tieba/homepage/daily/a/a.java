package com.baidu.tieba.homepage.daily.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private e dUA;
    private d dUB;
    private c dUC;
    private b dUD;
    private f dUE;
    private m dts;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, m mVar) {
        this.mPageContext = tbPageContext;
        this.dts = mVar;
        initAdapters();
        this.dts.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.dUA = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.dUR);
        this.dUB = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.dUN);
        this.dUC = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.dUL);
        this.dUD = new b(this.mPageContext, bb.ahx);
        this.dUE = new f(this.mPageContext, bb.ahA);
        this.mAdapters.add(this.dUA);
        this.mAdapters.add(this.dUB);
        this.mAdapters.add(this.dUC);
        this.mAdapters.add(this.dUD);
        this.mAdapters.add(this.dUE);
    }

    public void notifyDataSetChanged() {
        if (this.dts != null) {
            this.dts.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<h> list) {
        this.dts.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
