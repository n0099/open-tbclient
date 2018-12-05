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
    private m dPC;
    private e erX;
    private d erY;
    private c erZ;
    private b esa;
    private f esb;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, m mVar) {
        this.mPageContext = tbPageContext;
        this.dPC = mVar;
        initAdapters();
        this.dPC.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.erX = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.eso);
        this.erY = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.esk);
        this.erZ = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.esi);
        this.esa = new b(this.mPageContext, bb.atg);
        this.esb = new f(this.mPageContext, bb.atj);
        this.mAdapters.add(this.erX);
        this.mAdapters.add(this.erY);
        this.mAdapters.add(this.erZ);
        this.mAdapters.add(this.esa);
        this.mAdapters.add(this.esb);
    }

    public void notifyDataSetChanged() {
        if (this.dPC != null) {
            this.dPC.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<h> list) {
        this.dPC.setData(list);
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
