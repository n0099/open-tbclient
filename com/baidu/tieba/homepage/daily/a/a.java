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
    private m dTa;
    private e evv;
    private d evw;
    private c evx;
    private b evy;
    private f evz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, m mVar) {
        this.mPageContext = tbPageContext;
        this.dTa = mVar;
        initAdapters();
        this.dTa.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.evv = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.evM);
        this.evw = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.evI);
        this.evx = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.evG);
        this.evy = new b(this.mPageContext, bb.atJ);
        this.evz = new f(this.mPageContext, bb.atM);
        this.mAdapters.add(this.evv);
        this.mAdapters.add(this.evw);
        this.mAdapters.add(this.evx);
        this.mAdapters.add(this.evy);
        this.mAdapters.add(this.evz);
    }

    public void notifyDataSetChanged() {
        if (this.dTa != null) {
            this.dTa.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<h> list) {
        this.dTa.setData(list);
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
