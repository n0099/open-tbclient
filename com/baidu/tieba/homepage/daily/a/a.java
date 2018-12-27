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
    private m dSq;
    private e euO;
    private d euP;
    private c euQ;
    private b euR;
    private f euS;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, m mVar) {
        this.mPageContext = tbPageContext;
        this.dSq = mVar;
        initAdapters();
        this.dSq.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.euO = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.evf);
        this.euP = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.evb);
        this.euQ = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.euZ);
        this.euR = new b(this.mPageContext, bb.atg);
        this.euS = new f(this.mPageContext, bb.atj);
        this.mAdapters.add(this.euO);
        this.mAdapters.add(this.euP);
        this.mAdapters.add(this.euQ);
        this.mAdapters.add(this.euR);
        this.mAdapters.add(this.euS);
    }

    public void notifyDataSetChanged() {
        if (this.dSq != null) {
            this.dSq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<h> list) {
        this.dSq.setData(list);
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
