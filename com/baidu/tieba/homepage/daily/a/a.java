package com.baidu.tieba.homepage.daily.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private r eTY;
    private e fYE;
    private d fYF;
    private c fYG;
    private b fYH;
    private f fYI;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eTY = rVar;
        initAdapters();
        this.eTY.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.fYE = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.fYW);
        this.fYF = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.fYS);
        this.fYG = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.fYQ);
        this.fYH = new b(this.mPageContext, bg.bIj);
        this.fYI = new f(this.mPageContext, bg.bIx);
        this.mAdapters.add(this.fYE);
        this.mAdapters.add(this.fYF);
        this.mAdapters.add(this.fYG);
        this.mAdapters.add(this.fYH);
        this.mAdapters.add(this.fYI);
    }

    public void notifyDataSetChanged() {
        if (this.eTY != null) {
            this.eTY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.eTY.setData(list);
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
