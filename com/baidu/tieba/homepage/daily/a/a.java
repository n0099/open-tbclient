package com.baidu.tieba.homepage.daily.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private m dSZ;
    private e evu;
    private d evv;
    private c evw;
    private b evx;
    private f evy;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, m mVar) {
        this.mPageContext = tbPageContext;
        this.dSZ = mVar;
        initAdapters();
        this.dSZ.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.evu = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.evL);
        this.evv = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.evH);
        this.evw = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.evF);
        this.evx = new b(this.mPageContext, bb.atI);
        this.evy = new f(this.mPageContext, bb.atL);
        this.mAdapters.add(this.evu);
        this.mAdapters.add(this.evv);
        this.mAdapters.add(this.evw);
        this.mAdapters.add(this.evx);
        this.mAdapters.add(this.evy);
    }

    public void notifyDataSetChanged() {
        if (this.dSZ != null) {
            this.dSZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<h> list) {
        this.dSZ.setData(list);
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
