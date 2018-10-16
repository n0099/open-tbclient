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
    private m dHV;
    private e ejH;
    private d ejI;
    private c ejJ;
    private b ejK;
    private f ejL;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, m mVar) {
        this.mPageContext = tbPageContext;
        this.dHV = mVar;
        initAdapters();
        this.dHV.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.ejH = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.ejY);
        this.ejI = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.ejU);
        this.ejJ = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.ejS);
        this.ejK = new b(this.mPageContext, bb.aoS);
        this.ejL = new f(this.mPageContext, bb.aoV);
        this.mAdapters.add(this.ejH);
        this.mAdapters.add(this.ejI);
        this.mAdapters.add(this.ejJ);
        this.mAdapters.add(this.ejK);
        this.mAdapters.add(this.ejL);
    }

    public void notifyDataSetChanged() {
        if (this.dHV != null) {
            this.dHV.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<h> list) {
        this.dHV.setData(list);
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
