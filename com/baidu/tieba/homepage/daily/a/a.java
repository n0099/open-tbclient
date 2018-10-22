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
    private e ejI;
    private d ejJ;
    private c ejK;
    private b ejL;
    private f ejM;
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
        this.ejI = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.ejZ);
        this.ejJ = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.ejV);
        this.ejK = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.ejT);
        this.ejL = new b(this.mPageContext, bb.aoS);
        this.ejM = new f(this.mPageContext, bb.aoV);
        this.mAdapters.add(this.ejI);
        this.mAdapters.add(this.ejJ);
        this.mAdapters.add(this.ejK);
        this.mAdapters.add(this.ejL);
        this.mAdapters.add(this.ejM);
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
