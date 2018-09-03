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
    private e dUv;
    private d dUw;
    private c dUx;
    private b dUy;
    private f dUz;
    private m dtp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, m mVar) {
        this.mPageContext = tbPageContext;
        this.dtp = mVar;
        initAdapters();
        this.dtp.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.dUv = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.dUM);
        this.dUw = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.dUI);
        this.dUx = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.dUG);
        this.dUy = new b(this.mPageContext, bb.ahx);
        this.dUz = new f(this.mPageContext, bb.ahA);
        this.mAdapters.add(this.dUv);
        this.mAdapters.add(this.dUw);
        this.mAdapters.add(this.dUx);
        this.mAdapters.add(this.dUy);
        this.mAdapters.add(this.dUz);
    }

    public void notifyDataSetChanged() {
        if (this.dtp != null) {
            this.dtp.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<h> list) {
        this.dtp.setData(list);
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
