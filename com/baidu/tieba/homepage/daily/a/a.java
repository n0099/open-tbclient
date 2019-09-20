package com.baidu.tieba.homepage.daily.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private r faT;
    private e ggj;
    private d ggk;
    private c ggl;
    private b ggm;
    private f ggn;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.faT = rVar;
        initAdapters();
        this.faT.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.ggj = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.ggB);
        this.ggk = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.ggx);
        this.ggl = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.ggv);
        this.ggm = new b(this.mPageContext, bh.bJM);
        this.ggn = new f(this.mPageContext, bh.bKa);
        this.mAdapters.add(this.ggj);
        this.mAdapters.add(this.ggk);
        this.mAdapters.add(this.ggl);
        this.mAdapters.add(this.ggm);
        this.mAdapters.add(this.ggn);
    }

    public void notifyDataSetChanged() {
        if (this.faT != null) {
            this.faT.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.faT.setData(list);
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
