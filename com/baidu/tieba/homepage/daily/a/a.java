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
    private List<com.baidu.adp.widget.ListView.a> agQ;
    private r fdE;
    private e gfG;
    private d gfH;
    private c gfI;
    private b gfJ;
    private f gfK;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fdE = rVar;
        sX();
        this.fdE.addAdapters(this.agQ);
    }

    private void sX() {
        this.agQ = new ArrayList();
        this.gfG = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.gfY);
        this.gfH = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.gfU);
        this.gfI = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.gfS);
        this.gfJ = new b(this.mPageContext, bh.cbu);
        this.gfK = new f(this.mPageContext, bh.cbI);
        this.agQ.add(this.gfG);
        this.agQ.add(this.gfH);
        this.agQ.add(this.gfI);
        this.agQ.add(this.gfJ);
        this.agQ.add(this.gfK);
    }

    public void notifyDataSetChanged() {
        if (this.fdE != null) {
            this.fdE.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fdE.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
