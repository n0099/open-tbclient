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
    private m dzV;
    private e ebO;
    private d ebP;
    private c ebQ;
    private b ebR;
    private f ebS;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, m mVar) {
        this.mPageContext = tbPageContext;
        this.dzV = mVar;
        initAdapters();
        this.dzV.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.ebO = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.ecf);
        this.ebP = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.ecb);
        this.ebQ = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.ebZ);
        this.ebR = new b(this.mPageContext, bb.ajX);
        this.ebS = new f(this.mPageContext, bb.aka);
        this.mAdapters.add(this.ebO);
        this.mAdapters.add(this.ebP);
        this.mAdapters.add(this.ebQ);
        this.mAdapters.add(this.ebR);
        this.mAdapters.add(this.ebS);
    }

    public void notifyDataSetChanged() {
        if (this.dzV != null) {
            this.dzV.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<h> list) {
        this.dzV.setData(list);
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
